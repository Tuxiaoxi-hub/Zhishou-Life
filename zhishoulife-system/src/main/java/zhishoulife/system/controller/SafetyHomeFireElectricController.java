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
import zhishoulife.system.domain.SafetyHomeFireElectric;
import zhishoulife.system.service.ISafetyHomeFireElectricService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 用火用电安全Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/safety/electric")
public class SafetyHomeFireElectricController extends BaseController
{
    @Autowired
    private ISafetyHomeFireElectricService safetyHomeFireElectricService;

    /**
     * 查询用火用电安全列表
     */
    @PreAuthorize("@ss.hasPermi('safety:electric:list')")
    @GetMapping("/list")
    public TableDataInfo list(SafetyHomeFireElectric safetyHomeFireElectric)
    {
        startPage();
        List<SafetyHomeFireElectric> list = safetyHomeFireElectricService.selectSafetyHomeFireElectricList(safetyHomeFireElectric);
        return getDataTable(list);
    }

    /**
     * 导出用火用电安全列表
     */
    @PreAuthorize("@ss.hasPermi('safety:electric:export')")
    @Log(title = "用火用电安全", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SafetyHomeFireElectric safetyHomeFireElectric)
    {
        List<SafetyHomeFireElectric> list = safetyHomeFireElectricService.selectSafetyHomeFireElectricList(safetyHomeFireElectric);
        ExcelUtil<SafetyHomeFireElectric> util = new ExcelUtil<SafetyHomeFireElectric>(SafetyHomeFireElectric.class);
        util.exportExcel(response, list, "用火用电安全数据");
    }

    /**
     * 获取用火用电安全详细信息
     */
    @PreAuthorize("@ss.hasPermi('safety:electric:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(safetyHomeFireElectricService.selectSafetyHomeFireElectricById(id));
    }

    /**
     * 新增用火用电安全
     */
    @PreAuthorize("@ss.hasPermi('safety:electric:add')")
    @Log(title = "用火用电安全", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SafetyHomeFireElectric safetyHomeFireElectric)
    {
        return toAjax(safetyHomeFireElectricService.insertSafetyHomeFireElectric(safetyHomeFireElectric));
    }

    /**
     * 修改用火用电安全
     */
    @PreAuthorize("@ss.hasPermi('safety:electric:edit')")
    @Log(title = "用火用电安全", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SafetyHomeFireElectric safetyHomeFireElectric)
    {
        return toAjax(safetyHomeFireElectricService.updateSafetyHomeFireElectric(safetyHomeFireElectric));
    }

    /**
     * 删除用火用电安全
     */
    @PreAuthorize("@ss.hasPermi('safety:electric:remove')")
    @Log(title = "用火用电安全", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(safetyHomeFireElectricService.deleteSafetyHomeFireElectricByIds(ids));
    }
}
