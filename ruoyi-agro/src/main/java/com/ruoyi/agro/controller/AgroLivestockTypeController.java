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
import com.ruoyi.agro.domain.AgroLivestockType;
import com.ruoyi.agro.service.IAgroLivestockTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 牲畜类型管理Controller
 * 
 * @author Xiaojiang
 * @date 2024-03-20
 */
@RestController
@RequestMapping("/agro/livestockType")
public class AgroLivestockTypeController extends BaseController
{
    @Autowired
    private IAgroLivestockTypeService agroLivestockTypeService;

    /**
     * 查询牲畜类型管理列表
     */
    @PreAuthorize("@ss.hasPermi('agro:livestockType:list')")
    @GetMapping("/list")
    public TableDataInfo list(AgroLivestockType agroLivestockType)
    {
        startPage();
        List<AgroLivestockType> list = agroLivestockTypeService.selectAgroLivestockTypeList(agroLivestockType);
        return getDataTable(list);
    }

    /**
     * 查询牲畜类型管理列表（不分页）
     */
    @PreAuthorize("@ss.hasPermi('agro:livestockType:list')")
    @GetMapping("/listLivestockTypeQuery")
    public TableDataInfo listLivestockTypeQuery(AgroLivestockType agroLivestockType)
    {
        List<AgroLivestockType> list = agroLivestockTypeService.selectAgroLivestockTypeList(agroLivestockType);
        return getDataTable(list);
    }

    /**
     * 导出牲畜类型管理列表
     */
    @PreAuthorize("@ss.hasPermi('agro:livestockType:export')")
    @Log(title = "牲畜类型管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AgroLivestockType agroLivestockType)
    {
        List<AgroLivestockType> list = agroLivestockTypeService.selectAgroLivestockTypeList(agroLivestockType);
        ExcelUtil<AgroLivestockType> util = new ExcelUtil<AgroLivestockType>(AgroLivestockType.class);
        util.exportExcel(response, list, "牲畜类型管理数据");
    }

    /**
     * 获取牲畜类型管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('agro:livestockType:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(agroLivestockTypeService.selectAgroLivestockTypeById(id));
    }

    /**
     * 新增牲畜类型管理
     */
    @PreAuthorize("@ss.hasPermi('agro:livestockType:add')")
    @Log(title = "牲畜类型管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AgroLivestockType agroLivestockType)
    {
        agroLivestockType.setUserId(getUserId().toString());
        agroLivestockType.setDeptId(getDeptId().toString());
        return toAjax(agroLivestockTypeService.insertAgroLivestockType(agroLivestockType));
    }

    /**
     * 修改牲畜类型管理
     */
    @PreAuthorize("@ss.hasPermi('agro:livestockType:edit')")
    @Log(title = "牲畜类型管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AgroLivestockType agroLivestockType)
    {
        return toAjax(agroLivestockTypeService.updateAgroLivestockType(agroLivestockType));
    }

    /**
     * 删除牲畜类型管理
     */
    @PreAuthorize("@ss.hasPermi('agro:livestockType:remove')")
    @Log(title = "牲畜类型管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(agroLivestockTypeService.deleteAgroLivestockTypeByIds(ids));
    }
}
