package com.ruoyi.dm.mapper;

import java.util.List;
import com.ruoyi.dm.domain.DmDayData;

/**
 * 每天数据Mapper接口
 * 
 * @author 罗晨熙
 * @date 2024-03-19
 */
public interface DmDayDataMapper 
{
    /**
     * 查询每天数据
     * 
     * @param id 每天数据主键
     * @return 每天数据
     */
    public DmDayData selectDmDayDataById(String id);

    /**
     * 查询每天数据列表
     * 
     * @param dmDayData 每天数据
     * @return 每天数据集合
     */
    public List<DmDayData> selectDmDayDataList(DmDayData dmDayData);

    /**
     * 新增每天数据
     * 
     * @param dmDayData 每天数据
     * @return 结果
     */
    public int insertDmDayData(DmDayData dmDayData);

    /**
     * 修改每天数据
     * 
     * @param dmDayData 每天数据
     * @return 结果
     */
    public int updateDmDayData(DmDayData dmDayData);

    /**
     * 删除每天数据
     * 
     * @param id 每天数据主键
     * @return 结果
     */
    public int deleteDmDayDataById(String id);

    /**
     * 批量删除每天数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDmDayDataByIds(String[] ids);

    /**
     * 添加或则修改每天设备数据
     * @param dmDayData
     * @return
     */
    public int insertOrUpdateDmDayData(DmDayData dmDayData);

}
