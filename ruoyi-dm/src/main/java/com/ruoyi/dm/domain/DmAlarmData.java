package com.ruoyi.dm.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 报警数据对象 dm_alarm_data
 * 
 * @author 罗晨熙
 * @date 2024-04-24
 */
public class DmAlarmData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private String id;

    /** 报警信息 */
    @Excel(name = "报警信息")
    private String info;

    /** 养殖户id */
    @Excel(name = "养殖户id")
    private String agroUserId;

    /** 养殖户 */
    @Excel(name = "养殖户")
    private String agroUserName;

    /** 牲畜档案id */
    @Excel(name = "牲畜档案id")
    private String agroLivestockId;

    /** 耳标 */
    @Excel(name = "耳标")
    private String agroLivestockCode;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String agroLivestockIccid;

    /** 项圈编号 */
    @Excel(name = "项圈编号")
    private String agroLivestockXqiccid;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String deviceType;

    /** imei */
    @Excel(name = "imei")
    private String imei;

    /** 平台设备号 */
    @Excel(name = "平台设备号")
    private String deviceId;

    /** 温度 */
    @Excel(name = "温度")
    private BigDecimal temperature;

    /** 步数 */
    @Excel(name = "步数")
    private String step;

    /** 电量 */
    @Excel(name = "电量")
    private BigDecimal drycell;

    /** 体重 */
    @Excel(name = "体重")
    private BigDecimal weight;

    /** 牲畜所在经度 */
    @Excel(name = "牲畜所在经度")
    private String livestockLon;

    /** 牲畜所在纬度 */
    @Excel(name = "牲畜所在纬度")
    private String livestockLat;

    /** rsrq */
    @Excel(name = "rsrq")
    private Long rsrq;

    /** ecl */
    @Excel(name = "ecl")
    private Long ecl;

    /** cellid */
    @Excel(name = "cellid")
    private String cellid;

    /** snr */
    @Excel(name = "snr")
    private Long snr;

    /** rsrp */
    @Excel(name = "rsrp")
    private Long rsrp;

    /** pci */
    @Excel(name = "pci")
    private String pci;

    /** 上传时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 部门id */
    @Excel(name = "部门id")
    private String deptId;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setInfo(String info) 
    {
        this.info = info;
    }

    public String getInfo() 
    {
        return info;
    }
    public void setAgroUserId(String agroUserId) 
    {
        this.agroUserId = agroUserId;
    }

    public String getAgroUserId() 
    {
        return agroUserId;
    }
    public void setAgroUserName(String agroUserName) 
    {
        this.agroUserName = agroUserName;
    }

    public String getAgroUserName() 
    {
        return agroUserName;
    }
    public void setAgroLivestockId(String agroLivestockId) 
    {
        this.agroLivestockId = agroLivestockId;
    }

    public String getAgroLivestockId() 
    {
        return agroLivestockId;
    }
    public void setAgroLivestockCode(String agroLivestockCode) 
    {
        this.agroLivestockCode = agroLivestockCode;
    }

    public String getAgroLivestockCode() 
    {
        return agroLivestockCode;
    }
    public void setAgroLivestockIccid(String agroLivestockIccid) 
    {
        this.agroLivestockIccid = agroLivestockIccid;
    }

    public String getAgroLivestockIccid() 
    {
        return agroLivestockIccid;
    }
    public void setAgroLivestockXqiccid(String agroLivestockXqiccid) 
    {
        this.agroLivestockXqiccid = agroLivestockXqiccid;
    }

    public String getAgroLivestockXqiccid() 
    {
        return agroLivestockXqiccid;
    }
    public void setDeviceType(String deviceType) 
    {
        this.deviceType = deviceType;
    }

    public String getDeviceType() 
    {
        return deviceType;
    }
    public void setImei(String imei) 
    {
        this.imei = imei;
    }

    public String getImei() 
    {
        return imei;
    }
    public void setDeviceId(String deviceId) 
    {
        this.deviceId = deviceId;
    }

    public String getDeviceId() 
    {
        return deviceId;
    }
    public void setTemperature(BigDecimal temperature) 
    {
        this.temperature = temperature;
    }

    public BigDecimal getTemperature() 
    {
        return temperature;
    }
    public void setStep(String step) 
    {
        this.step = step;
    }

    public String getStep() 
    {
        return step;
    }
    public void setDrycell(BigDecimal drycell) 
    {
        this.drycell = drycell;
    }

    public BigDecimal getDrycell() 
    {
        return drycell;
    }
    public void setWeight(BigDecimal weight) 
    {
        this.weight = weight;
    }

    public BigDecimal getWeight() 
    {
        return weight;
    }
    public void setLivestockLon(String livestockLon) 
    {
        this.livestockLon = livestockLon;
    }

    public String getLivestockLon() 
    {
        return livestockLon;
    }
    public void setLivestockLat(String livestockLat) 
    {
        this.livestockLat = livestockLat;
    }

    public String getLivestockLat() 
    {
        return livestockLat;
    }
    public void setRsrq(Long rsrq) 
    {
        this.rsrq = rsrq;
    }

    public Long getRsrq() 
    {
        return rsrq;
    }
    public void setEcl(Long ecl) 
    {
        this.ecl = ecl;
    }

    public Long getEcl() 
    {
        return ecl;
    }
    public void setCellid(String cellid) 
    {
        this.cellid = cellid;
    }

    public String getCellid() 
    {
        return cellid;
    }
    public void setSnr(Long snr) 
    {
        this.snr = snr;
    }

    public Long getSnr() 
    {
        return snr;
    }
    public void setRsrp(Long rsrp) 
    {
        this.rsrp = rsrp;
    }

    public Long getRsrp() 
    {
        return rsrp;
    }
    public void setPci(String pci) 
    {
        this.pci = pci;
    }

    public String getPci() 
    {
        return pci;
    }
    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }
    public void setDeptId(String deptId) 
    {
        this.deptId = deptId;
    }

    public String getDeptId() 
    {
        return deptId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("info", getInfo())
            .append("agroUserId", getAgroUserId())
            .append("agroUserName", getAgroUserName())
            .append("agroLivestockId", getAgroLivestockId())
            .append("agroLivestockCode", getAgroLivestockCode())
            .append("agroLivestockIccid", getAgroLivestockIccid())
            .append("agroLivestockXqiccid", getAgroLivestockXqiccid())
            .append("deviceType", getDeviceType())
            .append("imei", getImei())
            .append("deviceId", getDeviceId())
            .append("temperature", getTemperature())
            .append("step", getStep())
            .append("drycell", getDrycell())
            .append("weight", getWeight())
            .append("livestockLon", getLivestockLon())
            .append("livestockLat", getLivestockLat())
            .append("rsrq", getRsrq())
            .append("ecl", getEcl())
            .append("cellid", getCellid())
            .append("snr", getSnr())
            .append("rsrp", getRsrp())
            .append("pci", getPci())
            .append("date", getDate())
            .append("deptId", getDeptId())
            .append("userId", getUserId())
            .toString();
    }
}
