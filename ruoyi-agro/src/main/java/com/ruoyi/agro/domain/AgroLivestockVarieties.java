package com.ruoyi.agro.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 牲畜品种管理对象 agro_livestock_varieties
 * 
 * @author Xiaojiang
 * @date 2024-03-20
 */
public class AgroLivestockVarieties extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private String id;

    /** 牲畜品种 */
    @Excel(name = "牲畜品种")
    private String livestockVarieties;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setLivestockVarieties(String livestockVarieties) 
    {
        this.livestockVarieties = livestockVarieties;
    }

    public String getLivestockVarieties() 
    {
        return livestockVarieties;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("livestockVarieties", getLivestockVarieties())
            .toString();
    }
}
