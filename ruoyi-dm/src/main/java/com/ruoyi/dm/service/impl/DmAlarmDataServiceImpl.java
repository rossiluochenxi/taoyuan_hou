package com.ruoyi.dm.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dm.mapper.DmAlarmDataMapper;
import com.ruoyi.dm.domain.DmAlarmData;
import com.ruoyi.dm.service.IDmAlarmDataService;

/**
 * 报警数据Service业务层处理
 * 
 * @author 罗晨熙
 * @date 2024-04-24
 */
@Service
public class DmAlarmDataServiceImpl implements IDmAlarmDataService 
{
    @Autowired
    private DmAlarmDataMapper dmAlarmDataMapper;

    /**
     * 查询报警数据
     * 
     * @param id 报警数据主键
     * @return 报警数据
     */
    @Override
    public DmAlarmData selectDmAlarmDataById(String id)
    {
        return dmAlarmDataMapper.selectDmAlarmDataById(id);
    }

    /**
     * 查询报警数据列表
     * 
     * @param dmAlarmData 报警数据
     * @return 报警数据
     */
    @Override
    public List<DmAlarmData> selectDmAlarmDataList(DmAlarmData dmAlarmData)
    {
        return dmAlarmDataMapper.selectDmAlarmDataList(dmAlarmData);
    }

    /**
     * 新增报警数据
     * 
     * @param dmAlarmData 报警数据
     * @return 结果
     */
    @Override
    public int insertDmAlarmData(DmAlarmData dmAlarmData)
    {
        dmAlarmData.setCreateTime(DateUtils.getNowDate());
        return dmAlarmDataMapper.insertDmAlarmData(dmAlarmData);
    }

    /**
     * 修改报警数据
     * 
     * @param dmAlarmData 报警数据
     * @return 结果
     */
    @Override
    public int updateDmAlarmData(DmAlarmData dmAlarmData)
    {
        dmAlarmData.setUpdateTime(DateUtils.getNowDate());
        return dmAlarmDataMapper.updateDmAlarmData(dmAlarmData);
    }

    /**
     * 批量删除报警数据
     * 
     * @param ids 需要删除的报警数据主键
     * @return 结果
     */
    @Override
    public int deleteDmAlarmDataByIds(String[] ids)
    {
        return dmAlarmDataMapper.deleteDmAlarmDataByIds(ids);
    }

    /**
     * 删除报警数据信息
     * 
     * @param id 报警数据主键
     * @return 结果
     */
    @Override
    public int deleteDmAlarmDataById(String id)
    {
        return dmAlarmDataMapper.deleteDmAlarmDataById(id);
    }
}
