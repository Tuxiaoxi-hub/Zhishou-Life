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
import zhishoulife.system.domain.SafetyFoodIdentify;
import zhishoulife.system.service.ISafetyFoodIdentifyService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 食品辨别技巧Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/safety/identify")
public class SafetyFoodIdentifyController extends BaseController
{
    @Autowired
    private ISafetyFoodIdentifyService safetyFoodIdentifyService;

    /**
     * 查询食品辨别技巧列表
     */
    @PreAuthorize("@ss.hasPermi('safety:identify:list')")
    @GetMapping("/list")
    public TableDataInfo list(SafetyFoodIdentify safetyFoodIdentify)
    {
        startPage();
        List<SafetyFoodIdentify> list = safetyFoodIdentifyService.selectSafetyFoodIdentifyList(safetyFoodIdentify);
        return getDataTable(list);
    }

    /**
     * 导出食品辨别技巧列表
     */
    @PreAuthorize("@ss.hasPermi('safety:identify:export')")
    @Log(title = "食品辨别技巧", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SafetyFoodIdentify safetyFoodIdentify)
    {
        List<SafetyFoodIdentify> list = safetyFoodIdentifyService.selectSafetyFoodIdentifyList(safetyFoodIdentify);
        ExcelUtil<SafetyFoodIdentify> util = new ExcelUtil<SafetyFoodIdentify>(SafetyFoodIdentify.class);
        util.exportExcel(response, list, "食品辨别技巧数据");
    }

    /**
     * 获取食品辨别技巧详细信息
     */
    @PreAuthorize("@ss.hasPermi('safety:identify:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(safetyFoodIdentifyService.selectSafetyFoodIdentifyById(id));
    }

    /**
     * 新增食品辨别技巧
     */
    @PreAuthorize("@ss.hasPermi('safety:identify:add')")
    @Log(title = "食品辨别技巧", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SafetyFoodIdentify safetyFoodIdentify)
    {
        return toAjax(safetyFoodIdentifyService.insertSafetyFoodIdentify(safetyFoodIdentify));
    }

    /**
     * 修改食品辨别技巧
     */
    @PreAuthorize("@ss.hasPermi('safety:identify:edit')")
    @Log(title = "食品辨别技巧", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SafetyFoodIdentify safetyFoodIdentify)
    {
        return toAjax(safetyFoodIdentifyService.updateSafetyFoodIdentify(safetyFoodIdentify));
    }

    /**
     * 删除食品辨别技巧
     */
    @PreAuthorize("@ss.hasPermi('safety:identify:remove')")
    @Log(title = "食品辨别技巧", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(safetyFoodIdentifyService.deleteSafetyFoodIdentifyByIds(ids));
    }
}
