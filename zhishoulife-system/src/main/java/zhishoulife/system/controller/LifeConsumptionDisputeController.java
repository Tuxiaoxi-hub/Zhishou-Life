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
import zhishoulife.system.domain.LifeConsumptionDispute;
import zhishoulife.system.service.ILifeConsumptionDisputeService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 常见消费纠纷处理Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/life/dispute")
public class LifeConsumptionDisputeController extends BaseController
{
    @Autowired
    private ILifeConsumptionDisputeService lifeConsumptionDisputeService;

    /**
     * 查询常见消费纠纷处理列表
     */
    @PreAuthorize("@ss.hasPermi('life:dispute:list')")
    @GetMapping("/list")
    public TableDataInfo list(LifeConsumptionDispute lifeConsumptionDispute)
    {
        startPage();
        List<LifeConsumptionDispute> list = lifeConsumptionDisputeService.selectLifeConsumptionDisputeList(lifeConsumptionDispute);
        return getDataTable(list);
    }

    /**
     * 导出常见消费纠纷处理列表
     */
    @PreAuthorize("@ss.hasPermi('life:dispute:export')")
    @Log(title = "常见消费纠纷处理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LifeConsumptionDispute lifeConsumptionDispute)
    {
        List<LifeConsumptionDispute> list = lifeConsumptionDisputeService.selectLifeConsumptionDisputeList(lifeConsumptionDispute);
        ExcelUtil<LifeConsumptionDispute> util = new ExcelUtil<LifeConsumptionDispute>(LifeConsumptionDispute.class);
        util.exportExcel(response, list, "常见消费纠纷处理数据");
    }

    /**
     * 获取常见消费纠纷处理详细信息
     */
    @PreAuthorize("@ss.hasPermi('life:dispute:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(lifeConsumptionDisputeService.selectLifeConsumptionDisputeById(id));
    }

    /**
     * 新增常见消费纠纷处理
     */
    @PreAuthorize("@ss.hasPermi('life:dispute:add')")
    @Log(title = "常见消费纠纷处理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LifeConsumptionDispute lifeConsumptionDispute)
    {
        return toAjax(lifeConsumptionDisputeService.insertLifeConsumptionDispute(lifeConsumptionDispute));
    }

    /**
     * 修改常见消费纠纷处理
     */
    @PreAuthorize("@ss.hasPermi('life:dispute:edit')")
    @Log(title = "常见消费纠纷处理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LifeConsumptionDispute lifeConsumptionDispute)
    {
        return toAjax(lifeConsumptionDisputeService.updateLifeConsumptionDispute(lifeConsumptionDispute));
    }

    /**
     * 删除常见消费纠纷处理
     */
    @PreAuthorize("@ss.hasPermi('life:dispute:remove')")
    @Log(title = "常见消费纠纷处理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lifeConsumptionDisputeService.deleteLifeConsumptionDisputeByIds(ids));
    }
}
