package com.ruoyi.agro.domain;

import com.ruoyi.common.core.domain.BaseEntity;

public class AgroOnOffLineDevice extends BaseEntity {


    /** 设备号 */
    private String agroLivestockIccid;

    /** 设备类型 */
    private String deviceType;


    /** 设备状态 */
    private String deviceStatus;


    /** 用户id */
//    @Excel(name = "user_id")
    private String userId;


    /** 部门id */
//    @Excel(name = "dept_id")
    private String deptId;



    public String getAgroLivestockIccid() {
        return agroLivestockIccid;
    }

    public void setAgroLivestockIccid(String agroLivestockIccid) {
        this.agroLivestockIccid = agroLivestockIccid;
    }

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
