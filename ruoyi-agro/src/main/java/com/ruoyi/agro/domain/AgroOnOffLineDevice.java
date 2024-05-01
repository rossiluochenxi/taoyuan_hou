package com.ruoyi.agro.domain;

import com.ruoyi.common.core.domain.BaseEntity;

public class AgroOnOffLineDevice extends BaseEntity {



    /** 设备类型 */
    private String deviceType;

 /** 设备状态 */
    private String deviceStatus;
    /** 总数 */
    private String totalNumber;


    /** 用户id */
    private String userId;


    /** 部门id */
    private String deptId;

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(String totalNumber) {
        this.totalNumber = totalNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }








}
