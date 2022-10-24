package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.system.domain.LdEat;
import com.ruoyi.system.service.ILdEatService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 吃什么Controller
 *
 * @author ruoyi
 * @date 2022-09-23
 */
@RestController
@RequestMapping("/system/eat")
@Api("eat")
public class LdEatController extends BaseController {
    @Autowired
    private ILdEatService ldEatService;

    /**
     * 查询吃什么列表
     */
    @PreAuthorize("@ss.hasPermi('system:eat:list')")
    @GetMapping("/list")
    public TableDataInfo list(LdEat ldEat) {
        startPage();
        List<LdEat> list = ldEatService.selectLdEatList(ldEat);

        return getDataTable(list);
    }

    /**
     * 导出吃什么列表
     */
    @PreAuthorize("@ss.hasPermi('system:eat:export')")
    @Log(title = "吃什么", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LdEat ldEat) {
        List<LdEat> list = ldEatService.selectLdEatList(ldEat);
        ExcelUtil<LdEat> util = new ExcelUtil<LdEat>(LdEat.class);
        util.exportExcel(response, list, "吃什么数据");
    }

    /**
     * 获取吃什么详细信息
     */
    @ApiOperation("获取吃什么详细信息")
    @PreAuthorize("@ss.hasPermi('system:eat:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(ldEatService.getDetail(id));
    }

    /**
     * 新增吃什么
     */
    @PreAuthorize("@ss.hasPermi('system:eat:add')")
    @Log(title = "吃什么", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LdEat ldEat) {
        return toAjax(ldEatService.insertLdEat(ldEat));
    }

    /**
     * 修改吃什么
     */
    @PreAuthorize("@ss.hasPermi('system:eat:edit')")
    @Log(title = "吃什么", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LdEat ldEat) {
        return toAjax(ldEatService.updateLdEat(ldEat));
    }

    /**
     * 删除吃什么
     */
    @PreAuthorize("@ss.hasPermi('system:eat:remove')")
    @Log(title = "吃什么", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(ldEatService.deleteLdEatByIds(ids));
    }
}
