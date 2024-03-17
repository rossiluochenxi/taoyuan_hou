package com.ruoyi.dm.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.mqtt.PushCallback;
import com.ruoyi.common.utils.uuid.IdUtils;
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
public class DmRtdataServiceImpl implements IDmRtdataService 
{
    @Autowired
    private DmRtdataMapper dmRtdataMapper;

    @Autowired
    private PushCallback pushCallback;

    /**
     * 查询冻结数据
     * 
     * @param id 冻结数据主键
     * @return 冻结数据
     */
    @Override
    public DmRtdata selectDmRtdataById(String id)
    {
        return dmRtdataMapper.selectDmRtdataById(id);
    }

    /**
     * 查询冻结数据列表
     * 
     * @param dmRtdata 冻结数据
     * @return 冻结数据
     */
    @Override
    public List<DmRtdata> selectDmRtdataList(DmRtdata dmRtdata)
    {
        return dmRtdataMapper.selectDmRtdataList(dmRtdata);
    }

    /**
     * 新增冻结数据
     * 
     * @param dmRtdata 冻结数据
     * @return 结果
     */
    @Override
    public int insertDmRtdata(DmRtdata dmRtdata)
    {
        dmRtdata.setCreateTime(DateUtils.getNowDate());
        dmRtdata.setId(IdUtils.randomUUID());
        dmRtdata.setCreateTime(DateUtils.getNowDate());
        return dmRtdataMapper.insertDmRtdata(dmRtdata);
    }

    @Override
    public void mqttDmRtdata() throws JsonProcessingException {
        String data= pushCallback.receive();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode1 = objectMapper.readTree(data);
        String createBy = jsonNode1.get("_msg").asText();
        JsonNode jsonNode = objectMapper.readTree(createBy);
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
        this.insertDmRtdata(dmRtdata);
        System.out.println("到这里了吗");

    }

    /**
     * 修改冻结数据
     * 
     * @param dmRtdata 冻结数据
     * @return 结果
     */
    @Override
    public int updateDmRtdata(DmRtdata dmRtdata)
    {
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
    public int deleteDmRtdataByIds(String[] ids)
    {
        return dmRtdataMapper.deleteDmRtdataByIds(ids);
    }

    /**
     * 删除冻结数据信息
     * 
     * @param id 冻结数据主键
     * @return 结果
     */
    @Override
    public int deleteDmRtdataById(String id)
    {
        return dmRtdataMapper.deleteDmRtdataById(id);
    }
}
