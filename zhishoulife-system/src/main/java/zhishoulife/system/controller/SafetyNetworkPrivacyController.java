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
import zhishoulife.system.domain.SafetyNetworkPrivacy;
import zhishoulife.system.service.ISafetyNetworkPrivacyService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 个人隐私保护Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/safety/privacy")
public class SafetyNetworkPrivacyController extends BaseController
{
    @Autowired
    private ISafetyNetworkPrivacyService safetyNetworkPrivacyService;

    /**
     * 查询个人隐私保护列表
     */
    @PreAuthorize("@ss.hasPermi('safety:privacy:list')")
    @GetMapping("/list")
    public TableDataInfo list(SafetyNetworkPrivacy safetyNetworkPrivacy)
    {
        startPage();
        List<SafetyNetworkPrivacy> list = safetyNetworkPrivacyService.selectSafetyNetworkPrivacyList(safetyNetworkPrivacy);
        return getDataTable(list);
    }

    /**
     * 导出个人隐私保护列表
     */
    @PreAuthorize("@ss.hasPermi('safety:privacy:export')")
    @Log(title = "个人隐私保护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SafetyNetworkPrivacy safetyNetworkPrivacy)
    {
        List<SafetyNetworkPrivacy> list = safetyNetworkPrivacyService.selectSafetyNetworkPrivacyList(safetyNetworkPrivacy);
        ExcelUtil<SafetyNetworkPrivacy> util = new ExcelUtil<SafetyNetworkPrivacy>(SafetyNetworkPrivacy.class);
        util.exportExcel(response, list, "个人隐私保护数据");
    }

    /**
     * 获取个人隐私保护详细信息
     */
    @PreAuthorize("@ss.hasPermi('safety:privacy:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(safetyNetworkPrivacyService.selectSafetyNetworkPrivacyById(id));
    }

    /**
     * 新增个人隐私保护
     */
    @PreAuthorize("@ss.hasPermi('safety:privacy:add')")
    @Log(title = "个人隐私保护", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SafetyNetworkPrivacy safetyNetworkPrivacy)
    {
        return toAjax(safetyNetworkPrivacyService.insertSafetyNetworkPrivacy(safetyNetworkPrivacy));
    }

    /**
     * 修改个人隐私保护
     */
    @PreAuthorize("@ss.hasPermi('safety:privacy:edit')")
    @Log(title = "个人隐私保护", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SafetyNetworkPrivacy safetyNetworkPrivacy)
    {
        return toAjax(safetyNetworkPrivacyService.updateSafetyNetworkPrivacy(safetyNetworkPrivacy));
    }

    /**
     * 删除个人隐私保护
     */
    @PreAuthorize("@ss.hasPermi('safety:privacy:remove')")
    @Log(title = "个人隐私保护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(safetyNetworkPrivacyService.deleteSafetyNetworkPrivacyByIds(ids));
    }
}
