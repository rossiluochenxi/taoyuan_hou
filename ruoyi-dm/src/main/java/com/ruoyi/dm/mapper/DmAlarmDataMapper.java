package com.ruoyi.dm.mapper;

import java.util.List;
import com.ruoyi.dm.domain.DmAlarmData;

/**
 * 报警数据Mapper接口
 * 
 * @author 罗晨熙
 * @date 2024-04-24
 */
public interface DmAlarmDataMapper 
{
    /**
     * 查询报警数据
     * 
     * @param id 报警数据主键
     * @return 报警数据
     */
    public DmAlarmData selectDmAlarmDataById(String id);

    /**
     * 查询报警数据列表
     * 
     * @param dmAlarmData 报警数据
     * @return 报警数据集合
     */
    public List<DmAlarmData> selectDmAlarmDataList(DmAlarmData dmAlarmData);

    /**
     * 新增报警数据
     * 
     * @param dmAlarmData 报警数据
     * @return 结果
     */
    public int insertDmAlarmData(DmAlarmData dmAlarmData);

    /**
     * 修改报警数据
     * 
     * @param dmAlarmData 报警数据
     * @return 结果
     */
    public int updateDmAlarmData(DmAlarmData dmAlarmData);

    /**
     * 删除报警数据
     * 
     * @param id 报警数据主键
     * @return 结果
     */
    public int deleteDmAlarmDataById(String id);

    /**
     * 批量删除报警数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDmAlarmDataByIds(String[] ids);
}
