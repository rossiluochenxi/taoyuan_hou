package com.ruoyi.common.utils.mqtt;

import java.io.Serializable;

public class Mqttobj{
    private static final long serialVersionUID = 1L;
    private  String topic;
    private  String qos;
    private  String msg;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Mqttobj{" +
                "topic='" + topic + '\'' +
                ", qos='" + qos + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public String getQos() {
        return qos;
    }

    public void setQos(String qos) {
        this.qos = qos;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
