package com.ruoyi.dm.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.agro.domain.AgroLivestock;
import com.ruoyi.agro.service.impl.AgroLivestockServiceImpl;
import com.ruoyi.common.Business.BusinessService;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.mqtt.Mqttobj;
import com.ruoyi.common.utils.uuid.IdUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dm.mapper.DmDataMapper;
import com.ruoyi.dm.domain.DmData;
import com.ruoyi.dm.service.IDmDataService;

/**
 * 全部数据Service业务层处理
 *
 * @author 罗晨熙
 * @date 2024-03-19
 */
@Service
public class DmDataServiceImpl implements IDmDataService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DmDataServiceImpl.class);
    @Autowired
    private DmDataMapper dmDataMapper;
    @Autowired
    private AgroLivestockServiceImpl agroLivestockServiceImpl;

    /**
     * 查询全部数据
     *
     * @param id 全部数据主键
     * @return 全部数据
     */
    @Override
    public DmData selectDmDataById(String id) {
        return dmDataMapper.selectDmDataById(id);
    }

    /**
     * 查询全部数据列表
     *
     * @param dmData 全部数据
     * @return 全部数据
     */
    @Override
    @DataScope(deptAlias = "t" ,userAlias = "t")
    public List<DmData> selectDmDataList(DmData dmData) {
        return dmDataMapper.selectDmDataList(dmData);
    }

    /**
     * 新增全部数据
     *
     * @param dmData 全部数据
     * @return 结果
     */
    @Override
    public int insertDmData(DmData dmData) {
        dmData.setCreateTime(DateUtils.getNowDate());
        dmData.setId(IdUtils.randomUUID());

        return dmDataMapper.insertDmData(dmData);
    }

    /**
     * 修改全部数据
     *
     * @param dmData 全部数据
     * @return 结果
     */
    @Override
    public int updateDmData(DmData dmData) {
        dmData.setUpdateTime(DateUtils.getNowDate());
        return dmDataMapper.updateDmData(dmData);
    }

    /**
     * 批量删除全部数据
     *
     * @param ids 需要删除的全部数据主键
     * @return 结果
     */
    @Override
    public int deleteDmDataByIds(String[] ids) {
        return dmDataMapper.deleteDmDataByIds(ids);
    }

    /**
     * 删除全部数据信息
     *
     * @param id 全部数据主键
     * @return 结果
     */
    @Override
    public int deleteDmDataById(String id) {
        return dmDataMapper.deleteDmDataById(id);
    }


    /**
     * 全部设备数据处理
     *
     * @param mqttobj
     * @return
     */
    @Override
    public String deviceInsertDmData(Mqttobj mqttobj) throws JsonProcessingException {
        // 处理 MQTT 消息的业务逻辑
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(mqttobj.getMsg());
        DmData dmData = new DmData();
        dmData.setAgroLivestockCode(jsonNode.get("agroLivestockCode").asText());
        dmData.setAgroLivestockIccid(jsonNode.get("agroLivestockIccid").asText());
        dmData.setAgroLivestockXqiccid(jsonNode.get("agroLivestockXqiccid").asText());
        dmData.setDeviceType(jsonNode.get("deviceType").asText());
        BigDecimal drycell = new BigDecimal(jsonNode.get("drycell").asText());
        dmData.setDrycell(drycell);
        dmData.setImei(jsonNode.get("imei").asText());
        dmData.setDeviceId(jsonNode.get("deviceId").asText());
        BigDecimal temperature = new BigDecimal(jsonNode.get("temperature").asText());
        dmData.setTemperature(temperature);

        dmData.setStep(jsonNode.get("step").asText());
        BigDecimal weight = new BigDecimal(jsonNode.get("weight").asText());
        dmData.setWeight(weight);
        dmData.setLivestockLon(jsonNode.get("livestockLon").asText());
        dmData.setLivestockLat(jsonNode.get("livestockLat").asText());
        dmData.setRsrp(Long.parseLong(jsonNode.get("rsrp").asText()));
        dmData.setEcl(Long.parseLong(jsonNode.get("ecl").asText()));
        dmData.setRsrq(Long.parseLong(jsonNode.get("rsrq").asText()));
        dmData.setSnr(Long.parseLong(jsonNode.get("snr").asText()));
        dmData.setCellid(jsonNode.get("cellid").asText());
        dmData.setPci(jsonNode.get("pci").asText());
        dmData.setCreateTime(DateUtils.parseDate(DateUtils.getTime()));
        dmData.setId(IdUtils.randomUUID());
        AgroLivestock agroLivestock = agroLivestockServiceImpl.selectAgroLivestockByIccid(dmData.getAgroLivestockIccid());
        if (agroLivestock == null) {
            dmDataMapper.insertDmData(dmData);
        } else {
            dmData.setAgroUserId(agroLivestock.getAgroUserId());
            dmData.setAgroUserName(agroLivestock.getAgroUserName());
            dmData.setAgroLivestockId(agroLivestock.getId());
            dmData.setAgroLivestockCode(agroLivestock.getCode());
            dmData.setAgroLivestockXqiccid(agroLivestock.getXqIccid());
            dmData.setUserId(agroLivestock.getUserId());
            dmData.setDeptId(agroLivestock.getDeptId());
            dmDataMapper.insertDmData(dmData);
        }
        return null;
    }
}
