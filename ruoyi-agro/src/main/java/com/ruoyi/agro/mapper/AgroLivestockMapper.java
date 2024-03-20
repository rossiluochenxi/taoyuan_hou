package com.ruoyi.agro.mapper;

import java.util.List;
import com.ruoyi.agro.domain.AgroLivestock;

/**
 * 牲畜档案管理Mapper接口
 * 
 * @author 罗晨熙
 * @date 2024-03-14
 */
public interface AgroLivestockMapper 
{
    /**
     * 查询牲畜档案管理
     * 
     * @param id 牲畜档案管理主键
     * @return 牲畜档案管理
     */
    public AgroLivestock selectAgroLivestockById(String id);


    /**
     * 查询牲畜档案管理
     *
     * @param
     * @return 牲畜档案管理
     */
    public AgroLivestock selectAgroLivestockByIccid(String iccid);

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
     * 删除牲畜档案管理
     * 
     * @param id 牲畜档案管理主键
     * @return 结果
     */
    public int deleteAgroLivestockById(String id);

    /**
     * 批量删除牲畜档案管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAgroLivestockByIds(String[] ids);
}
