package com.ruoyi.dm.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ruoyi.common.utils.mqtt.Mqttobj;
import com.ruoyi.dm.domain.DmDayData;

/**
 * 每天数据Service接口
 * 
 * @author 罗晨熙
 * @date 2024-03-19
 */
public interface IDmDayDataService 
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
     * 批量删除每天数据
     * 
     * @param ids 需要删除的每天数据主键集合
     * @return 结果
     */
    public int deleteDmDayDataByIds(String[] ids);

    /**
     * 删除每天数据信息
     * 
     * @param id 每天数据主键
     * @return 结果
     */
    public int deleteDmDayDataById(String id);
    /**
     * 每天数据新增
     */

    public String deviceInsertDmDayData(Mqttobj mqttobj) throws JsonProcessingException;
}
