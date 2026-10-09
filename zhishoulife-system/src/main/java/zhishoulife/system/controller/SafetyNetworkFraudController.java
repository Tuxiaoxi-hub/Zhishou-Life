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
import zhishoulife.system.domain.SafetyNetworkFraud;
import zhishoulife.system.service.ISafetyNetworkFraudService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 网络诈骗防范Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/safety/fraud")
public class SafetyNetworkFraudController extends BaseController
{
    @Autowired
    private ISafetyNetworkFraudService safetyNetworkFraudService;

    /**
     * 查询网络诈骗防范列表
     */
    @PreAuthorize("@ss.hasPermi('safety:fraud:list')")
    @GetMapping("/list")
    public TableDataInfo list(SafetyNetworkFraud safetyNetworkFraud)
    {
        startPage();
        List<SafetyNetworkFraud> list = safetyNetworkFraudService.selectSafetyNetworkFraudList(safetyNetworkFraud);
        return getDataTable(list);
    }

    /**
     * 导出网络诈骗防范列表
     */
    @PreAuthorize("@ss.hasPermi('safety:fraud:export')")
    @Log(title = "网络诈骗防范", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SafetyNetworkFraud safetyNetworkFraud)
    {
        List<SafetyNetworkFraud> list = safetyNetworkFraudService.selectSafetyNetworkFraudList(safetyNetworkFraud);
        ExcelUtil<SafetyNetworkFraud> util = new ExcelUtil<SafetyNetworkFraud>(SafetyNetworkFraud.class);
        util.exportExcel(response, list, "网络诈骗防范数据");
    }

    /**
     * 获取网络诈骗防范详细信息
     */
    @PreAuthorize("@ss.hasPermi('safety:fraud:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(safetyNetworkFraudService.selectSafetyNetworkFraudById(id));
    }

    /**
     * 新增网络诈骗防范
     */
    @PreAuthorize("@ss.hasPermi('safety:fraud:add')")
    @Log(title = "网络诈骗防范", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SafetyNetworkFraud safetyNetworkFraud)
    {
        return toAjax(safetyNetworkFraudService.insertSafetyNetworkFraud(safetyNetworkFraud));
    }

    /**
     * 修改网络诈骗防范
     */
    @PreAuthorize("@ss.hasPermi('safety:fraud:edit')")
    @Log(title = "网络诈骗防范", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SafetyNetworkFraud safetyNetworkFraud)
    {
        return toAjax(safetyNetworkFraudService.updateSafetyNetworkFraud(safetyNetworkFraud));
    }

    /**
     * 删除网络诈骗防范
     */
    @PreAuthorize("@ss.hasPermi('safety:fraud:remove')")
    @Log(title = "网络诈骗防范", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(safetyNetworkFraudService.deleteSafetyNetworkFraudByIds(ids));
    }
}
