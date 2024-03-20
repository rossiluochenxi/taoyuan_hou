package com.ruoyi.agro.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.agro.mapper.AgroLivestockVarietiesMapper;
import com.ruoyi.agro.domain.AgroLivestockVarieties;
import com.ruoyi.agro.service.IAgroLivestockVarietiesService;

/**
 * 牲畜品种管理Service业务层处理
 * 
 * @author Xiaojiang
 * @date 2024-03-20
 */
@Service
public class AgroLivestockVarietiesServiceImpl implements IAgroLivestockVarietiesService 
{
    @Autowired
    private AgroLivestockVarietiesMapper agroLivestockVarietiesMapper;

    /**
     * 查询牲畜品种管理
     * 
     * @param id 牲畜品种管理主键
     * @return 牲畜品种管理
     */
    @Override
    public AgroLivestockVarieties selectAgroLivestockVarietiesById(String id)
    {
        return agroLivestockVarietiesMapper.selectAgroLivestockVarietiesById(id);
    }

    /**
     * 查询牲畜品种管理列表
     * 
     * @param agroLivestockVarieties 牲畜品种管理
     * @return 牲畜品种管理
     */
    @Override
    public List<AgroLivestockVarieties> selectAgroLivestockVarietiesList(AgroLivestockVarieties agroLivestockVarieties)
    {
        return agroLivestockVarietiesMapper.selectAgroLivestockVarietiesList(agroLivestockVarieties);
    }

    /**
     * 新增牲畜品种管理
     * 
     * @param agroLivestockVarieties 牲畜品种管理
     * @return 结果
     */
    @Override
    public int insertAgroLivestockVarieties(AgroLivestockVarieties agroLivestockVarieties)
    {
        agroLivestockVarieties.setCreateTime(DateUtils.getNowDate());
        agroLivestockVarieties.setId(IdUtils.randomUUID());

        return agroLivestockVarietiesMapper.insertAgroLivestockVarieties(agroLivestockVarieties);
    }

    /**
     * 修改牲畜品种管理
     * 
     * @param agroLivestockVarieties 牲畜品种管理
     * @return 结果
     */
    @Override
    public int updateAgroLivestockVarieties(AgroLivestockVarieties agroLivestockVarieties)
    {
        return agroLivestockVarietiesMapper.updateAgroLivestockVarieties(agroLivestockVarieties);
    }

    /**
     * 批量删除牲畜品种管理
     * 
     * @param ids 需要删除的牲畜品种管理主键
     * @return 结果
     */
    @Override
    public int deleteAgroLivestockVarietiesByIds(String[] ids)
    {
        return agroLivestockVarietiesMapper.deleteAgroLivestockVarietiesByIds(ids);
    }

    /**
     * 删除牲畜品种管理信息
     * 
     * @param id 牲畜品种管理主键
     * @return 结果
     */
    @Override
    public int deleteAgroLivestockVarietiesById(String id)
    {
        return agroLivestockVarietiesMapper.deleteAgroLivestockVarietiesById(id);
    }
}
