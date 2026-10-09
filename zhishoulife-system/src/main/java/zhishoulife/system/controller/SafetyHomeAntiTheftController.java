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
import zhishoulife.system.domain.SafetyHomeAntiTheft;
import zhishoulife.system.service.ISafetyHomeAntiTheftService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 防盗防入侵Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/safety/theft")
public class SafetyHomeAntiTheftController extends BaseController
{
    @Autowired
    private ISafetyHomeAntiTheftService safetyHomeAntiTheftService;

    /**
     * 查询防盗防入侵列表
     */
    @PreAuthorize("@ss.hasPermi('safety:theft:list')")
    @GetMapping("/list")
    public TableDataInfo list(SafetyHomeAntiTheft safetyHomeAntiTheft)
    {
        startPage();
        List<SafetyHomeAntiTheft> list = safetyHomeAntiTheftService.selectSafetyHomeAntiTheftList(safetyHomeAntiTheft);
        return getDataTable(list);
    }

    /**
     * 导出防盗防入侵列表
     */
    @PreAuthorize("@ss.hasPermi('safety:theft:export')")
    @Log(title = "防盗防入侵", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SafetyHomeAntiTheft safetyHomeAntiTheft)
    {
        List<SafetyHomeAntiTheft> list = safetyHomeAntiTheftService.selectSafetyHomeAntiTheftList(safetyHomeAntiTheft);
        ExcelUtil<SafetyHomeAntiTheft> util = new ExcelUtil<SafetyHomeAntiTheft>(SafetyHomeAntiTheft.class);
        util.exportExcel(response, list, "防盗防入侵数据");
    }

    /**
     * 获取防盗防入侵详细信息
     */
    @PreAuthorize("@ss.hasPermi('safety:theft:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(safetyHomeAntiTheftService.selectSafetyHomeAntiTheftById(id));
    }

    /**
     * 新增防盗防入侵
     */
    @PreAuthorize("@ss.hasPermi('safety:theft:add')")
    @Log(title = "防盗防入侵", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SafetyHomeAntiTheft safetyHomeAntiTheft)
    {
        return toAjax(safetyHomeAntiTheftService.insertSafetyHomeAntiTheft(safetyHomeAntiTheft));
    }

    /**
     * 修改防盗防入侵
     */
    @PreAuthorize("@ss.hasPermi('safety:theft:edit')")
    @Log(title = "防盗防入侵", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SafetyHomeAntiTheft safetyHomeAntiTheft)
    {
        return toAjax(safetyHomeAntiTheftService.updateSafetyHomeAntiTheft(safetyHomeAntiTheft));
    }

    /**
     * 删除防盗防入侵
     */
    @PreAuthorize("@ss.hasPermi('safety:theft:remove')")
    @Log(title = "防盗防入侵", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(safetyHomeAntiTheftService.deleteSafetyHomeAntiTheftByIds(ids));
    }
}
