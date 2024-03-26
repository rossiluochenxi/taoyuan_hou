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
import com.ruoyi.dm.domain.DmRtdata;
import com.ruoyi.dm.service.IDmRtdataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 冻结数据Controller
 *
 * @author 罗晨熙
 * @date 2024-03-16
 */
@RestController
@RequestMapping("/dm/rtdata")
public class DmRtdataController extends BaseController {
    @Autowired
    private IDmRtdataService dmRtdataService;

    /**
     * 查询冻结数据列表
     */
    @PreAuthorize("@ss.hasPermi('dm:rtdata:list')")
    @GetMapping("/list")
    public TableDataInfo list(DmRtdata dmRtdata) {
        startPage();
        List<DmRtdata> list = dmRtdataService.selectDmRtdataList(dmRtdata);
        return getDataTable(list);
    }

    /**
     * 导出冻结数据列表
     */
    @PreAuthorize("@ss.hasPermi('dm:rtdata:export')")
    @Log(title = "冻结数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DmRtdata dmRtdata) {
        List<DmRtdata> list = dmRtdataService.selectDmRtdataList(dmRtdata);
        ExcelUtil<DmRtdata> util = new ExcelUtil<DmRtdata>(DmRtdata.class);
        util.exportExcel(response, list, "冻结数据数据");
    }

    /**
     * 获取冻结数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('dm:rtdata:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return success(dmRtdataService.selectDmRtdataById(id));
    }

    /**
     * 新增冻结数据
     */
    @PreAuthorize("@ss.hasPermi('dm:rtdata:add')")
    @Log(title = "冻结数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DmRtdata dmRtdata) {
        dmRtdata.setUserId(getUserId().toString());
        dmRtdata.setDeptId(getDeptId().toString());
        dmRtdata.setCreateBy(getUsername());
        return toAjax(dmRtdataService.insertDmRtdata(dmRtdata));
    }

    /**
     * 修改冻结数据
     */
    @PreAuthorize("@ss.hasPermi('dm:rtdata:edit')")
    @Log(title = "冻结数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DmRtdata dmRtdata) {
        dmRtdata.setCreateBy(getUsername());
        return toAjax(dmRtdataService.updateDmRtdata(dmRtdata));
    }

    /**
     * 删除冻结数据
     */
    @PreAuthorize("@ss.hasPermi('dm:rtdata:remove')")
    @Log(title = "冻结数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(dmRtdataService.deleteDmRtdataByIds(ids));
    }
}
