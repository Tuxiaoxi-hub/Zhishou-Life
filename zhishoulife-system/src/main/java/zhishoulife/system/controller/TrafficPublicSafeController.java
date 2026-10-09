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
import zhishoulife.system.domain.TrafficPublicSafe;
import zhishoulife.system.service.ITrafficPublicSafeService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 公共出行安全Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/traffic/public")
public class TrafficPublicSafeController extends BaseController
{
    @Autowired
    private ITrafficPublicSafeService trafficPublicSafeService;

    /**
     * 查询公共出行安全列表
     */
    @PreAuthorize("@ss.hasPermi('traffic:public:list')")
    @GetMapping("/list")
    public TableDataInfo list(TrafficPublicSafe trafficPublicSafe)
    {
        startPage();
        List<TrafficPublicSafe> list = trafficPublicSafeService.selectTrafficPublicSafeList(trafficPublicSafe);
        return getDataTable(list);
    }

    /**
     * 导出公共出行安全列表
     */
    @PreAuthorize("@ss.hasPermi('traffic:public:export')")
    @Log(title = "公共出行安全", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TrafficPublicSafe trafficPublicSafe)
    {
        List<TrafficPublicSafe> list = trafficPublicSafeService.selectTrafficPublicSafeList(trafficPublicSafe);
        ExcelUtil<TrafficPublicSafe> util = new ExcelUtil<TrafficPublicSafe>(TrafficPublicSafe.class);
        util.exportExcel(response, list, "公共出行安全数据");
    }

    /**
     * 获取公共出行安全详细信息
     */
    @PreAuthorize("@ss.hasPermi('traffic:public:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(trafficPublicSafeService.selectTrafficPublicSafeById(id));
    }

    /**
     * 新增公共出行安全
     */
    @PreAuthorize("@ss.hasPermi('traffic:public:add')")
    @Log(title = "公共出行安全", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TrafficPublicSafe trafficPublicSafe)
    {
        return toAjax(trafficPublicSafeService.insertTrafficPublicSafe(trafficPublicSafe));
    }

    /**
     * 修改公共出行安全
     */
    @PreAuthorize("@ss.hasPermi('traffic:public:edit')")
    @Log(title = "公共出行安全", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TrafficPublicSafe trafficPublicSafe)
    {
        return toAjax(trafficPublicSafeService.updateTrafficPublicSafe(trafficPublicSafe));
    }

    /**
     * 删除公共出行安全
     */
    @PreAuthorize("@ss.hasPermi('traffic:public:remove')")
    @Log(title = "公共出行安全", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(trafficPublicSafeService.deleteTrafficPublicSafeByIds(ids));
    }
}
