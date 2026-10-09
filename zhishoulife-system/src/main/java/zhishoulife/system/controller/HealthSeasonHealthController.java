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
import zhishoulife.system.domain.HealthSeasonHealth;
import zhishoulife.system.service.IHealthSeasonHealthService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 四季养生常识Controller
 * 
 * @author admin
 * @date 2026-03-27
 */
@RestController
@RequestMapping("/health/season")
public class HealthSeasonHealthController extends BaseController
{
    @Autowired
    private IHealthSeasonHealthService healthSeasonHealthService;

    /**
     * 查询四季养生常识列表
     */
    @PreAuthorize("@ss.hasPermi('health:season:list')")
    @GetMapping("/list")
    public TableDataInfo list(HealthSeasonHealth healthSeasonHealth)
    {
        startPage();
        List<HealthSeasonHealth> list = healthSeasonHealthService.selectHealthSeasonHealthList(healthSeasonHealth);
        return getDataTable(list);
    }

    /**
     * 导出四季养生常识列表
     */
    @PreAuthorize("@ss.hasPermi('health:season:export')")
    @Log(title = "四季养生常识", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HealthSeasonHealth healthSeasonHealth)
    {
        List<HealthSeasonHealth> list = healthSeasonHealthService.selectHealthSeasonHealthList(healthSeasonHealth);
        ExcelUtil<HealthSeasonHealth> util = new ExcelUtil<HealthSeasonHealth>(HealthSeasonHealth.class);
        util.exportExcel(response, list, "四季养生常识数据");
    }

    /**
     * 获取四季养生常识详细信息
     */
    @PreAuthorize("@ss.hasPermi('health:season:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(healthSeasonHealthService.selectHealthSeasonHealthById(id));
    }

    /**
     * 新增四季养生常识
     */
    @PreAuthorize("@ss.hasPermi('health:season:add')")
    @Log(title = "四季养生常识", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HealthSeasonHealth healthSeasonHealth)
    {
        return toAjax(healthSeasonHealthService.insertHealthSeasonHealth(healthSeasonHealth));
    }

    /**
     * 修改四季养生常识
     */
    @PreAuthorize("@ss.hasPermi('health:season:edit')")
    @Log(title = "四季养生常识", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HealthSeasonHealth healthSeasonHealth)
    {
        return toAjax(healthSeasonHealthService.updateHealthSeasonHealth(healthSeasonHealth));
    }

    /**
     * 删除四季养生常识
     */
    @PreAuthorize("@ss.hasPermi('health:season:remove')")
    @Log(title = "四季养生常识", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(healthSeasonHealthService.deleteHealthSeasonHealthByIds(ids));
    }
}
