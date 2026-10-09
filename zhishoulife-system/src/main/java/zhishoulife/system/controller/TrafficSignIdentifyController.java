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
import zhishoulife.system.domain.TrafficSignIdentify;
import zhishoulife.system.service.ITrafficSignIdentifyService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 交通标志识别Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/traffic/sign")
public class TrafficSignIdentifyController extends BaseController
{
    @Autowired
    private ITrafficSignIdentifyService trafficSignIdentifyService;

    /**
     * 查询交通标志识别列表
     */
    @PreAuthorize("@ss.hasPermi('traffic:sign:list')")
    @GetMapping("/list")
    public TableDataInfo list(TrafficSignIdentify trafficSignIdentify)
    {
        startPage();
        List<TrafficSignIdentify> list = trafficSignIdentifyService.selectTrafficSignIdentifyList(trafficSignIdentify);
        return getDataTable(list);
    }

    /**
     * 导出交通标志识别列表
     */
    @PreAuthorize("@ss.hasPermi('traffic:sign:export')")
    @Log(title = "交通标志识别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TrafficSignIdentify trafficSignIdentify)
    {
        List<TrafficSignIdentify> list = trafficSignIdentifyService.selectTrafficSignIdentifyList(trafficSignIdentify);
        ExcelUtil<TrafficSignIdentify> util = new ExcelUtil<TrafficSignIdentify>(TrafficSignIdentify.class);
        util.exportExcel(response, list, "交通标志识别数据");
    }

    /**
     * 获取交通标志识别详细信息
     */
    @PreAuthorize("@ss.hasPermi('traffic:sign:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(trafficSignIdentifyService.selectTrafficSignIdentifyById(id));
    }

    /**
     * 新增交通标志识别
     */
    @PreAuthorize("@ss.hasPermi('traffic:sign:add')")
    @Log(title = "交通标志识别", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TrafficSignIdentify trafficSignIdentify)
    {
        return toAjax(trafficSignIdentifyService.insertTrafficSignIdentify(trafficSignIdentify));
    }

    /**
     * 修改交通标志识别
     */
    @PreAuthorize("@ss.hasPermi('traffic:sign:edit')")
    @Log(title = "交通标志识别", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TrafficSignIdentify trafficSignIdentify)
    {
        return toAjax(trafficSignIdentifyService.updateTrafficSignIdentify(trafficSignIdentify));
    }

    /**
     * 删除交通标志识别
     */
    @PreAuthorize("@ss.hasPermi('traffic:sign:remove')")
    @Log(title = "交通标志识别", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(trafficSignIdentifyService.deleteTrafficSignIdentifyByIds(ids));
    }
}
