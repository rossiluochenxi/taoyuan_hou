package com.ruoyi.agro.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.agro.mapper.AgroLivestockTypeMapper;
import com.ruoyi.agro.domain.AgroLivestockType;
import com.ruoyi.agro.service.IAgroLivestockTypeService;

/**
 * 牲畜类型管理Service业务层处理
 * 
 * @author Xiaojiang
 * @date 2024-03-20
 */
@Service
public class AgroLivestockTypeServiceImpl implements IAgroLivestockTypeService 
{
    @Autowired
    private AgroLivestockTypeMapper agroLivestockTypeMapper;

    /**
     * 查询牲畜类型管理
     * 
     * @param id 牲畜类型管理主键
     * @return 牲畜类型管理
     */
    @Override
    public AgroLivestockType selectAgroLivestockTypeById(String id)
    {
        return agroLivestockTypeMapper.selectAgroLivestockTypeById(id);
    }

    /**
     * 查询牲畜类型管理列表
     * 
     * @param agroLivestockType 牲畜类型管理
     * @return 牲畜类型管理
     */
    @Override
    public List<AgroLivestockType> selectAgroLivestockTypeList(AgroLivestockType agroLivestockType)
    {
        return agroLivestockTypeMapper.selectAgroLivestockTypeList(agroLivestockType);
    }

    /**
     * 新增牲畜类型管理
     * 
     * @param agroLivestockType 牲畜类型管理
     * @return 结果
     */
    @Override
    public int insertAgroLivestockType(AgroLivestockType agroLivestockType)
    {
        agroLivestockType.setCreateTime(DateUtils.getNowDate());
        agroLivestockType.setId(IdUtils.randomUUID());
        return agroLivestockTypeMapper.insertAgroLivestockType(agroLivestockType);
    }

    /**
     * 修改牲畜类型管理
     * 
     * @param agroLivestockType 牲畜类型管理
     * @return 结果
     */
    @Override
    public int updateAgroLivestockType(AgroLivestockType agroLivestockType)
    {
        return agroLivestockTypeMapper.updateAgroLivestockType(agroLivestockType);
    }

    /**
     * 批量删除牲畜类型管理
     * 
     * @param ids 需要删除的牲畜类型管理主键
     * @return 结果
     */
    @Override
    public int deleteAgroLivestockTypeByIds(String[] ids)
    {
        return agroLivestockTypeMapper.deleteAgroLivestockTypeByIds(ids);
    }

    /**
     * 删除牲畜类型管理信息
     * 
     * @param id 牲畜类型管理主键
     * @return 结果
     */
    @Override
    public int deleteAgroLivestockTypeById(String id)
    {
        return agroLivestockTypeMapper.deleteAgroLivestockTypeById(id);
    }
}
