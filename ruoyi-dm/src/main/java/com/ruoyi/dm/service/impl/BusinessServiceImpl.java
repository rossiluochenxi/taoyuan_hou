package com.ruoyi.dm.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.Business.BusinessService;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.mqtt.Mqttobj;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.dm.domain.DmRtdata;
import com.ruoyi.dm.mapper.DmRtdataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private DmRtdataMapper dmRtdataMapper;

    /**
     * 处理mqtt消息业务类
     * @param mqttobj
     * @return
     * @throws JsonProcessingException
     */
    @Override
    public String processBusinessLogic(Mqttobj mqttobj) throws JsonProcessingException {
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
        dmRtdata.setCreateTime(DateUtils.getNowDate());
        dmRtdata.setId(IdUtils.randomUUID());
        return  String.valueOf(dmRtdataMapper.insertDmRtdata(dmRtdata));
    }
}
