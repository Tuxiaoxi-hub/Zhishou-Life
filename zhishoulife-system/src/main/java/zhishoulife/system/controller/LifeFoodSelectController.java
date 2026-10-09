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
import zhishoulife.system.domain.LifeFoodSelect;
import zhishoulife.system.service.ILifeFoodSelectService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 食材挑选与保存Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/life/select")
public class LifeFoodSelectController extends BaseController
{
    @Autowired
    private ILifeFoodSelectService lifeFoodSelectService;

    /**
     * 查询食材挑选与保存列表
     */
    @PreAuthorize("@ss.hasPermi('life:select:list')")
    @GetMapping("/list")
    public TableDataInfo list(LifeFoodSelect lifeFoodSelect)
    {
        startPage();
        List<LifeFoodSelect> list = lifeFoodSelectService.selectLifeFoodSelectList(lifeFoodSelect);
        return getDataTable(list);
    }

    /**
     * 导出食材挑选与保存列表
     */
    @PreAuthorize("@ss.hasPermi('life:select:export')")
    @Log(title = "食材挑选与保存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LifeFoodSelect lifeFoodSelect)
    {
        List<LifeFoodSelect> list = lifeFoodSelectService.selectLifeFoodSelectList(lifeFoodSelect);
        ExcelUtil<LifeFoodSelect> util = new ExcelUtil<LifeFoodSelect>(LifeFoodSelect.class);
        util.exportExcel(response, list, "食材挑选与保存数据");
    }

    /**
     * 获取食材挑选与保存详细信息
     */
    @PreAuthorize("@ss.hasPermi('life:select:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(lifeFoodSelectService.selectLifeFoodSelectById(id));
    }

    /**
     * 新增食材挑选与保存
     */
    @PreAuthorize("@ss.hasPermi('life:select:add')")
    @Log(title = "食材挑选与保存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LifeFoodSelect lifeFoodSelect)
    {
        return toAjax(lifeFoodSelectService.insertLifeFoodSelect(lifeFoodSelect));
    }

    /**
     * 修改食材挑选与保存
     */
    @PreAuthorize("@ss.hasPermi('life:select:edit')")
    @Log(title = "食材挑选与保存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LifeFoodSelect lifeFoodSelect)
    {
        return toAjax(lifeFoodSelectService.updateLifeFoodSelect(lifeFoodSelect));
    }

    /**
     * 删除食材挑选与保存
     */
    @PreAuthorize("@ss.hasPermi('life:select:remove')")
    @Log(title = "食材挑选与保存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lifeFoodSelectService.deleteLifeFoodSelectByIds(ids));
    }
}
