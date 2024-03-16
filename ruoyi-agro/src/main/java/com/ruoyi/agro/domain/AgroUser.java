package com.ruoyi.agro.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 养殖户管理对象 agro_user
 * 
 * @author 罗晨熙
 * @date 2024-03-13
 */
public class AgroUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自动编号 */
    private String id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 仪表信息 */
    private String meterinformation;

    /** 手机 */
    @Excel(name = "手机")
    private String phone;

    /** 证件号码 */
    @Excel(name = "证件号码")
    private String identity;

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    /** GUID */
    private String guid;

    /** 地区 */
    @Excel(name = "地区")
    private String areaName;

    /** 经度 */
    private String lon;

    /** 纬度 */
    private String lat;

    /** 操作员id */
    private String sysUserId;

    /** 操作员名字 */
    private String sysUserName;

    /** 站点 */
    @Excel(name = "站点")
    private String station;

    /** 负责人 */
    @Excel(name = "负责人")
    private String manager;

    /** 地区 */
    private String areaId;

    /** 城市 */
    private String cityId;

    /** 省份 */
    private String provinceId;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setMeterinformation(String meterinformation) 
    {
        this.meterinformation = meterinformation;
    }

    public String getMeterinformation() 
    {
        return meterinformation;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setIdentity(String identity) 
    {
        this.identity = identity;
    }

    public String getIdentity() 
    {
        return identity;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setGuid(String guid) 
    {
        this.guid = guid;
    }

    public String getGuid() 
    {
        return guid;
    }
    public void setAreaName(String areaName) 
    {
        this.areaName = areaName;
    }

    public String getAreaName() 
    {
        return areaName;
    }
    public void setLon(String lon) 
    {
        this.lon = lon;
    }

    public String getLon() 
    {
        return lon;
    }
    public void setLat(String lat) 
    {
        this.lat = lat;
    }

    public String getLat() 
    {
        return lat;
    }
    public void setSysUserId(String sysUserId) 
    {
        this.sysUserId = sysUserId;
    }

    public String getSysUserId() 
    {
        return sysUserId;
    }
    public void setSysUserName(String sysUserName) 
    {
        this.sysUserName = sysUserName;
    }

    public String getSysUserName() 
    {
        return sysUserName;
    }
    public void setStation(String station) 
    {
        this.station = station;
    }

    public String getStation() 
    {
        return station;
    }
    public void setManager(String manager) 
    {
        this.manager = manager;
    }

    public String getManager() 
    {
        return manager;
    }
    public void setAreaId(String areaId) 
    {
        this.areaId = areaId;
    }

    public String getAreaId() 
    {
        return areaId;
    }
    public void setCityId(String cityId) 
    {
        this.cityId = cityId;
    }

    public String getCityId() 
    {
        return cityId;
    }
    public void setProvinceId(String provinceId) 
    {
        this.provinceId = provinceId;
    }

    public String getProvinceId() 
    {
        return provinceId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("meterinformation", getMeterinformation())
            .append("phone", getPhone())
            .append("identity", getIdentity())
            .append("state", getState())
            .append("remark", getRemark())
            .append("guid", getGuid())
            .append("areaName", getAreaName())
            .append("lon", getLon())
            .append("lat", getLat())
            .append("sysUserId", getSysUserId())
            .append("sysUserName", getSysUserName())
            .append("station", getStation())
            .append("manager", getManager())
            .append("areaId", getAreaId())
            .append("cityId", getCityId())
            .append("provinceId", getProvinceId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
