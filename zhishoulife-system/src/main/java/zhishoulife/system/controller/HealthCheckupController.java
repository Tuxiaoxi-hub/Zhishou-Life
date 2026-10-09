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
import zhishoulife.system.domain.HealthCheckup;
import zhishoulife.system.service.IHealthCheckupService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 体检知识科普Controller
 * 
 * @author admin
 * @date 2026-03-27
 */
@RestController
@RequestMapping("/health/checkup")
public class HealthCheckupController extends BaseController
{
    @Autowired
    private IHealthCheckupService healthCheckupService;

    /**
     * 查询体检知识科普列表
     */
    @PreAuthorize("@ss.hasPermi('health:checkup:list')")
    @GetMapping("/list")
    public TableDataInfo list(HealthCheckup healthCheckup)
    {
        startPage();
        List<HealthCheckup> list = healthCheckupService.selectHealthCheckupList(healthCheckup);
        return getDataTable(list);
    }

    /**
     * 导出体检知识科普列表
     */
    @PreAuthorize("@ss.hasPermi('health:checkup:export')")
    @Log(title = "体检知识科普", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HealthCheckup healthCheckup)
    {
        List<HealthCheckup> list = healthCheckupService.selectHealthCheckupList(healthCheckup);
        ExcelUtil<HealthCheckup> util = new ExcelUtil<HealthCheckup>(HealthCheckup.class);
        util.exportExcel(response, list, "体检知识科普数据");
    }

    /**
     * 获取体检知识科普详细信息
     */
    @PreAuthorize("@ss.hasPermi('health:checkup:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(healthCheckupService.selectHealthCheckupById(id));
    }

    /**
     * 新增体检知识科普
     */
    @PreAuthorize("@ss.hasPermi('health:checkup:add')")
    @Log(title = "体检知识科普", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HealthCheckup healthCheckup)
    {
        return toAjax(healthCheckupService.insertHealthCheckup(healthCheckup));
    }

    /**
     * 修改体检知识科普
     */
    @PreAuthorize("@ss.hasPermi('health:checkup:edit')")
    @Log(title = "体检知识科普", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HealthCheckup healthCheckup)
    {
        return toAjax(healthCheckupService.updateHealthCheckup(healthCheckup));
    }

    /**
     * 删除体检知识科普
     */
    @PreAuthorize("@ss.hasPermi('health:checkup:remove')")
    @Log(title = "体检知识科普", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(healthCheckupService.deleteHealthCheckupByIds(ids));
    }
}
