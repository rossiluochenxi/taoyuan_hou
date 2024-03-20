package com.ruoyi.agro.service;

import java.util.List;
import com.ruoyi.agro.domain.AgroLivestock;

/**
 * 牲畜档案管理Service接口
 * 
 * @author 罗晨熙
 * @date 2024-03-14
 */
public interface IAgroLivestockService 
{
    /**
     * 查询牲畜档案管理
     * 
     * @param id 牲畜档案管理主键
     * @return 牲畜档案管理
     */
    public AgroLivestock selectAgroLivestockById(String id);

    /**
     * 查询牲畜档案管理列表
     * 
     * @param agroLivestock 牲畜档案管理
     * @return 牲畜档案管理集合
     */
    public List<AgroLivestock> selectAgroLivestockList(AgroLivestock agroLivestock);

    /**
     * 新增牲畜档案管理
     * 
     * @param agroLivestock 牲畜档案管理
     * @return 结果
     */
    public int insertAgroLivestock(AgroLivestock agroLivestock);

    /**
     * 修改牲畜档案管理
     * 
     * @param agroLivestock 牲畜档案管理
     * @return 结果
     */
    public int updateAgroLivestock(AgroLivestock agroLivestock);

    /**
     * 批量删除牲畜档案管理
     * 
     * @param ids 需要删除的牲畜档案管理主键集合
     * @return 结果
     */
    public int deleteAgroLivestockByIds(String[] ids);

    /**
     * 删除牲畜档案管理信息
     * 
     * @param id 牲畜档案管理主键
     * @return 结果
     */
    public int deleteAgroLivestockById(String id);

    public AgroLivestock selectAgroLivestockByIccid(String id);

}
