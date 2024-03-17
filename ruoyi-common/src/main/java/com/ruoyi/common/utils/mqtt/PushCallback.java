package com.ruoyi.common.utils.mqtt;

import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;


@Component
public class PushCallback implements MqttCallback {
    private static final Logger logger = LoggerFactory.getLogger(MqttPushClient.class);

    @Autowired
    private MqttConfig mqttConfig;
    @Autowired
    private MqttPushClient mqttPushClient;

    private static MqttClient client;

    private static String _topic;
    private static String _qos;
    private static String _msg;

    @Override
    public void connectionLost(Throwable throwable) {
        // 连接丢失后，一般在这里面进行重连
        logger.info("连接断开，可以做重连");
        if (client == null || !client.isConnected()) {
            mqttConfig.getMqttPushClient();
        }
    }

    @Override
//    @Async("threadPoolTaskExecutor")// 提交到线程池中去处理
     public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        // subscribe后得到的消息会执行到这里面
        logger.info("接收消息主题 : " + topic);
        logger.info("接收消息Qos : " + mqttMessage.getQos());
        logger.info("接收消息内容 : " + new String(mqttMessage.getPayload()));
        _topic = topic;
        _qos = mqttMessage.getQos()+"";
        _msg = new String(mqttMessage.getPayload());
//        System.out.println("线程名称：【" + Thread.currentThread().getName() + "】");
//        DmRtdata dmRtdata = new DmRtdata();
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(_msg);
//        dmRtdata.setAgroLivestockCode(jsonNode.get("agroLivestockCode").asText());
//        dmRtdata.setAgroLivestockIccid(jsonNode.get("agroLivestockIccid").asText());
//        dmRtdata.setAgroLivestockXqiccid(jsonNode.get("agroLivestockXqiccid").asText());
//        dmRtdata.setImei(jsonNode.get("imei").asText());
//        dmRtdata.setDeviceId(jsonNode.get("deviceId").asText());
//        BigDecimal temperature = new BigDecimal(jsonNode.get("temperature").asText());
//        dmRtdata.setTemperature(temperature);
//        dmRtdata.setStep(jsonNode.get("step").asText());
//        BigDecimal weight = new BigDecimal(jsonNode.get("weight").asText());
//        dmRtdata.setWeight(weight);
//        dmRtdata.setLivestockLon(jsonNode.get("livestockLon").asText());
//        dmRtdata.setLivestockLat(jsonNode.get("livestockLat").asText());
//
//        dmRtdata.setRsrp(Long.parseLong(jsonNode.get("rsrp").asText()));
//        dmRtdata.setEcl(Long.parseLong(jsonNode.get("ecl").asText()));
//        dmRtdata.setRsrq(Long.parseLong(jsonNode.get("rsrq").asText()));
//        dmRtdata.setSnr(Long.parseLong(jsonNode.get("snr").asText()));
//        dmRtdata.setCellid(jsonNode.get("cellid").asText());
//        dmRtdata.setPci(jsonNode.get("pci").asText());
//        dmRtdataServiceImpl.insertDmRtdata(dmRtdata);
//        if(StringUtils.isNotEmpty(_msg)&&!"close".equals(_msg)){
//            logger.info("处理消息``````````````````` : "+_msg);
//
//            AjaxResult ac  = mqttPushClient.publish(1,false,"deviceIotTest0",_msg);
//            logger.info("``````````````````` : "+ac);
//        }


    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        logger.info("deliveryComplete---------" + iMqttDeliveryToken.isComplete());
    }

    //别的Controller层会调用这个方法来  获取  接收到的硬件数据
    public String receive() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("topic", _topic);
        jsonObject.put("qos", _qos);
        jsonObject.put("msg", _msg);
        return jsonObject.toString();
    }

}
