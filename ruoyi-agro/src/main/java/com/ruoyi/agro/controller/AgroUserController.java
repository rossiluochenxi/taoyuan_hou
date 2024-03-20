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
import com.ruoyi.agro.domain.AgroUser;
import com.ruoyi.agro.service.IAgroUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 养殖户管理Controller
 *
 * @author 罗晨熙
 * @date 2024-03-13
 */
@RestController
@RequestMapping("/agro/user")
public class AgroUserController extends BaseController {
    @Autowired
    private IAgroUserService agroUserService;

    /**
     * 查询养殖户管理列表
     */
    @PreAuthorize("@ss.hasPermi('agro:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(AgroUser agroUser) {
        startPage();
        List<AgroUser> list = agroUserService.selectAgroUserList(agroUser);
        return getDataTable(list);
    }

    /**
     * 导出养殖户管理列表
     */
    @PreAuthorize("@ss.hasPermi('agro:user:export')")
    @Log(title = "养殖户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AgroUser agroUser) {
        List<AgroUser> list = agroUserService.selectAgroUserList(agroUser);
        ExcelUtil<AgroUser> util = new ExcelUtil<AgroUser>(AgroUser.class);
        util.exportExcel(response, list, "养殖户管理数据");
    }

    /**
     * 获取养殖户管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('agro:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return success(agroUserService.selectAgroUserById(id));
    }

    /**
     * 新增养殖户管理
     */
    @PreAuthorize("@ss.hasPermi('agro:user:add')")
    @Log(title = "养殖户管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AgroUser agroUser) {
        agroUser.setCreateBy(getUsername());
        return toAjax(agroUserService.insertAgroUser(agroUser));
    }

    /**
     * 修改养殖户管理
     */
    @PreAuthorize("@ss.hasPermi('agro:user:edit')")
    @Log(title = "养殖户管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AgroUser agroUser) {
        agroUser.setUpdateBy(getUsername());
        return toAjax(agroUserService.updateAgroUser(agroUser));
    }

    /**
     * 删除养殖户管理
     */
    @PreAuthorize("@ss.hasPermi('agro:user:remove')")
    @Log(title = "养殖户管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(agroUserService.deleteAgroUserByIds(ids));
    }
}
