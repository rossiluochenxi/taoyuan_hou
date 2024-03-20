package com.ruoyi.agro.service;

import java.util.List;
import com.ruoyi.agro.domain.AgroLivestockType;

/**
 * 牲畜类型管理Service接口
 * 
 * @author Xiaojiang
 * @date 2024-03-20
 */
public interface IAgroLivestockTypeService 
{
    /**
     * 查询牲畜类型管理
     * 
     * @param id 牲畜类型管理主键
     * @return 牲畜类型管理
     */
    public AgroLivestockType selectAgroLivestockTypeById(String id);

    /**
     * 查询牲畜类型管理列表
     * 
     * @param agroLivestockType 牲畜类型管理
     * @return 牲畜类型管理集合
     */
    public List<AgroLivestockType> selectAgroLivestockTypeList(AgroLivestockType agroLivestockType);

    /**
     * 新增牲畜类型管理
     * 
     * @param agroLivestockType 牲畜类型管理
     * @return 结果
     */
    public int insertAgroLivestockType(AgroLivestockType agroLivestockType);

    /**
     * 修改牲畜类型管理
     * 
     * @param agroLivestockType 牲畜类型管理
     * @return 结果
     */
    public int updateAgroLivestockType(AgroLivestockType agroLivestockType);

    /**
     * 批量删除牲畜类型管理
     * 
     * @param ids 需要删除的牲畜类型管理主键集合
     * @return 结果
     */
    public int deleteAgroLivestockTypeByIds(String[] ids);

    /**
     * 删除牲畜类型管理信息
     * 
     * @param id 牲畜类型管理主键
     * @return 结果
     */
    public int deleteAgroLivestockTypeById(String id);
}
