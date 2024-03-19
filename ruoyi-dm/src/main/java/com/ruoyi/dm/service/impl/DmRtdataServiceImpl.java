package com.ruoyi.dm.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dm.mapper.DmRtdataMapper;
import com.ruoyi.dm.domain.DmRtdata;
import com.ruoyi.dm.service.IDmRtdataService;

/**
 * 冻结数据Service业务层处理
 * 
 * @author 罗晨熙
 * @date 2024-03-16
 */
@Service
public class DmRtdataServiceImpl implements IDmRtdataService 
{
    @Autowired
    private DmRtdataMapper dmRtdataMapper;



    /**
     * 查询冻结数据
     * 
     * @param id 冻结数据主键
     * @return 冻结数据
     */
    @Override
    public DmRtdata selectDmRtdataById(String id)
    {
        return dmRtdataMapper.selectDmRtdataById(id);
    }

    /**
     * 查询冻结数据列表
     * 
     * @param dmRtdata 冻结数据
     * @return 冻结数据
     */
    @Override
    public List<DmRtdata> selectDmRtdataList(DmRtdata dmRtdata)
    {
        return dmRtdataMapper.selectDmRtdataList(dmRtdata);
    }

    /**
     * 新增冻结数据
     * 
     * @param dmRtdata 冻结数据
     * @return 结果
     */
    @Override
    public int insertDmRtdata(DmRtdata dmRtdata)
    {
        dmRtdata.setCreateTime(DateUtils.getNowDate());
        dmRtdata.setId(IdUtils.randomUUID());
        return dmRtdataMapper.insertDmRtdata(dmRtdata);
    }



    /**
     * 修改冻结数据
     * 
     * @param dmRtdata 冻结数据
     * @return 结果
     */
    @Override
    public int updateDmRtdata(DmRtdata dmRtdata)
    {
        dmRtdata.setUpdateTime(DateUtils.getNowDate());
        return dmRtdataMapper.updateDmRtdata(dmRtdata);
    }

    /**
     * 批量删除冻结数据
     * 
     * @param ids 需要删除的冻结数据主键
     * @return 结果
     */
    @Override
    public int deleteDmRtdataByIds(String[] ids)
    {
        return dmRtdataMapper.deleteDmRtdataByIds(ids);
    }

    /**
     * 删除冻结数据信息
     * 
     * @param id 冻结数据主键
     * @return 结果
     */
    @Override
    public int deleteDmRtdataById(String id)
    {
        return dmRtdataMapper.deleteDmRtdataById(id);
    }
}
