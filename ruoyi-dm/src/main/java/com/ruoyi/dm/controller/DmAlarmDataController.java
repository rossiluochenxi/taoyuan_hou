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
import com.ruoyi.dm.domain.DmAlarmData;
import com.ruoyi.dm.service.IDmAlarmDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报警数据Controller
 * 
 * @author 罗晨熙
 * @date 2024-04-24
 */
@RestController
@RequestMapping("/dm/alarm")
public class DmAlarmDataController extends BaseController
{
    @Autowired
    private IDmAlarmDataService dmAlarmDataService;

    /**
     * 查询报警数据列表
     */
    @PreAuthorize("@ss.hasPermi('dm:alarm:list')")
    @GetMapping("/list")
    public TableDataInfo list(DmAlarmData dmAlarmData)
    {
        startPage();
        List<DmAlarmData> list = dmAlarmDataService.selectDmAlarmDataList(dmAlarmData);
        return getDataTable(list);
    }

    /**
     * 导出报警数据列表
     */
    @PreAuthorize("@ss.hasPermi('dm:alarm:export')")
    @Log(title = "报警数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DmAlarmData dmAlarmData)
    {
        List<DmAlarmData> list = dmAlarmDataService.selectDmAlarmDataList(dmAlarmData);
        ExcelUtil<DmAlarmData> util = new ExcelUtil<DmAlarmData>(DmAlarmData.class);
        util.exportExcel(response, list, "报警数据数据");
    }

    /**
     * 获取报警数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('dm:alarm:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(dmAlarmDataService.selectDmAlarmDataById(id));
    }

    /**
     * 新增报警数据
     */
    @PreAuthorize("@ss.hasPermi('dm:alarm:add')")
    @Log(title = "报警数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DmAlarmData dmAlarmData)
    {
        return toAjax(dmAlarmDataService.insertDmAlarmData(dmAlarmData));
    }

    /**
     * 修改报警数据
     */
    @PreAuthorize("@ss.hasPermi('dm:alarm:edit')")
    @Log(title = "报警数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DmAlarmData dmAlarmData)
    {
        return toAjax(dmAlarmDataService.updateDmAlarmData(dmAlarmData));
    }

    /**
     * 删除报警数据
     */
    @PreAuthorize("@ss.hasPermi('dm:alarm:remove')")
    @Log(title = "报警数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(dmAlarmDataService.deleteDmAlarmDataByIds(ids));
    }
}
