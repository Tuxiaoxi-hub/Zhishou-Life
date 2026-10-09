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
import zhishoulife.system.domain.HomeApplianceMaintain;
import zhishoulife.system.service.IHomeApplianceMaintainService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 家电保养维护Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/home/maintain")
public class HomeApplianceMaintainController extends BaseController
{
    @Autowired
    private IHomeApplianceMaintainService homeApplianceMaintainService;

    /**
     * 查询家电保养维护列表
     */
    @PreAuthorize("@ss.hasPermi('home:maintain:list')")
    @GetMapping("/list")
    public TableDataInfo list(HomeApplianceMaintain homeApplianceMaintain)
    {
        startPage();
        List<HomeApplianceMaintain> list = homeApplianceMaintainService.selectHomeApplianceMaintainList(homeApplianceMaintain);
        return getDataTable(list);
    }

    /**
     * 导出家电保养维护列表
     */
    @PreAuthorize("@ss.hasPermi('home:maintain:export')")
    @Log(title = "家电保养维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HomeApplianceMaintain homeApplianceMaintain)
    {
        List<HomeApplianceMaintain> list = homeApplianceMaintainService.selectHomeApplianceMaintainList(homeApplianceMaintain);
        ExcelUtil<HomeApplianceMaintain> util = new ExcelUtil<HomeApplianceMaintain>(HomeApplianceMaintain.class);
        util.exportExcel(response, list, "家电保养维护数据");
    }

    /**
     * 获取家电保养维护详细信息
     */
    @PreAuthorize("@ss.hasPermi('home:maintain:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(homeApplianceMaintainService.selectHomeApplianceMaintainById(id));
    }

    /**
     * 新增家电保养维护
     */
    @PreAuthorize("@ss.hasPermi('home:maintain:add')")
    @Log(title = "家电保养维护", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HomeApplianceMaintain homeApplianceMaintain)
    {
        return toAjax(homeApplianceMaintainService.insertHomeApplianceMaintain(homeApplianceMaintain));
    }

    /**
     * 修改家电保养维护
     */
    @PreAuthorize("@ss.hasPermi('home:maintain:edit')")
    @Log(title = "家电保养维护", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HomeApplianceMaintain homeApplianceMaintain)
    {
        return toAjax(homeApplianceMaintainService.updateHomeApplianceMaintain(homeApplianceMaintain));
    }

    /**
     * 删除家电保养维护
     */
    @PreAuthorize("@ss.hasPermi('home:maintain:remove')")
    @Log(title = "家电保养维护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(homeApplianceMaintainService.deleteHomeApplianceMaintainByIds(ids));
    }
}
