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
import zhishoulife.system.domain.HealthBasicNursing;
import zhishoulife.system.service.IHealthBasicNursingService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 常见病症护理Controller
 * 
 * @author admin
 * @date 2026-03-27
 */
@RestController
@RequestMapping("/health/nursing")
public class HealthBasicNursingController extends BaseController
{
    @Autowired
    private IHealthBasicNursingService healthBasicNursingService;

    /**
     * 查询常见病症护理列表
     */
    @PreAuthorize("@ss.hasPermi('health:nursing:list')")
    @GetMapping("/list")
    public TableDataInfo list(HealthBasicNursing healthBasicNursing)
    {
        startPage();
        List<HealthBasicNursing> list = healthBasicNursingService.selectHealthBasicNursingList(healthBasicNursing);
        return getDataTable(list);
    }

    /**
     * 导出常见病症护理列表
     */
    @PreAuthorize("@ss.hasPermi('health:nursing:export')")
    @Log(title = "常见病症护理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HealthBasicNursing healthBasicNursing)
    {
        List<HealthBasicNursing> list = healthBasicNursingService.selectHealthBasicNursingList(healthBasicNursing);
        ExcelUtil<HealthBasicNursing> util = new ExcelUtil<HealthBasicNursing>(HealthBasicNursing.class);
        util.exportExcel(response, list, "常见病症护理数据");
    }

    /**
     * 获取常见病症护理详细信息
     */
    @PreAuthorize("@ss.hasPermi('health:nursing:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(healthBasicNursingService.selectHealthBasicNursingById(id));
    }

    /**
     * 新增常见病症护理
     */
    @PreAuthorize("@ss.hasPermi('health:nursing:add')")
    @Log(title = "常见病症护理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HealthBasicNursing healthBasicNursing)
    {
        return toAjax(healthBasicNursingService.insertHealthBasicNursing(healthBasicNursing));
    }

    /**
     * 修改常见病症护理
     */
    @PreAuthorize("@ss.hasPermi('health:nursing:edit')")
    @Log(title = "常见病症护理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HealthBasicNursing healthBasicNursing)
    {
        return toAjax(healthBasicNursingService.updateHealthBasicNursing(healthBasicNursing));
    }

    /**
     * 删除常见病症护理
     */
    @PreAuthorize("@ss.hasPermi('health:nursing:remove')")
    @Log(title = "常见病症护理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(healthBasicNursingService.deleteHealthBasicNursingByIds(ids));
    }
}
