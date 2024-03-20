package com.ruoyi.dm.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ruoyi.common.Business.BusinessService;
import com.ruoyi.common.utils.mqtt.Mqttobj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BusinessServiceImpl implements BusinessService {

    //冻结数据
    @Autowired
    private DmDataServiceImpl dmDataServiceImpl;
    @Autowired
    private DmDayDataServiceImpl dmDayDataServiceImpl;
    @Autowired
    private DmRtdataServiceImpl dmRtdataServiceImpl;
    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessService.class);

    /**
     * 处理mqtt消息业务类
     *
     * @param mqttobj
     * @return
     * @throws JsonProcessingException
     */
    @Override
    public String processBusinessLogic(Mqttobj mqttobj) throws JsonProcessingException {

        //冻结数据
        dmRtdataServiceImpl.deviceInsertDmRtdata(mqttobj);
        //每天数据
        dmDayDataServiceImpl.deviceInsertDmDayData(mqttobj);
        //全部数据
        dmDataServiceImpl.deviceInsertDmData(mqttobj);

        return "1";
    }

}
