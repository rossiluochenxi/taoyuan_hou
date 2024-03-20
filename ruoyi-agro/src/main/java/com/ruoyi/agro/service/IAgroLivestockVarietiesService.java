package com.ruoyi.agro.service;

import java.util.List;
import com.ruoyi.agro.domain.AgroLivestockVarieties;

/**
 * 牲畜品种管理Service接口
 * 
 * @author Xiaojiang
 * @date 2024-03-20
 */
public interface IAgroLivestockVarietiesService 
{
    /**
     * 查询牲畜品种管理
     * 
     * @param id 牲畜品种管理主键
     * @return 牲畜品种管理
     */
    public AgroLivestockVarieties selectAgroLivestockVarietiesById(String id);

    /**
     * 查询牲畜品种管理列表
     * 
     * @param agroLivestockVarieties 牲畜品种管理
     * @return 牲畜品种管理集合
     */
    public List<AgroLivestockVarieties> selectAgroLivestockVarietiesList(AgroLivestockVarieties agroLivestockVarieties);

    /**
     * 新增牲畜品种管理
     * 
     * @param agroLivestockVarieties 牲畜品种管理
     * @return 结果
     */
    public int insertAgroLivestockVarieties(AgroLivestockVarieties agroLivestockVarieties);

    /**
     * 修改牲畜品种管理
     * 
     * @param agroLivestockVarieties 牲畜品种管理
     * @return 结果
     */
    public int updateAgroLivestockVarieties(AgroLivestockVarieties agroLivestockVarieties);

    /**
     * 批量删除牲畜品种管理
     * 
     * @param ids 需要删除的牲畜品种管理主键集合
     * @return 结果
     */
    public int deleteAgroLivestockVarietiesByIds(String[] ids);

    /**
     * 删除牲畜品种管理信息
     * 
     * @param id 牲畜品种管理主键
     * @return 结果
     */
    public int deleteAgroLivestockVarietiesById(String id);
}
