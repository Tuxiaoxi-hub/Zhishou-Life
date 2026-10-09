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
import zhishoulife.system.domain.TrafficRuleCommon;
import zhishoulife.system.service.ITrafficRuleCommonService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 交通通行规则Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/taffic/common")
public class TrafficRuleCommonController extends BaseController
{
    @Autowired
    private ITrafficRuleCommonService trafficRuleCommonService;

    /**
     * 查询交通通行规则列表
     */
    @PreAuthorize("@ss.hasPermi('taffic:common:list')")
    @GetMapping("/list")
    public TableDataInfo list(TrafficRuleCommon trafficRuleCommon)
    {
        startPage();
        List<TrafficRuleCommon> list = trafficRuleCommonService.selectTrafficRuleCommonList(trafficRuleCommon);
        return getDataTable(list);
    }

    /**
     * 导出交通通行规则列表
     */
    @PreAuthorize("@ss.hasPermi('taffic:common:export')")
    @Log(title = "交通通行规则", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TrafficRuleCommon trafficRuleCommon)
    {
        List<TrafficRuleCommon> list = trafficRuleCommonService.selectTrafficRuleCommonList(trafficRuleCommon);
        ExcelUtil<TrafficRuleCommon> util = new ExcelUtil<TrafficRuleCommon>(TrafficRuleCommon.class);
        util.exportExcel(response, list, "交通通行规则数据");
    }

    /**
     * 获取交通通行规则详细信息
     */
    @PreAuthorize("@ss.hasPermi('taffic:common:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(trafficRuleCommonService.selectTrafficRuleCommonById(id));
    }

    /**
     * 新增交通通行规则
     */
    @PreAuthorize("@ss.hasPermi('taffic:common:add')")
    @Log(title = "交通通行规则", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TrafficRuleCommon trafficRuleCommon)
    {
        return toAjax(trafficRuleCommonService.insertTrafficRuleCommon(trafficRuleCommon));
    }

    /**
     * 修改交通通行规则
     */
    @PreAuthorize("@ss.hasPermi('taffic:common:edit')")
    @Log(title = "交通通行规则", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TrafficRuleCommon trafficRuleCommon)
    {
        return toAjax(trafficRuleCommonService.updateTrafficRuleCommon(trafficRuleCommon));
    }

    /**
     * 删除交通通行规则
     */
    @PreAuthorize("@ss.hasPermi('taffic:common:remove')")
    @Log(title = "交通通行规则", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(trafficRuleCommonService.deleteTrafficRuleCommonByIds(ids));
    }
}
