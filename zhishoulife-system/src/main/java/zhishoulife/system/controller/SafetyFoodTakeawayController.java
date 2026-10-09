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
import zhishoulife.system.domain.SafetyFoodTakeaway;
import zhishoulife.system.service.ISafetyFoodTakeawayService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 外卖安全常识Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/safety/takeaway")
public class SafetyFoodTakeawayController extends BaseController
{
    @Autowired
    private ISafetyFoodTakeawayService safetyFoodTakeawayService;

    /**
     * 查询外卖安全常识列表
     */
    @PreAuthorize("@ss.hasPermi('safety:takeaway:list')")
    @GetMapping("/list")
    public TableDataInfo list(SafetyFoodTakeaway safetyFoodTakeaway)
    {
        startPage();
        List<SafetyFoodTakeaway> list = safetyFoodTakeawayService.selectSafetyFoodTakeawayList(safetyFoodTakeaway);
        return getDataTable(list);
    }

    /**
     * 导出外卖安全常识列表
     */
    @PreAuthorize("@ss.hasPermi('safety:takeaway:export')")
    @Log(title = "外卖安全常识", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SafetyFoodTakeaway safetyFoodTakeaway)
    {
        List<SafetyFoodTakeaway> list = safetyFoodTakeawayService.selectSafetyFoodTakeawayList(safetyFoodTakeaway);
        ExcelUtil<SafetyFoodTakeaway> util = new ExcelUtil<SafetyFoodTakeaway>(SafetyFoodTakeaway.class);
        util.exportExcel(response, list, "外卖安全常识数据");
    }

    /**
     * 获取外卖安全常识详细信息
     */
    @PreAuthorize("@ss.hasPermi('safety:takeaway:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(safetyFoodTakeawayService.selectSafetyFoodTakeawayById(id));
    }

    /**
     * 新增外卖安全常识
     */
    @PreAuthorize("@ss.hasPermi('safety:takeaway:add')")
    @Log(title = "外卖安全常识", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SafetyFoodTakeaway safetyFoodTakeaway)
    {
        return toAjax(safetyFoodTakeawayService.insertSafetyFoodTakeaway(safetyFoodTakeaway));
    }

    /**
     * 修改外卖安全常识
     */
    @PreAuthorize("@ss.hasPermi('safety:takeaway:edit')")
    @Log(title = "外卖安全常识", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SafetyFoodTakeaway safetyFoodTakeaway)
    {
        return toAjax(safetyFoodTakeawayService.updateSafetyFoodTakeaway(safetyFoodTakeaway));
    }

    /**
     * 删除外卖安全常识
     */
    @PreAuthorize("@ss.hasPermi('safety:takeaway:remove')")
    @Log(title = "外卖安全常识", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(safetyFoodTakeawayService.deleteSafetyFoodTakeawayByIds(ids));
    }
}
