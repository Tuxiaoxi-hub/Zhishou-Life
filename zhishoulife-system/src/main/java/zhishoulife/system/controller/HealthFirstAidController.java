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
import zhishoulife.system.domain.HealthFirstAid;
import zhishoulife.system.service.IHealthFirstAidService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 常见急救方法Controller
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
@RestController
@RequestMapping("/health/aid")
public class HealthFirstAidController extends BaseController
{
    @Autowired
    private IHealthFirstAidService healthFirstAidService;

    /**
     * 查询常见急救方法列表
     */
    @PreAuthorize("@ss.hasPermi('health:aid:list')")
    @GetMapping("/list")
    public TableDataInfo list(HealthFirstAid healthFirstAid)
    {
        startPage();
        List<HealthFirstAid> list = healthFirstAidService.selectHealthFirstAidList(healthFirstAid);
        return getDataTable(list);
    }

    /**
     * 导出常见急救方法列表
     */
    @PreAuthorize("@ss.hasPermi('health:aid:export')")
    @Log(title = "常见急救方法", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HealthFirstAid healthFirstAid)
    {
        List<HealthFirstAid> list = healthFirstAidService.selectHealthFirstAidList(healthFirstAid);
        ExcelUtil<HealthFirstAid> util = new ExcelUtil<HealthFirstAid>(HealthFirstAid.class);
        util.exportExcel(response, list, "常见急救方法数据");
    }

    /**
     * 获取常见急救方法详细信息
     */
    @PreAuthorize("@ss.hasPermi('health:aid:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(healthFirstAidService.selectHealthFirstAidById(id));
    }

    /**
     * 新增常见急救方法
     */
    @PreAuthorize("@ss.hasPermi('health:aid:add')")
    @Log(title = "常见急救方法", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HealthFirstAid healthFirstAid)
    {
        return toAjax(healthFirstAidService.insertHealthFirstAid(healthFirstAid));
    }

    /**
     * 修改常见急救方法
     */
    @PreAuthorize("@ss.hasPermi('health:aid:edit')")
    @Log(title = "常见急救方法", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HealthFirstAid healthFirstAid)
    {
        return toAjax(healthFirstAidService.updateHealthFirstAid(healthFirstAid));
    }

    /**
     * 删除常见急救方法
     */
    @PreAuthorize("@ss.hasPermi('health:aid:remove')")
    @Log(title = "常见急救方法", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(healthFirstAidService.deleteHealthFirstAidByIds(ids));
    }
}
