package com.ruoyi.agro.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.agro.domain.AgroLivestock;
import com.ruoyi.agro.service.IAgroLivestockService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 牲畜档案管理Controller
 * 
 * @author 罗晨熙
 * @date 2024-03-14
 */
@RestController
@RequestMapping("/agro/livestock")
public class AgroLivestockController extends BaseController
{
    @Autowired
    private IAgroLivestockService agroLivestockService;

    /**
     * 查询牲畜档案管理列表
     */
    @PreAuthorize("@ss.hasPermi('agro:livestock:list')")
    @GetMapping("/list")
    public TableDataInfo list(AgroLivestock agroLivestock)
    {
        startPage();
        List<AgroLivestock> list = agroLivestockService.selectAgroLivestockList(agroLivestock);
        return getDataTable(list);
    }

    /**
     * 导出牲畜档案管理列表
     */
    @PreAuthorize("@ss.hasPermi('agro:livestock:export')")
    @Log(title = "牲畜档案管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AgroLivestock agroLivestock)
    {
        List<AgroLivestock> list = agroLivestockService.selectAgroLivestockList(agroLivestock);
        ExcelUtil<AgroLivestock> util = new ExcelUtil<AgroLivestock>(AgroLivestock.class);
        util.exportExcel(response, list, "牲畜档案管理数据");
    }

    /**
     * 获取牲畜档案管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('agro:livestock:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(agroLivestockService.selectAgroLivestockById(id));
    }

    /**
     * 新增牲畜档案管理
     */
    @PreAuthorize("@ss.hasPermi('agro:livestock:add')")
    @Log(title = "牲畜档案管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AgroLivestock agroLivestock)
    {
        agroLivestock.setCreateBy(getUsername());
        return toAjax(agroLivestockService.insertAgroLivestock(agroLivestock));
    }

    /**
     * 修改牲畜档案管理
     */
    @PreAuthorize("@ss.hasPermi('agro:livestock:edit')")
    @Log(title = "牲畜档案管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AgroLivestock agroLivestock)
    {
        agroLivestock.setCreateBy(getUsername());
        return toAjax(agroLivestockService.updateAgroLivestock(agroLivestock));
    }

    /**
     * 删除牲畜档案管理
     */
    @PreAuthorize("@ss.hasPermi('agro:livestock:remove')")
    @Log(title = "牲畜档案管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(agroLivestockService.deleteAgroLivestockByIds(ids));
    }
}
