package com.ruoyi.agro.service;


import com.ruoyi.agro.domain.AgroIndexVar;
import com.ruoyi.agro.domain.AgroOnOffLineDevice;
import com.ruoyi.agro.domain.AgroRankingFarmers;

import java.util.List;

public interface IAgroIndexService {
    /**
     * 查询品种数量和类型
     *
     *
     *
     */
    public List<AgroIndexVar> selectIndexVarList(AgroIndexVar agroIndexVar);

    /**
     * 查询品种数量和类型
     *
     *
     *
     */
    public List<AgroRankingFarmers> selectIndexUserNumList(AgroRankingFarmers agroRankingFarmers);



    /**
     * 查询耳标在线离线数量
     *
     *
     *
     */
    public List<AgroRankingFarmers> selectEbOnOffLineDevice(AgroOnOffLineDevice agroOnOffLineDevice);
    /**
     * 查询项圈在线离线数量
     *
     *
     *
     */
    public List<AgroRankingFarmers> selectXqOnOffLineDevice(AgroOnOffLineDevice agroOnOffLineDevice);

}
