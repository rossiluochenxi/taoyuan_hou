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
import com.ruoyi.dm.domain.DmDayData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dm.mapper.DmRtdataMapper;
import com.ruoyi.dm.domain.DmRtdata;
import com.ruoyi.dm.service.IDmRtdataService;

/**
 * 冻结数据Service业务层处理
 *
 * @author 罗晨熙
 * @date 2024-03-16
 */
@Service
public class DmRtdataServiceImpl implements IDmRtdataService {
    @Autowired
    private DmRtdataMapper dmRtdataMapper;
    @Autowired
    private AgroLivestockServiceImpl agroLivestockServiceImpl;


    /**
     * 查询冻结数据
     *
     * @param id 冻结数据主键
     * @return 冻结数据
     */
    @Override
    public DmRtdata selectDmRtdataById(String id) {
        return dmRtdataMapper.selectDmRtdataById(id);
    }

    /**
     * 查询冻结数据列表
     *
     * @param dmRtdata 冻结数据
     * @return 冻结数据
     */
    @Override
    @DataScope(deptAlias = "t" ,userAlias = "t")
    public List<DmRtdata> selectDmRtdataList(DmRtdata dmRtdata) {
        return dmRtdataMapper.selectDmRtdataList(dmRtdata);
    }

    /**
     * 新增冻结数据
     *
     * @param dmRtdata 冻结数据
     * @return 结果
     */
    @Override
    public int insertDmRtdata(DmRtdata dmRtdata) {
        dmRtdata.setCreateTime(DateUtils.getNowDate());
        dmRtdata.setId(IdUtils.randomUUID());
        return dmRtdataMapper.insertDmRtdata(dmRtdata);
    }


    /**
     * 修改冻结数据
     *
     * @param dmRtdata 冻结数据
     * @return 结果
     */
    @Override
    public int updateDmRtdata(DmRtdata dmRtdata) {
        dmRtdata.setUpdateTime(DateUtils.getNowDate());
        return dmRtdataMapper.updateDmRtdata(dmRtdata);
    }

    /**
     * 批量删除冻结数据
     *
     * @param ids 需要删除的冻结数据主键
     * @return 结果
     */
    @Override
    public int deleteDmRtdataByIds(String[] ids) {
        return dmRtdataMapper.deleteDmRtdataByIds(ids);
    }

    /**
     * 删除冻结数据信息
     *
     * @param id 冻结数据主键
     * @return 结果
     */
    @Override
    public int deleteDmRtdataById(String id) {
        return dmRtdataMapper.deleteDmRtdataById(id);
    }


    /**
     * 冻结数据处理
     *
     * @param mqttobj
     * @return
     */
    @Override
    public String deviceInsertDmRtdata(Mqttobj mqttobj) throws JsonProcessingException {
        // 处理 MQTT 消息的业务逻辑
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(mqttobj.getMsg());
        DmRtdata dmRtdata = new DmRtdata();
        dmRtdata.setAgroLivestockCode(jsonNode.get("agroLivestockCode").asText());
        dmRtdata.setAgroLivestockIccid(jsonNode.get("agroLivestockIccid").asText());
        dmRtdata.setAgroLivestockXqiccid(jsonNode.get("agroLivestockXqiccid").asText());
        dmRtdata.setImei(jsonNode.get("imei").asText());
        dmRtdata.setDeviceId(jsonNode.get("deviceId").asText());
        BigDecimal temperature = new BigDecimal(jsonNode.get("temperature").asText());
        dmRtdata.setTemperature(temperature);
        dmRtdata.setStep(jsonNode.get("step").asText());
        BigDecimal weight = new BigDecimal(jsonNode.get("weight").asText());
        dmRtdata.setWeight(weight);
        dmRtdata.setLivestockLon(jsonNode.get("livestockLon").asText());
        dmRtdata.setLivestockLat(jsonNode.get("livestockLat").asText());
        dmRtdata.setRsrp(Long.parseLong(jsonNode.get("rsrp").asText()));
        dmRtdata.setEcl(Long.parseLong(jsonNode.get("ecl").asText()));
        dmRtdata.setRsrq(Long.parseLong(jsonNode.get("rsrq").asText()));
        dmRtdata.setSnr(Long.parseLong(jsonNode.get("snr").asText()));
        dmRtdata.setCellid(jsonNode.get("cellid").asText());
        dmRtdata.setPci(jsonNode.get("pci").asText());
        dmRtdata.setCreateTime(DateUtils.parseDate(DateUtils.getTime()));
        dmRtdata.setId(IdUtils.randomUUID());
        AgroLivestock agroLivestock = agroLivestockServiceImpl.selectAgroLivestockByIccid(dmRtdata.getAgroLivestockIccid());
        if (agroLivestock == null) {
            dmRtdataMapper.insertOrUpdateDmRtdata(dmRtdata);
        } else {
            dmRtdata.setAgroUserId(agroLivestock.getAgroUserId());
            dmRtdata.setAgroUserName(agroLivestock.getAgroUserName());
            dmRtdata.setAgroLivestockId(agroLivestock.getId());
            dmRtdata.setAgroLivestockCode(agroLivestock.getCode());
            dmRtdata.setAgroLivestockXqiccid(agroLivestock.getXqIccid());
            dmRtdata.setUserId(agroLivestock.getUserId());
            dmRtdata.setDeptId(agroLivestock.getDeptId());
            dmRtdataMapper.insertOrUpdateDmRtdata(dmRtdata);
        }
        return null;
    }
}
