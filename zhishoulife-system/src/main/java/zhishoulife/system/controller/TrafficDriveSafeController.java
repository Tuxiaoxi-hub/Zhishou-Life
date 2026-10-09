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
import zhishoulife.system.domain.TrafficDriveSafe;
import zhishoulife.system.service.ITrafficDriveSafeService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 自驾出行安全Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/traffic/drive")
public class TrafficDriveSafeController extends BaseController
{
    @Autowired
    private ITrafficDriveSafeService trafficDriveSafeService;

    /**
     * 查询自驾出行安全列表
     */
    @PreAuthorize("@ss.hasPermi('traffic:drive:list')")
    @GetMapping("/list")
    public TableDataInfo list(TrafficDriveSafe trafficDriveSafe)
    {
        startPage();
        List<TrafficDriveSafe> list = trafficDriveSafeService.selectTrafficDriveSafeList(trafficDriveSafe);
        return getDataTable(list);
    }

    /**
     * 导出自驾出行安全列表
     */
    @PreAuthorize("@ss.hasPermi('traffic:drive:export')")
    @Log(title = "自驾出行安全", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TrafficDriveSafe trafficDriveSafe)
    {
        List<TrafficDriveSafe> list = trafficDriveSafeService.selectTrafficDriveSafeList(trafficDriveSafe);
        ExcelUtil<TrafficDriveSafe> util = new ExcelUtil<TrafficDriveSafe>(TrafficDriveSafe.class);
        util.exportExcel(response, list, "自驾出行安全数据");
    }

    /**
     * 获取自驾出行安全详细信息
     */
    @PreAuthorize("@ss.hasPermi('traffic:drive:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(trafficDriveSafeService.selectTrafficDriveSafeById(id));
    }

    /**
     * 新增自驾出行安全
     */
    @PreAuthorize("@ss.hasPermi('traffic:drive:add')")
    @Log(title = "自驾出行安全", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TrafficDriveSafe trafficDriveSafe)
    {
        return toAjax(trafficDriveSafeService.insertTrafficDriveSafe(trafficDriveSafe));
    }

    /**
     * 修改自驾出行安全
     */
    @PreAuthorize("@ss.hasPermi('traffic:drive:edit')")
    @Log(title = "自驾出行安全", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TrafficDriveSafe trafficDriveSafe)
    {
        return toAjax(trafficDriveSafeService.updateTrafficDriveSafe(trafficDriveSafe));
    }

    /**
     * 删除自驾出行安全
     */
    @PreAuthorize("@ss.hasPermi('traffic:drive:remove')")
    @Log(title = "自驾出行安全", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(trafficDriveSafeService.deleteTrafficDriveSafeByIds(ids));
    }
}
