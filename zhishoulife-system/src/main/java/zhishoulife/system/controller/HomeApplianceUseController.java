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
import zhishoulife.system.domain.HomeApplianceUse;
import zhishoulife.system.service.IHomeApplianceUseService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 家电操作技巧Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/home/use")
public class HomeApplianceUseController extends BaseController
{
    @Autowired
    private IHomeApplianceUseService homeApplianceUseService;

    /**
     * 查询家电操作技巧列表
     */
    @PreAuthorize("@ss.hasPermi('home:use:list')")
    @GetMapping("/list")
    public TableDataInfo list(HomeApplianceUse homeApplianceUse)
    {
        startPage();
        List<HomeApplianceUse> list = homeApplianceUseService.selectHomeApplianceUseList(homeApplianceUse);
        return getDataTable(list);
    }

    /**
     * 导出家电操作技巧列表
     */
    @PreAuthorize("@ss.hasPermi('home:use:export')")
    @Log(title = "家电操作技巧", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HomeApplianceUse homeApplianceUse)
    {
        List<HomeApplianceUse> list = homeApplianceUseService.selectHomeApplianceUseList(homeApplianceUse);
        ExcelUtil<HomeApplianceUse> util = new ExcelUtil<HomeApplianceUse>(HomeApplianceUse.class);
        util.exportExcel(response, list, "家电操作技巧数据");
    }

    /**
     * 获取家电操作技巧详细信息
     */
    @PreAuthorize("@ss.hasPermi('home:use:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(homeApplianceUseService.selectHomeApplianceUseById(id));
    }

    /**
     * 新增家电操作技巧
     */
    @PreAuthorize("@ss.hasPermi('home:use:add')")
    @Log(title = "家电操作技巧", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HomeApplianceUse homeApplianceUse)
    {
        return toAjax(homeApplianceUseService.insertHomeApplianceUse(homeApplianceUse));
    }

    /**
     * 修改家电操作技巧
     */
    @PreAuthorize("@ss.hasPermi('home:use:edit')")
    @Log(title = "家电操作技巧", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HomeApplianceUse homeApplianceUse)
    {
        return toAjax(homeApplianceUseService.updateHomeApplianceUse(homeApplianceUse));
    }

    /**
     * 删除家电操作技巧
     */
    @PreAuthorize("@ss.hasPermi('home:use:remove')")
    @Log(title = "家电操作技巧", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(homeApplianceUseService.deleteHomeApplianceUseByIds(ids));
    }
}
