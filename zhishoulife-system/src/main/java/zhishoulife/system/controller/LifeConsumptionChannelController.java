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
import zhishoulife.system.domain.LifeConsumptionChannel;
import zhishoulife.system.service.ILifeConsumptionChannelService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 消费维权渠道Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/life/channel")
public class LifeConsumptionChannelController extends BaseController
{
    @Autowired
    private ILifeConsumptionChannelService lifeConsumptionChannelService;

    /**
     * 查询消费维权渠道列表
     */
    @PreAuthorize("@ss.hasPermi('life:channel:list')")
    @GetMapping("/list")
    public TableDataInfo list(LifeConsumptionChannel lifeConsumptionChannel)
    {
        startPage();
        List<LifeConsumptionChannel> list = lifeConsumptionChannelService.selectLifeConsumptionChannelList(lifeConsumptionChannel);
        return getDataTable(list);
    }

    /**
     * 导出消费维权渠道列表
     */
    @PreAuthorize("@ss.hasPermi('life:channel:export')")
    @Log(title = "消费维权渠道", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LifeConsumptionChannel lifeConsumptionChannel)
    {
        List<LifeConsumptionChannel> list = lifeConsumptionChannelService.selectLifeConsumptionChannelList(lifeConsumptionChannel);
        ExcelUtil<LifeConsumptionChannel> util = new ExcelUtil<LifeConsumptionChannel>(LifeConsumptionChannel.class);
        util.exportExcel(response, list, "消费维权渠道数据");
    }

    /**
     * 获取消费维权渠道详细信息
     */
    @PreAuthorize("@ss.hasPermi('life:channel:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(lifeConsumptionChannelService.selectLifeConsumptionChannelById(id));
    }

    /**
     * 新增消费维权渠道
     */
    @PreAuthorize("@ss.hasPermi('life:channel:add')")
    @Log(title = "消费维权渠道", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LifeConsumptionChannel lifeConsumptionChannel)
    {
        return toAjax(lifeConsumptionChannelService.insertLifeConsumptionChannel(lifeConsumptionChannel));
    }

    /**
     * 修改消费维权渠道
     */
    @PreAuthorize("@ss.hasPermi('life:channel:edit')")
    @Log(title = "消费维权渠道", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LifeConsumptionChannel lifeConsumptionChannel)
    {
        return toAjax(lifeConsumptionChannelService.updateLifeConsumptionChannel(lifeConsumptionChannel));
    }

    /**
     * 删除消费维权渠道
     */
    @PreAuthorize("@ss.hasPermi('life:channel:remove')")
    @Log(title = "消费维权渠道", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lifeConsumptionChannelService.deleteLifeConsumptionChannelByIds(ids));
    }
}
