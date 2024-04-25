package com.ruoyi.agro.domain;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 养殖户排名
 *
 * @author 小江
 * @date 2024-04-24
 */
public class AgroRankingFarmers extends BaseEntity {
    private static final long serialVersionUID = 1L;


    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getAgroUserName() {
        return agroUserName;
    }

    public void setAgroUserName(String agroUserName) {
        this.agroUserName = agroUserName;
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

    /** 牲畜数量 */
    private String num;

    /** 养殖户名称 */
    private String agroUserName;

    /** 用户id */
//    @Excel(name = "user_id")
    private String userId;


    /** 部门id */
//    @Excel(name = "dept_id")
    private String deptId;
}
