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
import zhishoulife.system.domain.HealthTraumaTreat;
import zhishoulife.system.service.IHealthTraumaTreatService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 外伤应急处理Controller
 * 
 * @author admin
 * @date 2026-03-27
 */
@RestController
@RequestMapping("/health/trauma")
public class HealthTraumaTreatController extends BaseController
{
    @Autowired
    private IHealthTraumaTreatService healthTraumaTreatService;

    /**
     * 查询外伤应急处理列表
     */
    @PreAuthorize("@ss.hasPermi('health:trauma:list')")
    @GetMapping("/list")
    public TableDataInfo list(HealthTraumaTreat healthTraumaTreat)
    {
        startPage();
        List<HealthTraumaTreat> list = healthTraumaTreatService.selectHealthTraumaTreatList(healthTraumaTreat);
        return getDataTable(list);
    }

    /**
     * 导出外伤应急处理列表
     */
    @PreAuthorize("@ss.hasPermi('health:trauma:export')")
    @Log(title = "外伤应急处理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HealthTraumaTreat healthTraumaTreat)
    {
        List<HealthTraumaTreat> list = healthTraumaTreatService.selectHealthTraumaTreatList(healthTraumaTreat);
        ExcelUtil<HealthTraumaTreat> util = new ExcelUtil<HealthTraumaTreat>(HealthTraumaTreat.class);
        util.exportExcel(response, list, "外伤应急处理数据");
    }

    /**
     * 获取外伤应急处理详细信息
     */
    @PreAuthorize("@ss.hasPermi('health:trauma:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(healthTraumaTreatService.selectHealthTraumaTreatById(id));
    }

    /**
     * 新增外伤应急处理
     */
    @PreAuthorize("@ss.hasPermi('health:trauma:add')")
    @Log(title = "外伤应急处理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HealthTraumaTreat healthTraumaTreat)
    {
        return toAjax(healthTraumaTreatService.insertHealthTraumaTreat(healthTraumaTreat));
    }

    /**
     * 修改外伤应急处理
     */
    @PreAuthorize("@ss.hasPermi('health:trauma:edit')")
    @Log(title = "外伤应急处理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HealthTraumaTreat healthTraumaTreat)
    {
        return toAjax(healthTraumaTreatService.updateHealthTraumaTreat(healthTraumaTreat));
    }

    /**
     * 删除外伤应急处理
     */
    @PreAuthorize("@ss.hasPermi('health:trauma:remove')")
    @Log(title = "外伤应急处理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(healthTraumaTreatService.deleteHealthTraumaTreatByIds(ids));
    }
}
