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
import zhishoulife.system.domain.HealthDrugSafety;
import zhishoulife.system.service.IHealthDrugSafetyService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 药物安全Controller
 * 
 * @author admin
 * @date 2026-04-13
 */
@RestController
@RequestMapping("/health/drug")
public class HealthDrugSafetyController extends BaseController
{
    @Autowired
    private IHealthDrugSafetyService healthDrugSafetyService;

    /**
     * 查询药物安全列表
     */
    @PreAuthorize("@ss.hasPermi('health:drug:list')")
    @GetMapping("/list")
    public TableDataInfo list(HealthDrugSafety healthDrugSafety)
    {
        startPage();
        List<HealthDrugSafety> list = healthDrugSafetyService.selectHealthDrugSafetyList(healthDrugSafety);
        return getDataTable(list);
    }

    /**
     * 导出药物安全列表
     */
    @PreAuthorize("@ss.hasPermi('health:drug:export')")
    @Log(title = "药物安全", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HealthDrugSafety healthDrugSafety)
    {
        List<HealthDrugSafety> list = healthDrugSafetyService.selectHealthDrugSafetyList(healthDrugSafety);
        ExcelUtil<HealthDrugSafety> util = new ExcelUtil<HealthDrugSafety>(HealthDrugSafety.class);
        util.exportExcel(response, list, "药物安全数据");
    }

    /**
     * 获取药物安全详细信息
     */
    @PreAuthorize("@ss.hasPermi('health:drug:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(healthDrugSafetyService.selectHealthDrugSafetyById(id));
    }

    /**
     * 新增药物安全
     */
    @PreAuthorize("@ss.hasPermi('health:drug:add')")
    @Log(title = "药物安全", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HealthDrugSafety healthDrugSafety)
    {
        return toAjax(healthDrugSafetyService.insertHealthDrugSafety(healthDrugSafety));
    }

    /**
     * 修改药物安全
     */
    @PreAuthorize("@ss.hasPermi('health:drug:edit')")
    @Log(title = "药物安全", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HealthDrugSafety healthDrugSafety)
    {
        return toAjax(healthDrugSafetyService.updateHealthDrugSafety(healthDrugSafety));
    }

    /**
     * 删除药物安全
     */
    @PreAuthorize("@ss.hasPermi('health:drug:remove')")
    @Log(title = "药物安全", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(healthDrugSafetyService.deleteHealthDrugSafetyByIds(ids));
    }
}
