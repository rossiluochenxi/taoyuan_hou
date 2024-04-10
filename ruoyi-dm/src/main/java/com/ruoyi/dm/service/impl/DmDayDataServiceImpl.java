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
import com.ruoyi.dm.mapper.DmDayDataMapper;
import com.ruoyi.dm.domain.DmDayData;
import com.ruoyi.dm.service.IDmDayDataService;

/**
 * 每天数据Service业务层处理
 *
 * @author 罗晨熙
 * @date 2024-03-19
 */
@Service
public class DmDayDataServiceImpl implements IDmDayDataService {
    @Autowired
    private DmDayDataMapper dmDayDataMapper;
    @Autowired
    private AgroLivestockServiceImpl agroLivestockServiceImpl;

    /**
     * 查询每天数据
     *
     * @param id 每天数据主键
     * @return 每天数据
     */
    @Override
    public DmDayData selectDmDayDataById(String id) {
        return dmDayDataMapper.selectDmDayDataById(id);
    }

    /**
     * 查询每天数据列表
     *
     * @param dmDayData 每天数据
     * @return 每天数据
     */
    @Override
    @DataScope(deptAlias = "t" ,userAlias = "t")
    public List<DmDayData> selectDmDayDataList(DmDayData dmDayData) {
        return dmDayDataMapper.selectDmDayDataList(dmDayData);
    }

    /**
     * 新增每天数据
     *
     * @param dmDayData 每天数据
     * @return 结果
     */
    @Override
    public int insertDmDayData(DmDayData dmDayData) {
        dmDayData.setCreateTime(DateUtils.getNowDate());
        return dmDayDataMapper.insertDmDayData(dmDayData);
    }

    /**
     * 修改每天数据
     *
     * @param dmDayData 每天数据
     * @return 结果
     */
    @Override
    public int updateDmDayData(DmDayData dmDayData) {
        dmDayData.setUpdateTime(DateUtils.getNowDate());
        return dmDayDataMapper.updateDmDayData(dmDayData);
    }

    /**
     * 批量删除每天数据
     *
     * @param ids 需要删除的每天数据主键
     * @return 结果
     */
    @Override
    public int deleteDmDayDataByIds(String[] ids) {
        return dmDayDataMapper.deleteDmDayDataByIds(ids);
    }

    /**
     * 删除每天数据信息
     *
     * @param id 每天数据主键
     * @return 结果
     */
    @Override
    public int deleteDmDayDataById(String id) {
        return dmDayDataMapper.deleteDmDayDataById(id);
    }


    /**
     * 每天设备数据处理
     *
     * @param mqttobj
     * @return
     */
    @Override
    public String deviceInsertDmDayData(Mqttobj mqttobj) throws JsonProcessingException {
        // 处理 MQTT 消息的业务逻辑
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(mqttobj.getMsg());
        DmDayData dmDayData = new DmDayData();
//        dmDayData.setAgroLivestockCode(jsonNode.get("agroLivestockCode").asText());
        dmDayData.setAgroLivestockIccid(jsonNode.get("agroLivestockIccid").asText());
        dmDayData.setAgroLivestockXqiccid(jsonNode.get("agroLivestockXqiccid").asText());
        dmDayData.setDeviceType(jsonNode.get("deviceType").asText());
        BigDecimal drycell = new BigDecimal(jsonNode.get("drycell").asText());
        dmDayData.setDrycell(drycell);
        dmDayData.setImei(jsonNode.get("imei").asText());
        dmDayData.setDeviceId(jsonNode.get("deviceId").asText());
        BigDecimal temperature = new BigDecimal(jsonNode.get("temperature").asText());
        dmDayData.setTemperature(temperature);
        dmDayData.setStep(jsonNode.get("step").asText());
        BigDecimal weight = new BigDecimal(jsonNode.get("weight").asText());
        dmDayData.setWeight(weight);
        dmDayData.setLivestockLon(jsonNode.get("livestockLon").asText());
        dmDayData.setLivestockLat(jsonNode.get("livestockLat").asText());
        dmDayData.setRsrp(Long.parseLong(jsonNode.get("rsrp").asText()));
        dmDayData.setEcl(Long.parseLong(jsonNode.get("ecl").asText()));
        dmDayData.setRsrq(Long.parseLong(jsonNode.get("rsrq").asText()));
        dmDayData.setSnr(Long.parseLong(jsonNode.get("snr").asText()));
        dmDayData.setCellid(jsonNode.get("cellid").asText());
        dmDayData.setPci(jsonNode.get("pci").asText());
        dmDayData.setCreateTime(DateUtils.parseDate(DateUtils.getTime()));
        dmDayData.setId(IdUtils.randomUUID());
        dmDayData.setDate(DateUtils.parseDate(DateUtils.getDate()));
        AgroLivestock agroLivestock = agroLivestockServiceImpl.selectAgroLivestockByIccid(dmDayData.getAgroLivestockIccid());
        if (agroLivestock == null) {
            dmDayDataMapper.insertOrUpdateDmDayData(dmDayData);
        } else {
            dmDayData.setAgroUserId(agroLivestock.getAgroUserId());
            dmDayData.setAgroUserName(agroLivestock.getAgroUserName());
            dmDayData.setAgroLivestockId(agroLivestock.getId());
            dmDayData.setAgroLivestockCode(agroLivestock.getCode());
            dmDayData.setAgroLivestockXqiccid(agroLivestock.getXqIccid());
            dmDayData.setUserId(agroLivestock.getUserId());
            dmDayData.setDeptId(agroLivestock.getDeptId());

            dmDayDataMapper.insertOrUpdateDmDayData(dmDayData);
            // agroLivestock 对象不为 null
            System.out.println("agroLivestock 对象不为 null");
        }
        return null;
    }
}
