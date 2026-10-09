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
import zhishoulife.system.domain.SafetyFoodStorage;
import zhishoulife.system.service.ISafetyFoodStorageService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 食品储存安全Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/safety/storage")
public class SafetyFoodStorageController extends BaseController
{
    @Autowired
    private ISafetyFoodStorageService safetyFoodStorageService;

    /**
     * 查询食品储存安全列表
     */
    @PreAuthorize("@ss.hasPermi('safety:storage:list')")
    @GetMapping("/list")
    public TableDataInfo list(SafetyFoodStorage safetyFoodStorage)
    {
        startPage();
        List<SafetyFoodStorage> list = safetyFoodStorageService.selectSafetyFoodStorageList(safetyFoodStorage);
        return getDataTable(list);
    }

    /**
     * 导出食品储存安全列表
     */
    @PreAuthorize("@ss.hasPermi('safety:storage:export')")
    @Log(title = "食品储存安全", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SafetyFoodStorage safetyFoodStorage)
    {
        List<SafetyFoodStorage> list = safetyFoodStorageService.selectSafetyFoodStorageList(safetyFoodStorage);
        ExcelUtil<SafetyFoodStorage> util = new ExcelUtil<SafetyFoodStorage>(SafetyFoodStorage.class);
        util.exportExcel(response, list, "食品储存安全数据");
    }

    /**
     * 获取食品储存安全详细信息
     */
    @PreAuthorize("@ss.hasPermi('safety:storage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(safetyFoodStorageService.selectSafetyFoodStorageById(id));
    }

    /**
     * 新增食品储存安全
     */
    @PreAuthorize("@ss.hasPermi('safety:storage:add')")
    @Log(title = "食品储存安全", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SafetyFoodStorage safetyFoodStorage)
    {
        return toAjax(safetyFoodStorageService.insertSafetyFoodStorage(safetyFoodStorage));
    }

    /**
     * 修改食品储存安全
     */
    @PreAuthorize("@ss.hasPermi('safety:storage:edit')")
    @Log(title = "食品储存安全", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SafetyFoodStorage safetyFoodStorage)
    {
        return toAjax(safetyFoodStorageService.updateSafetyFoodStorage(safetyFoodStorage));
    }

    /**
     * 删除食品储存安全
     */
    @PreAuthorize("@ss.hasPermi('safety:storage:remove')")
    @Log(title = "食品储存安全", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(safetyFoodStorageService.deleteSafetyFoodStorageByIds(ids));
    }
}
