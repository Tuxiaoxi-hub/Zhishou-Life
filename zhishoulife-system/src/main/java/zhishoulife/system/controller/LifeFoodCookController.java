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
import zhishoulife.system.domain.LifeFoodCook;
import zhishoulife.system.service.ILifeFoodCookService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 家常菜烹饪Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/life/cook")
public class LifeFoodCookController extends BaseController
{
    @Autowired
    private ILifeFoodCookService lifeFoodCookService;

    /**
     * 查询家常菜烹饪列表
     */
    @PreAuthorize("@ss.hasPermi('life:cook:list')")
    @GetMapping("/list")
    public TableDataInfo list(LifeFoodCook lifeFoodCook)
    {
        startPage();
        List<LifeFoodCook> list = lifeFoodCookService.selectLifeFoodCookList(lifeFoodCook);
        return getDataTable(list);
    }

    /**
     * 导出家常菜烹饪列表
     */
    @PreAuthorize("@ss.hasPermi('life:cook:export')")
    @Log(title = "家常菜烹饪", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LifeFoodCook lifeFoodCook)
    {
        List<LifeFoodCook> list = lifeFoodCookService.selectLifeFoodCookList(lifeFoodCook);
        ExcelUtil<LifeFoodCook> util = new ExcelUtil<LifeFoodCook>(LifeFoodCook.class);
        util.exportExcel(response, list, "家常菜烹饪数据");
    }

    /**
     * 获取家常菜烹饪详细信息
     */
    @PreAuthorize("@ss.hasPermi('life:cook:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(lifeFoodCookService.selectLifeFoodCookById(id));
    }

    /**
     * 新增家常菜烹饪
     */
    @PreAuthorize("@ss.hasPermi('life:cook:add')")
    @Log(title = "家常菜烹饪", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LifeFoodCook lifeFoodCook)
    {
        return toAjax(lifeFoodCookService.insertLifeFoodCook(lifeFoodCook));
    }

    /**
     * 修改家常菜烹饪
     */
    @PreAuthorize("@ss.hasPermi('life:cook:edit')")
    @Log(title = "家常菜烹饪", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LifeFoodCook lifeFoodCook)
    {
        return toAjax(lifeFoodCookService.updateLifeFoodCook(lifeFoodCook));
    }

    /**
     * 删除家常菜烹饪
     */
    @PreAuthorize("@ss.hasPermi('life:cook:remove')")
    @Log(title = "家常菜烹饪", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lifeFoodCookService.deleteLifeFoodCookByIds(ids));
    }
}
