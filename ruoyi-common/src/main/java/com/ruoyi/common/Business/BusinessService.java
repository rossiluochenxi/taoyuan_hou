package com.ruoyi.common.Business;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ruoyi.common.utils.mqtt.Mqttobj;

public interface BusinessService {

   public String processBusinessLogic(Mqttobj mqttobj) throws JsonProcessingException;
}
