package com.ruoyi.dm.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.agro.domain.AgroLivestock;
import com.ruoyi.agro.service.impl.AgroLivestockServiceImpl;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.mqtt.Mqttobj;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.dm.domain.DmData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dm.mapper.DmAlarmDataMapper;
import com.ruoyi.dm.domain.DmAlarmData;
import com.ruoyi.dm.service.IDmAlarmDataService;

/**
 * 报警数据Service业务层处理
 * 
 * @author 罗晨熙
 * @date 2024-04-24
 */
@Service
public class DmAlarmDataServiceImpl implements IDmAlarmDataService 
{
    @Autowired
    private DmAlarmDataMapper dmAlarmDataMapper;
    @Autowired
    private AgroLivestockServiceImpl agroLivestockServiceImpl;

    /**
     * 查询报警数据
     * 
     * @param id 报警数据主键
     * @return 报警数据
     */
    @Override
    public DmAlarmData selectDmAlarmDataById(String id)
    {
        return dmAlarmDataMapper.selectDmAlarmDataById(id);
    }

    /**
     * 查询报警数据列表
     * 
     * @param dmAlarmData 报警数据
     * @return 报警数据
     */
    @Override
    @DataScope(deptAlias = "t" ,userAlias = "t")
    public List<DmAlarmData> selectDmAlarmDataList(DmAlarmData dmAlarmData)
    {
        return dmAlarmDataMapper.selectDmAlarmDataList(dmAlarmData);
    }

    /**
     * 新增报警数据
     * 
     * @param dmAlarmData 报警数据
     * @return 结果
     */
    @Override
    public int insertDmAlarmData(DmAlarmData dmAlarmData)
    {
        dmAlarmData.setCreateTime(DateUtils.getNowDate());
        return dmAlarmDataMapper.insertDmAlarmData(dmAlarmData);
    }

    /**
     * 修改报警数据
     * 
     * @param dmAlarmData 报警数据
     * @return 结果
     */
    @Override
    public int updateDmAlarmData(DmAlarmData dmAlarmData)
    {
        dmAlarmData.setUpdateTime(DateUtils.getNowDate());
        return dmAlarmDataMapper.updateDmAlarmData(dmAlarmData);
    }

    /**
     * 批量删除报警数据
     * 
     * @param ids 需要删除的报警数据主键
     * @return 结果
     */
    @Override
    public int deleteDmAlarmDataByIds(String[] ids)
    {
        return dmAlarmDataMapper.deleteDmAlarmDataByIds(ids);
    }

    /**
     * 删除报警数据信息
     * 
     * @param id 报警数据主键
     * @return 结果
     */
    @Override
    public int deleteDmAlarmDataById(String id)
    {
        return dmAlarmDataMapper.deleteDmAlarmDataById(id);
    }

    /**
     * 新增报警数据
     * @param mqttobj
     * @return
     * @throws JsonProcessingException
     */
    @Override
    public String deviceInsertAlarmData(Mqttobj mqttobj) throws JsonProcessingException {
        // 处理 MQTT 消息的业务逻辑
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(mqttobj.getMsg());
        DmAlarmData dmAlarmData = new DmAlarmData();
        BigDecimal temperature = new BigDecimal(jsonNode.get("temperature").asText());
        dmAlarmData.setTemperature(temperature);

        BigDecimal lowerLimit = new BigDecimal("38.5");
        BigDecimal upperLimit = new BigDecimal("39.5");

        if (temperature.compareTo(lowerLimit) < 0 || temperature.compareTo(upperLimit) > 0) {
            dmAlarmData.setAgroLivestockCode(jsonNode.get("agroLivestockCode").asText());
            dmAlarmData.setAgroLivestockIccid(jsonNode.get("agroLivestockIccid").asText());
            dmAlarmData.setAgroLivestockXqiccid(jsonNode.get("agroLivestockXqiccid").asText());
            dmAlarmData.setDeviceType(jsonNode.get("deviceType").asText());
            BigDecimal drycell = new BigDecimal(jsonNode.get("drycell").asText());
            dmAlarmData.setDrycell(drycell);
            dmAlarmData.setImei(jsonNode.get("imei").asText());
            dmAlarmData.setDeviceId(jsonNode.get("deviceId").asText());
            dmAlarmData.setStep(jsonNode.get("step").asText());
            BigDecimal weight = new BigDecimal(jsonNode.get("weight").asText());
            dmAlarmData.setWeight(weight);
            dmAlarmData.setLivestockLon(jsonNode.get("livestockLon").asText());
            dmAlarmData.setLivestockLat(jsonNode.get("livestockLat").asText());
            dmAlarmData.setRsrp(Long.parseLong(jsonNode.get("rsrp").asText()));
            dmAlarmData.setEcl(Long.parseLong(jsonNode.get("ecl").asText()));
            dmAlarmData.setRsrq(Long.parseLong(jsonNode.get("rsrq").asText()));
            dmAlarmData.setSnr(Long.parseLong(jsonNode.get("snr").asText()));
            dmAlarmData.setCellid(jsonNode.get("cellid").asText());
            dmAlarmData.setPci(jsonNode.get("pci").asText());
            dmAlarmData.setCreateTime(DateUtils.parseDate(DateUtils.getTime()));
            dmAlarmData.setId(IdUtils.randomUUID());
            dmAlarmData.setInfo("体温报警");
            // 温度在指定范围内，设定为报警数据
            // 进行相应的处理
            AgroLivestock agroLivestock = agroLivestockServiceImpl.selectAgroLivestockByIccid(dmAlarmData.getAgroLivestockIccid());
            if (agroLivestock == null) {
                dmAlarmDataMapper.insertDmAlarmData(dmAlarmData);
            } else {
                dmAlarmData.setInfo("体温报警");
                dmAlarmData.setAgroUserId(agroLivestock.getAgroUserId());
                dmAlarmData.setAgroUserName(agroLivestock.getAgroUserName());
                dmAlarmData.setAgroLivestockId(agroLivestock.getId());
                dmAlarmData.setAgroLivestockCode(agroLivestock.getCode());
                dmAlarmData.setAgroLivestockXqiccid(agroLivestock.getXqIccid());
                dmAlarmData.setUserId(agroLivestock.getUserId());
                dmAlarmData.setDeptId(agroLivestock.getDeptId());
                dmAlarmDataMapper.insertDmAlarmData(dmAlarmData);
            }
        }


        return null;
    }

    @Override
    @DataScope(deptAlias = "t" ,userAlias = "t")
    public List<DmAlarmData> selectDmAlarmIndexDataList(DmAlarmData dmAlarmData) {
        return dmAlarmDataMapper.selectDmAlarmIndexDataList(dmAlarmData) ;   }

}
