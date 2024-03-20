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
import com.ruoyi.dm.domain.DmDayData;
import com.ruoyi.dm.service.IDmDayDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 每天数据Controller
 * 
 * @author 罗晨熙
 * @date 2024-03-19
 */
@RestController
@RequestMapping("/dm/daydata")
public class DmDayDataController extends BaseController
{
    @Autowired
    private IDmDayDataService dmDayDataService;

    /**
     * 查询每天数据列表
     */
    @PreAuthorize("@ss.hasPermi('dm:daydata:list')")
    @GetMapping("/list")
    public TableDataInfo list(DmDayData dmDayData)
    {
        startPage();
        List<DmDayData> list = dmDayDataService.selectDmDayDataList(dmDayData);
        return getDataTable(list);
    }

    /**
     * 导出每天数据列表
     */
    @PreAuthorize("@ss.hasPermi('dm:daydata:export')")
    @Log(title = "每天数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DmDayData dmDayData)
    {
        List<DmDayData> list = dmDayDataService.selectDmDayDataList(dmDayData);
        ExcelUtil<DmDayData> util = new ExcelUtil<DmDayData>(DmDayData.class);
        util.exportExcel(response, list, "每天数据数据");
    }

    /**
     * 获取每天数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('dm:daydata:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(dmDayDataService.selectDmDayDataById(id));
    }

    /**
     * 新增每天数据
     */
    @PreAuthorize("@ss.hasPermi('dm:daydata:add')")
    @Log(title = "每天数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DmDayData dmDayData)
    {
        return toAjax(dmDayDataService.insertDmDayData(dmDayData));
    }

    /**
     * 修改每天数据
     */
    @PreAuthorize("@ss.hasPermi('dm:daydata:edit')")
    @Log(title = "每天数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DmDayData dmDayData)
    {
        return toAjax(dmDayDataService.updateDmDayData(dmDayData));
    }

    /**
     * 删除每天数据
     */
    @PreAuthorize("@ss.hasPermi('dm:daydata:remove')")
    @Log(title = "每天数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(dmDayDataService.deleteDmDayDataByIds(ids));
    }
}
