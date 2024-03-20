package com.ruoyi.agro.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.agro.mapper.AgroLivestockMapper;
import com.ruoyi.agro.domain.AgroLivestock;
import com.ruoyi.agro.service.IAgroLivestockService;

/**
 * 牲畜档案管理Service业务层处理
 * 
 * @author 罗晨熙
 * @date 2024-03-14
 */
@Service
public class AgroLivestockServiceImpl implements IAgroLivestockService 
{
    @Autowired
    private AgroLivestockMapper agroLivestockMapper;

    /**
     * 查询牲畜档案管理
     * 
     * @param id 牲畜档案管理主键
     * @return 牲畜档案管理
     */
    @Override
    public AgroLivestock selectAgroLivestockById(String id)
    {
        return agroLivestockMapper.selectAgroLivestockById(id);
    }

    /**
     * 查询牲畜档案管理列表
     * 
     * @param agroLivestock 牲畜档案管理
     * @return 牲畜档案管理
     */
    @Override
    public List<AgroLivestock> selectAgroLivestockList(AgroLivestock agroLivestock)
    {
        return agroLivestockMapper.selectAgroLivestockList(agroLivestock);
    }

    /**
     * 新增牲畜档案管理
     * 
     * @param agroLivestock 牲畜档案管理
     * @return 结果
     */
    @Override
    public int insertAgroLivestock(AgroLivestock agroLivestock)
    {
        agroLivestock.setCreateTime(DateUtils.getNowDate());
        agroLivestock.setId(IdUtils.randomUUID());
        return agroLivestockMapper.insertAgroLivestock(agroLivestock);
    }

    /**
     * 修改牲畜档案管理
     * 
     * @param agroLivestock 牲畜档案管理
     * @return 结果
     */
    @Override
    public int updateAgroLivestock(AgroLivestock agroLivestock)
    {
        agroLivestock.setUpdateTime(DateUtils.getNowDate());
        return agroLivestockMapper.updateAgroLivestock(agroLivestock);
    }

    /**
     * 批量删除牲畜档案管理
     * 
     * @param ids 需要删除的牲畜档案管理主键
     * @return 结果
     */
    @Override
    public int deleteAgroLivestockByIds(String[] ids)
    {
        return agroLivestockMapper.deleteAgroLivestockByIds(ids);
    }

    /**
     * 删除牲畜档案管理信息
     * 
     * @param id 牲畜档案管理主键
     * @return 结果
     */
    @Override
    public int deleteAgroLivestockById(String id)
    {
        return agroLivestockMapper.deleteAgroLivestockById(id);
    }

    /**
     * 查询牲畜档案管理
     *
     * @param iccid 牲畜档案管理设备号
     * @return 牲畜档案管理
     */
    @Override
    public AgroLivestock selectAgroLivestockByIccid(String iccid)
    {
        return agroLivestockMapper.selectAgroLivestockByIccid(iccid);
    }




}
