package com.ruoyi.dm.mapper;

import java.util.List;
import com.ruoyi.dm.domain.DmData;

/**
 * 全部数据Mapper接口
 * 
 * @author 罗晨熙
 * @date 2024-03-19
 */
public interface DmDataMapper 
{
    /**
     * 查询全部数据
     * 
     * @param id 全部数据主键
     * @return 全部数据
     */
    public DmData selectDmDataById(String id);

    /**
     * 查询全部数据列表
     * 
     * @param dmData 全部数据
     * @return 全部数据集合
     */
    public List<DmData> selectDmDataList(DmData dmData);

    /**
     * 新增全部数据
     * 
     * @param dmData 全部数据
     * @return 结果
     */
    public int insertDmData(DmData dmData);

    /**
     * 修改全部数据
     * 
     * @param dmData 全部数据
     * @return 结果
     */
    public int updateDmData(DmData dmData);

    /**
     * 删除全部数据
     * 
     * @param id 全部数据主键
     * @return 结果
     */
    public int deleteDmDataById(String id);

    /**
     * 批量删除全部数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDmDataByIds(String[] ids);
}
