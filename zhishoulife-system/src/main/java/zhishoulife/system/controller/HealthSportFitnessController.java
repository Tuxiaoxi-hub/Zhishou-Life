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
import zhishoulife.system.domain.HealthSportFitness;
import zhishoulife.system.service.IHealthSportFitnessService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 运动健身常识Controller
 * 
 * @author admin
 * @date 2026-03-27
 */
@RestController
@RequestMapping("/health/sport")
public class HealthSportFitnessController extends BaseController
{
    @Autowired
    private IHealthSportFitnessService healthSportFitnessService;

    /**
     * 查询运动健身常识列表
     */
    @PreAuthorize("@ss.hasPermi('health:sport:list')")
    @GetMapping("/list")
    public TableDataInfo list(HealthSportFitness healthSportFitness)
    {
        startPage();
        List<HealthSportFitness> list = healthSportFitnessService.selectHealthSportFitnessList(healthSportFitness);
        return getDataTable(list);
    }

    /**
     * 导出运动健身常识列表
     */
    @PreAuthorize("@ss.hasPermi('health:sport:export')")
    @Log(title = "运动健身常识", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HealthSportFitness healthSportFitness)
    {
        List<HealthSportFitness> list = healthSportFitnessService.selectHealthSportFitnessList(healthSportFitness);
        ExcelUtil<HealthSportFitness> util = new ExcelUtil<HealthSportFitness>(HealthSportFitness.class);
        util.exportExcel(response, list, "运动健身常识数据");
    }

    /**
     * 获取运动健身常识详细信息
     */
    @PreAuthorize("@ss.hasPermi('health:sport:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(healthSportFitnessService.selectHealthSportFitnessById(id));
    }

    /**
     * 新增运动健身常识
     */
    @PreAuthorize("@ss.hasPermi('health:sport:add')")
    @Log(title = "运动健身常识", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HealthSportFitness healthSportFitness)
    {
        return toAjax(healthSportFitnessService.insertHealthSportFitness(healthSportFitness));
    }

    /**
     * 修改运动健身常识
     */
    @PreAuthorize("@ss.hasPermi('health:sport:edit')")
    @Log(title = "运动健身常识", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HealthSportFitness healthSportFitness)
    {
        return toAjax(healthSportFitnessService.updateHealthSportFitness(healthSportFitness));
    }

    /**
     * 删除运动健身常识
     */
    @PreAuthorize("@ss.hasPermi('health:sport:remove')")
    @Log(title = "运动健身常识", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(healthSportFitnessService.deleteHealthSportFitnessByIds(ids));
    }
}
