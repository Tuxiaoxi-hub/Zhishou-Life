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
import zhishoulife.system.domain.SafetyNetworkAccount;
import zhishoulife.system.service.ISafetyNetworkAccountService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 账号安全防护Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/safety/account")
public class SafetyNetworkAccountController extends BaseController
{
    @Autowired
    private ISafetyNetworkAccountService safetyNetworkAccountService;

    /**
     * 查询账号安全防护列表
     */
    @PreAuthorize("@ss.hasPermi('safety:account:list')")
    @GetMapping("/list")
    public TableDataInfo list(SafetyNetworkAccount safetyNetworkAccount)
    {
        startPage();
        List<SafetyNetworkAccount> list = safetyNetworkAccountService.selectSafetyNetworkAccountList(safetyNetworkAccount);
        return getDataTable(list);
    }

    /**
     * 导出账号安全防护列表
     */
    @PreAuthorize("@ss.hasPermi('safety:account:export')")
    @Log(title = "账号安全防护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SafetyNetworkAccount safetyNetworkAccount)
    {
        List<SafetyNetworkAccount> list = safetyNetworkAccountService.selectSafetyNetworkAccountList(safetyNetworkAccount);
        ExcelUtil<SafetyNetworkAccount> util = new ExcelUtil<SafetyNetworkAccount>(SafetyNetworkAccount.class);
        util.exportExcel(response, list, "账号安全防护数据");
    }

    /**
     * 获取账号安全防护详细信息
     */
    @PreAuthorize("@ss.hasPermi('safety:account:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(safetyNetworkAccountService.selectSafetyNetworkAccountById(id));
    }

    /**
     * 新增账号安全防护
     */
    @PreAuthorize("@ss.hasPermi('safety:account:add')")
    @Log(title = "账号安全防护", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SafetyNetworkAccount safetyNetworkAccount)
    {
        return toAjax(safetyNetworkAccountService.insertSafetyNetworkAccount(safetyNetworkAccount));
    }

    /**
     * 修改账号安全防护
     */
    @PreAuthorize("@ss.hasPermi('safety:account:edit')")
    @Log(title = "账号安全防护", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SafetyNetworkAccount safetyNetworkAccount)
    {
        return toAjax(safetyNetworkAccountService.updateSafetyNetworkAccount(safetyNetworkAccount));
    }

    /**
     * 删除账号安全防护
     */
    @PreAuthorize("@ss.hasPermi('safety:account:remove')")
    @Log(title = "账号安全防护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(safetyNetworkAccountService.deleteSafetyNetworkAccountByIds(ids));
    }
}
