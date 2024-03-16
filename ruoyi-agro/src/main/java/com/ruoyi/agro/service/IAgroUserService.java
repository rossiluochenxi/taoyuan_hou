package com.ruoyi.agro.service;

import java.util.List;
import com.ruoyi.agro.domain.AgroUser;

/**
 * 养殖户管理Service接口
 * 
 * @author 罗晨熙
 * @date 2024-03-13
 */
public interface IAgroUserService 
{
    /**
     * 查询养殖户管理
     * 
     * @param id 养殖户管理主键
     * @return 养殖户管理
     */
    public AgroUser selectAgroUserById(String id);

    /**
     * 查询养殖户管理列表
     * 
     * @param agroUser 养殖户管理
     * @return 养殖户管理集合
     */
    public List<AgroUser> selectAgroUserList(AgroUser agroUser);



    /**
     * 新增养殖户管理
     * 
     * @param agroUser 养殖户管理
     * @return 结果
     */
    public int insertAgroUser(AgroUser agroUser);

    /**
     * 修改养殖户管理
     * 
     * @param agroUser 养殖户管理
     * @return 结果
     */
    public int updateAgroUser(AgroUser agroUser);

    /**
     * 批量删除养殖户管理
     * 
     * @param ids 需要删除的养殖户管理主键集合
     * @return 结果
     */
    public int deleteAgroUserByIds(String[] ids);

    /**
     * 删除养殖户管理信息
     * 
     * @param id 养殖户管理主键
     * @return 结果
     */
    public int deleteAgroUserById(String id);
}
