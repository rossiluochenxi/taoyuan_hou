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
import com.ruoyi.agro.domain.AgroLivestockVarieties;
import com.ruoyi.agro.service.IAgroLivestockVarietiesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 牲畜品种管理Controller
 * 
 * @author Xiaojiang
 * @date 2024-03-20
 */
@RestController
@RequestMapping("/agro/livestockVarieties")
public class AgroLivestockVarietiesController extends BaseController
{
    @Autowired
    private IAgroLivestockVarietiesService agroLivestockVarietiesService;

    /**
     * 查询牲畜品种管理列表
     */
    @PreAuthorize("@ss.hasPermi('agro:livestockVarieties:list')")
    @GetMapping("/list")
    public TableDataInfo list(AgroLivestockVarieties agroLivestockVarieties)
    {
        startPage();
        List<AgroLivestockVarieties> list = agroLivestockVarietiesService.selectAgroLivestockVarietiesList(agroLivestockVarieties);
        return getDataTable(list);
    }

    /**
     * 导出牲畜品种管理列表
     */
    @PreAuthorize("@ss.hasPermi('agro:livestockVarieties:export')")
    @Log(title = "牲畜品种管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AgroLivestockVarieties agroLivestockVarieties)
    {
        List<AgroLivestockVarieties> list = agroLivestockVarietiesService.selectAgroLivestockVarietiesList(agroLivestockVarieties);
        ExcelUtil<AgroLivestockVarieties> util = new ExcelUtil<AgroLivestockVarieties>(AgroLivestockVarieties.class);
        util.exportExcel(response, list, "牲畜品种管理数据");
    }

    /**
     * 获取牲畜品种管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('agro:livestockVarieties:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(agroLivestockVarietiesService.selectAgroLivestockVarietiesById(id));
    }

    /**
     * 新增牲畜品种管理
     */
    @PreAuthorize("@ss.hasPermi('agro:livestockVarieties:add')")
    @Log(title = "牲畜品种管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AgroLivestockVarieties agroLivestockVarieties)
    {       agroLivestockVarieties.setCreateBy(getUsername());
        return toAjax(agroLivestockVarietiesService.insertAgroLivestockVarieties(agroLivestockVarieties));
    }

    /**
     * 修改牲畜品种管理
     */
    @PreAuthorize("@ss.hasPermi('agro:livestockVarieties:edit')")
    @Log(title = "牲畜品种管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AgroLivestockVarieties agroLivestockVarieties){
        agroLivestockVarieties.setUpdateBy(getUsername());
        return toAjax(agroLivestockVarietiesService.updateAgroLivestockVarieties(agroLivestockVarieties));
    }

    /**
     * 删除牲畜品种管理
     */
    @PreAuthorize("@ss.hasPermi('agro:livestockVarieties:remove')")
    @Log(title = "牲畜品种管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(agroLivestockVarietiesService.deleteAgroLivestockVarietiesByIds(ids));
    }
}
