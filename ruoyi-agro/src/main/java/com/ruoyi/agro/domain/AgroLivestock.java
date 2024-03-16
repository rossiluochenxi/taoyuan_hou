package com.ruoyi.agro.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 牲畜档案管理对象 agro_livestock
 * 
 * @author 罗晨熙
 * @date 2024-03-14
 */
public class AgroLivestock extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private String id;

    /** 养殖户id */
    private String agroUserId;

    /** 养殖户 */
    @Excel(name = "养殖户")
    private String agroUserName;

    /** 原始耳标 */
    @Excel(name = "原始耳标")
    private String code;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String iccid;

    /** 项圈编号 */
    @Excel(name = "项圈编号")
    private String xqIccid;

    /** 牲畜类型 */
    @Excel(name = "牲畜类型")
    private String livestockType;

    /** 牲畜品种 */
    @Excel(name = "牲畜品种")
    private String livestockVarieties;

    /** 预计出栏日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计出栏日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date outDate;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 贷款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "贷款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date loanDate;

    /** 贷款金额 */
    @Excel(name = "贷款金额")
    private String loanMoney;

    /** 是否投保 */
    @Excel(name = "是否投保")
    private String isInsure;

    /** 站点 */
    @Excel(name = "站点")
    private String station;

    /** 照片 */
    private String image;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
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
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setIccid(String iccid) 
    {
        this.iccid = iccid;
    }

    public String getIccid() 
    {
        return iccid;
    }
    public void setXqIccid(String xqIccid) 
    {
        this.xqIccid = xqIccid;
    }

    public String getXqIccid() 
    {
        return xqIccid;
    }
    public void setLivestockType(String livestockType) 
    {
        this.livestockType = livestockType;
    }

    public String getLivestockType() 
    {
        return livestockType;
    }
    public void setLivestockVarieties(String livestockVarieties) 
    {
        this.livestockVarieties = livestockVarieties;
    }

    public String getLivestockVarieties() 
    {
        return livestockVarieties;
    }
    public void setOutDate(Date outDate) 
    {
        this.outDate = outDate;
    }

    public Date getOutDate() 
    {
        return outDate;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setLoanDate(Date loanDate) 
    {
        this.loanDate = loanDate;
    }

    public Date getLoanDate() 
    {
        return loanDate;
    }
    public void setLoanMoney(String loanMoney) 
    {
        this.loanMoney = loanMoney;
    }

    public String getLoanMoney() 
    {
        return loanMoney;
    }
    public void setIsInsure(String isInsure) 
    {
        this.isInsure = isInsure;
    }

    public String getIsInsure() 
    {
        return isInsure;
    }
    public void setStation(String station) 
    {
        this.station = station;
    }

    public String getStation() 
    {
        return station;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("agroUserId", getAgroUserId())
            .append("agroUserName", getAgroUserName())
            .append("code", getCode())
            .append("iccid", getIccid())
            .append("xqIccid", getXqIccid())
            .append("livestockType", getLivestockType())
            .append("livestockVarieties", getLivestockVarieties())
            .append("outDate", getOutDate())
            .append("birthday", getBirthday())
            .append("loanDate", getLoanDate())
            .append("loanMoney", getLoanMoney())
            .append("isInsure", getIsInsure())
            .append("station", getStation())
            .append("remark", getRemark())
            .append("image", getImage())
            .toString();
    }
}
