package com.ruoyi.common.utils.mqtt;

import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.ruoyi.common.Business.BusinessService;
import org.eclipse.paho.client.mqttv3.*;
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
//    private int reconnectCount = 0;
//    private static final int MAX_RECONNECT_COUNT = 3;
//    private static final long RECONNECT_INTERVAL = 2 * 60 * 1000; // 2分钟的毫秒数
//
//    @Override
//    public void connectionLost(Throwable throwable) {
//        if (reconnectCount < MAX_RECONNECT_COUNT) {
//            logger.info("连接断开，尝试重连，重连次数：" + (reconnectCount + 1));
//            if (client != null && !client.isConnected()) {
//                try {
//                    mqttPushClient.connect(mqttConfig.getHostUrl(), mqttConfig.getClientId(), mqttConfig.getUsername(), mqttConfig.getPassword(), mqttConfig.getTimeout(), mqttConfig.getKeepalive());
//                    // 重连成功，重置重连次数
//                    reconnectCount = 0;
//                } catch (Exception e) {
//                    logger.error("重连失败：" + e.getMessage());
//                    reconnectCount++;
//                    try {
//                        // 等待2分钟后进行下一次重连尝试
//                        Thread.sleep(RECONNECT_INTERVAL);
//                    } catch (InterruptedException ex) {
//                        Thread.currentThread().interrupt();
//                    }
//                }
//            }
//        } else {
//            logger.error("达到最大重连次数，停止重连");
//        }
//    }
        @Override
        public void connectionLost(Throwable throwable) {
            // 连接丢失后，一般在这里面进行重连
            logger.info("连接断开，可以做重连");
            throwable.printStackTrace();

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
              // TODO: 2024/3/20  下行消息
              logger.info("返回值 : " + result);
          } catch (JsonProcessingException e) {
              e.printStackTrace();
              logger.error("mqtt处理设备消息报错", e);

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
