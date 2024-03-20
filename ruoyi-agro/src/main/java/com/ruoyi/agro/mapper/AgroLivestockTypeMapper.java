package com.ruoyi.agro.mapper;

import java.util.List;
import com.ruoyi.agro.domain.AgroLivestockType;

/**
 * 牲畜类型管理Mapper接口
 * 
 * @author Xiaojiang
 * @date 2024-03-20
 */
public interface AgroLivestockTypeMapper 
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
     * 删除牲畜类型管理
     * 
     * @param id 牲畜类型管理主键
     * @return 结果
     */
    public int deleteAgroLivestockTypeById(String id);

    /**
     * 批量删除牲畜类型管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAgroLivestockTypeByIds(String[] ids);
}
