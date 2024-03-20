package com.ruoyi.dm.controller;

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
import com.ruoyi.dm.domain.DmData;
import com.ruoyi.dm.service.IDmDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 全部数据Controller
 * 
 * @author 罗晨熙
 * @date 2024-03-19
 */
@RestController
@RequestMapping("/dm/data")
public class DmDataController extends BaseController
{
    @Autowired
    private IDmDataService dmDataService;

    /**
     * 查询全部数据列表
     */
    @PreAuthorize("@ss.hasPermi('dm:data:list')")
    @GetMapping("/list")
    public TableDataInfo list(DmData dmData)
    {
        startPage();
        List<DmData> list = dmDataService.selectDmDataList(dmData);
        return getDataTable(list);
    }

    /**
     * 导出全部数据列表
     */
    @PreAuthorize("@ss.hasPermi('dm:data:export')")
    @Log(title = "全部数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DmData dmData)
    {
        List<DmData> list = dmDataService.selectDmDataList(dmData);
        ExcelUtil<DmData> util = new ExcelUtil<DmData>(DmData.class);
        util.exportExcel(response, list, "全部数据数据");
    }

    /**
     * 获取全部数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('dm:data:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(dmDataService.selectDmDataById(id));
    }

    /**
     * 新增全部数据
     */
    @PreAuthorize("@ss.hasPermi('dm:data:add')")
    @Log(title = "全部数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DmData dmData)
    {
        return toAjax(dmDataService.insertDmData(dmData));
    }

    /**
     * 修改全部数据
     */
    @PreAuthorize("@ss.hasPermi('dm:data:edit')")
    @Log(title = "全部数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DmData dmData)
    {
        return toAjax(dmDataService.updateDmData(dmData));
    }

    /**
     * 删除全部数据
     */
    @PreAuthorize("@ss.hasPermi('dm:data:remove')")
    @Log(title = "全部数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(dmDataService.deleteDmDataByIds(ids));
    }
}
