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




    /** 用户id */
//    @Excel(name = "user_id")
    private String userId;


    /** 部门id */
//    @Excel(name = "dept_id")
    private String deptId;


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
