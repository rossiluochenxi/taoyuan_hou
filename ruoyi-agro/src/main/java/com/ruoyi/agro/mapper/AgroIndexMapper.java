package com.ruoyi.agro.mapper;

import com.ruoyi.agro.domain.AgroIndexVar;
import com.ruoyi.agro.domain.AgroRankingFarmers;

import java.util.List;

public interface AgroIndexMapper {

    public List<AgroIndexVar> selectIndexVarList(AgroIndexVar agroIndexVar);


    public List<AgroRankingFarmers> selectIndexUserNumList(AgroRankingFarmers agroRankingFarmers);


}
