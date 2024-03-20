package com.ruoyi.dm.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dm.mapper.DmDataMapper;
import com.ruoyi.dm.domain.DmData;
import com.ruoyi.dm.service.IDmDataService;

/**
 * 全部数据Service业务层处理
 * 
 * @author 罗晨熙
 * @date 2024-03-19
 */
@Service
public class DmDataServiceImpl implements IDmDataService 
{
    @Autowired
    private DmDataMapper dmDataMapper;

    /**
     * 查询全部数据
     * 
     * @param id 全部数据主键
     * @return 全部数据
     */
    @Override
    public DmData selectDmDataById(String id)
    {
        return dmDataMapper.selectDmDataById(id);
    }

    /**
     * 查询全部数据列表
     * 
     * @param dmData 全部数据
     * @return 全部数据
     */
    @Override
    public List<DmData> selectDmDataList(DmData dmData)
    {
        return dmDataMapper.selectDmDataList(dmData);
    }

    /**
     * 新增全部数据
     * 
     * @param dmData 全部数据
     * @return 结果
     */
    @Override
    public int insertDmData(DmData dmData)
    {
        dmData.setCreateTime(DateUtils.getNowDate());
        return dmDataMapper.insertDmData(dmData);
    }

    /**
     * 修改全部数据
     * 
     * @param dmData 全部数据
     * @return 结果
     */
    @Override
    public int updateDmData(DmData dmData)
    {
        dmData.setUpdateTime(DateUtils.getNowDate());
        return dmDataMapper.updateDmData(dmData);
    }

    /**
     * 批量删除全部数据
     * 
     * @param ids 需要删除的全部数据主键
     * @return 结果
     */
    @Override
    public int deleteDmDataByIds(String[] ids)
    {
        return dmDataMapper.deleteDmDataByIds(ids);
    }

    /**
     * 删除全部数据信息
     * 
     * @param id 全部数据主键
     * @return 结果
     */
    @Override
    public int deleteDmDataById(String id)
    {
        return dmDataMapper.deleteDmDataById(id);
    }
}
