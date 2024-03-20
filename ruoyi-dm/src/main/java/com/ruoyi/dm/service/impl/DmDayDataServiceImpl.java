package com.ruoyi.dm.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dm.mapper.DmDayDataMapper;
import com.ruoyi.dm.domain.DmDayData;
import com.ruoyi.dm.service.IDmDayDataService;

/**
 * 每天数据Service业务层处理
 * 
 * @author 罗晨熙
 * @date 2024-03-19
 */
@Service
public class DmDayDataServiceImpl implements IDmDayDataService 
{
    @Autowired
    private DmDayDataMapper dmDayDataMapper;

    /**
     * 查询每天数据
     * 
     * @param id 每天数据主键
     * @return 每天数据
     */
    @Override
    public DmDayData selectDmDayDataById(String id)
    {
        return dmDayDataMapper.selectDmDayDataById(id);
    }

    /**
     * 查询每天数据列表
     * 
     * @param dmDayData 每天数据
     * @return 每天数据
     */
    @Override
    public List<DmDayData> selectDmDayDataList(DmDayData dmDayData)
    {
        return dmDayDataMapper.selectDmDayDataList(dmDayData);
    }

    /**
     * 新增每天数据
     * 
     * @param dmDayData 每天数据
     * @return 结果
     */
    @Override
    public int insertDmDayData(DmDayData dmDayData)
    {
        dmDayData.setCreateTime(DateUtils.getNowDate());
        return dmDayDataMapper.insertDmDayData(dmDayData);
    }

    /**
     * 修改每天数据
     * 
     * @param dmDayData 每天数据
     * @return 结果
     */
    @Override
    public int updateDmDayData(DmDayData dmDayData)
    {
        dmDayData.setUpdateTime(DateUtils.getNowDate());
        return dmDayDataMapper.updateDmDayData(dmDayData);
    }

    /**
     * 批量删除每天数据
     * 
     * @param ids 需要删除的每天数据主键
     * @return 结果
     */
    @Override
    public int deleteDmDayDataByIds(String[] ids)
    {
        return dmDayDataMapper.deleteDmDayDataByIds(ids);
    }

    /**
     * 删除每天数据信息
     * 
     * @param id 每天数据主键
     * @return 结果
     */
    @Override
    public int deleteDmDayDataById(String id)
    {
        return dmDayDataMapper.deleteDmDayDataById(id);
    }
}
