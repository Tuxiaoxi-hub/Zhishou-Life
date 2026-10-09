package zhishoulife.system.controller;

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
import zhishoulife.common.annotation.Log;
import zhishoulife.common.core.controller.BaseController;
import zhishoulife.common.core.domain.AjaxResult;
import zhishoulife.common.enums.BusinessType;
import zhishoulife.system.domain.LifeFoodTaboo;
import zhishoulife.system.service.ILifeFoodTabooService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 饮食禁忌与搭配Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/life/taboo")
public class LifeFoodTabooController extends BaseController
{
    @Autowired
    private ILifeFoodTabooService lifeFoodTabooService;

    /**
     * 查询饮食禁忌与搭配列表
     */
    @PreAuthorize("@ss.hasPermi('life:taboo:list')")
    @GetMapping("/list")
    public TableDataInfo list(LifeFoodTaboo lifeFoodTaboo)
    {
        startPage();
        List<LifeFoodTaboo> list = lifeFoodTabooService.selectLifeFoodTabooList(lifeFoodTaboo);
        return getDataTable(list);
    }

    /**
     * 导出饮食禁忌与搭配列表
     */
    @PreAuthorize("@ss.hasPermi('life:taboo:export')")
    @Log(title = "饮食禁忌与搭配", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LifeFoodTaboo lifeFoodTaboo)
    {
        List<LifeFoodTaboo> list = lifeFoodTabooService.selectLifeFoodTabooList(lifeFoodTaboo);
        ExcelUtil<LifeFoodTaboo> util = new ExcelUtil<LifeFoodTaboo>(LifeFoodTaboo.class);
        util.exportExcel(response, list, "饮食禁忌与搭配数据");
    }

    /**
     * 获取饮食禁忌与搭配详细信息
     */
    @PreAuthorize("@ss.hasPermi('life:taboo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(lifeFoodTabooService.selectLifeFoodTabooById(id));
    }

    /**
     * 新增饮食禁忌与搭配
     */
    @PreAuthorize("@ss.hasPermi('life:taboo:add')")
    @Log(title = "饮食禁忌与搭配", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LifeFoodTaboo lifeFoodTaboo)
    {
        return toAjax(lifeFoodTabooService.insertLifeFoodTaboo(lifeFoodTaboo));
    }

    /**
     * 修改饮食禁忌与搭配
     */
    @PreAuthorize("@ss.hasPermi('life:taboo:edit')")
    @Log(title = "饮食禁忌与搭配", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LifeFoodTaboo lifeFoodTaboo)
    {
        return toAjax(lifeFoodTabooService.updateLifeFoodTaboo(lifeFoodTaboo));
    }

    /**
     * 删除饮食禁忌与搭配
     */
    @PreAuthorize("@ss.hasPermi('life:taboo:remove')")
    @Log(title = "饮食禁忌与搭配", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lifeFoodTabooService.deleteLifeFoodTabooByIds(ids));
    }
}
