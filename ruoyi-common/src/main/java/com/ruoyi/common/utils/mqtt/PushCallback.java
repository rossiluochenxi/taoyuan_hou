package com.ruoyi.common.utils.mqtt;

import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.ruoyi.common.Business.BusinessService;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;


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

    @Autowired
   private ThreadPoolTaskExecutor mqttMessageThreadPoolTaskExecutor;

    @Override
    public void connectionLost(Throwable throwable) {
        // 连接丢失后，一般在这里面进行重连
        logger.info("连接断开，可以做重连");
        if (client == null || !client.isConnected()) {
            mqttConfig.getMqttPushClient();
        }
    }

    @Autowired
    private BusinessService businessService;

    public void PushCallback(BusinessService businessService) {
        this.businessService = businessService;
    }

    @Override
     public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
      mqttMessageThreadPoolTaskExecutor.execute(() -> {
            // 在线程池中处理消息
            logger.info("接收消息主题 : " + topic);
            logger.info("接收消息Qos : " + mqttMessage.getQos());
            logger.info("接收消息内容 : " + new String(mqttMessage.getPayload()));
            _topic = topic;
            _qos = mqttMessage.getQos() + "";
            _msg = new String(mqttMessage.getPayload());
            Mqttobj mObj= new Mqttobj();
              mObj.setTopic(_topic);
              mObj.setQos(_qos);
              mObj.setMsg(_msg);
             //打印线程信息
            Thread currentThread = Thread.currentThread();
            logger.info("Thread Name: " + currentThread.getName());
            logger.info("Thread ID: " + currentThread.getId());
          try {
              String result= businessService.processBusinessLogic(mObj);
              logger.info("返回值 : " + result);
          } catch (JsonProcessingException e) {
              e.printStackTrace();
          }
      });
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
