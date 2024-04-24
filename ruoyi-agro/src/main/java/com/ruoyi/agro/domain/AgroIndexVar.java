package com.ruoyi.agro.domain;


import com.ruoyi.common.core.domain.BaseEntity;
/**
 * 牲畜档案管理对象
 *
 * @author 大江
 * @date 2024-04-16
 */
public class AgroIndexVar extends BaseEntity {
    private static final long serialVersionUID = 1L;

    public String getVarietiesNum() {
        return varietiesNum;
    }

    public void setVarietiesNum(String varietiesNum) {
        this.varietiesNum = varietiesNum;
    }

    public String getLivestockVarieties() {
        return livestockVarieties;
    }

    public void setLivestockVarieties(String livestockVarieties) {
        this.livestockVarieties = livestockVarieties;
    }

    /** 品种数量 */
    private String varietiesNum;

    /** 品种名称 */
    private String livestockVarieties;

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

    /** 用户id */
//    @Excel(name = "user_id")
    private String userId;


    /** 部门id */
//    @Excel(name = "dept_id")
    private String deptId;




}
