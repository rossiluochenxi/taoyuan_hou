package com.ruoyi.agro.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.agro.domain.AgroIndexVar;
import com.ruoyi.agro.domain.AgroRankingFarmers;
import com.ruoyi.agro.service.IAgroIndexService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.common.core.controller.BaseController;

import com.ruoyi.common.core.page.TableDataInfo;
@RestController
@RequestMapping("/agro/index")
public class AgroIndexController extends BaseController {
    @Autowired
    private IAgroIndexService agroIndexService;

    /**
     * 查询牲畜档案管理列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AgroIndexVar agroIndexVar) {
//        agroIndexVar.setUserId(getUserId().toString());
//        agroIndexVar.setDeptId(getDeptId().toString());
     List<AgroIndexVar> list = agroIndexService.selectIndexVarList(agroIndexVar);

     return getDataTable(list);
    }

    /**
     * 查询养殖户牲畜排名
     */
    @GetMapping("/agroNumlist")
    public TableDataInfo agroNumlist(AgroRankingFarmers agroRankingFarmers) {

        List<AgroRankingFarmers> list = agroIndexService.selectIndexUserNumList(agroRankingFarmers);

        return getDataTable(list);
    }






}
