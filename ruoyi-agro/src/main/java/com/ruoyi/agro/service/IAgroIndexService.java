package com.ruoyi.agro.service;


import com.ruoyi.agro.domain.AgroIndexVar;
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



}
