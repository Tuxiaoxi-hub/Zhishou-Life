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
import zhishoulife.system.domain.HealthMedicalProcess;
import zhishoulife.system.service.IHealthMedicalProcessService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 就医流程指南Controller
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
@RestController
@RequestMapping("/health/process")
public class HealthMedicalProcessController extends BaseController
{
    @Autowired
    private IHealthMedicalProcessService healthMedicalProcessService;

    /**
     * 查询就医流程指南列表
     */
    @PreAuthorize("@ss.hasPermi('health:process:list')")
    @GetMapping("/list")
    public TableDataInfo list(HealthMedicalProcess healthMedicalProcess)
    {
        startPage();
        List<HealthMedicalProcess> list = healthMedicalProcessService.selectHealthMedicalProcessList(healthMedicalProcess);
        return getDataTable(list);
    }

    /**
     * 导出就医流程指南列表
     */
    @PreAuthorize("@ss.hasPermi('health:process:export')")
    @Log(title = "就医流程指南", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HealthMedicalProcess healthMedicalProcess)
    {
        List<HealthMedicalProcess> list = healthMedicalProcessService.selectHealthMedicalProcessList(healthMedicalProcess);
        ExcelUtil<HealthMedicalProcess> util = new ExcelUtil<HealthMedicalProcess>(HealthMedicalProcess.class);
        util.exportExcel(response, list, "就医流程指南数据");
    }

    /**
     * 获取就医流程指南详细信息
     */
    @PreAuthorize("@ss.hasPermi('health:process:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(healthMedicalProcessService.selectHealthMedicalProcessById(id));
    }

    /**
     * 新增就医流程指南
     */
    @PreAuthorize("@ss.hasPermi('health:process:add')")
    @Log(title = "就医流程指南", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HealthMedicalProcess healthMedicalProcess)
    {
        return toAjax(healthMedicalProcessService.insertHealthMedicalProcess(healthMedicalProcess));
    }

    /**
     * 修改就医流程指南
     */
    @PreAuthorize("@ss.hasPermi('health:process:edit')")
    @Log(title = "就医流程指南", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HealthMedicalProcess healthMedicalProcess)
    {
        return toAjax(healthMedicalProcessService.updateHealthMedicalProcess(healthMedicalProcess));
    }

    /**
     * 删除就医流程指南
     */
    @PreAuthorize("@ss.hasPermi('health:process:remove')")
    @Log(title = "就医流程指南", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(healthMedicalProcessService.deleteHealthMedicalProcessByIds(ids));
    }
}
