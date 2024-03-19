package com.ruoyi.dm.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ruoyi.dm.domain.DmRtdata;

/**
 * 冻结数据Service接口
 * 
 * @author 罗晨熙
 * @date 2024-03-16
 */
public interface IDmRtdataService 
{
    /**
     * 查询冻结数据
     * 
     * @param id 冻结数据主键
     * @return 冻结数据
     */
    public DmRtdata selectDmRtdataById(String id);

    /**
     * 查询冻结数据列表
     * 
     * @param dmRtdata 冻结数据
     * @return 冻结数据集合
     */
    public List<DmRtdata> selectDmRtdataList(DmRtdata dmRtdata);

    /**
     * 新增冻结数据
     * 
     * @param dmRtdata 冻结数据
     * @return 结果
     */
    public int insertDmRtdata(DmRtdata dmRtdata);




    /**
     * 修改冻结数据
     * 
     * @param dmRtdata 冻结数据
     * @return 结果
     */
    public int updateDmRtdata(DmRtdata dmRtdata);

    /**
     * 批量删除冻结数据
     * 
     * @param ids 需要删除的冻结数据主键集合
     * @return 结果
     */
    public int deleteDmRtdataByIds(String[] ids);

    /**
     * 删除冻结数据信息
     * 
     * @param id 冻结数据主键
     * @return 结果
     */
    public int deleteDmRtdataById(String id);
}
