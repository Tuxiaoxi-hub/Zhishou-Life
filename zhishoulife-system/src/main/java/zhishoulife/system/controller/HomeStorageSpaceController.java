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
import zhishoulife.system.domain.HomeStorageSpace;
import zhishoulife.system.service.IHomeStorageSpaceService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 空间收纳技巧Controller
 * 
 * @author admin
 * @date 2026-04-13
 */
@RestController
@RequestMapping("/home/space")
public class HomeStorageSpaceController extends BaseController
{
    @Autowired
    private IHomeStorageSpaceService homeStorageSpaceService;

    /**
     * 查询空间收纳技巧列表
     */
    @PreAuthorize("@ss.hasPermi('home:space:list')")
    @GetMapping("/list")
    public TableDataInfo list(HomeStorageSpace homeStorageSpace)
    {
        startPage();
        List<HomeStorageSpace> list = homeStorageSpaceService.selectHomeStorageSpaceList(homeStorageSpace);
        return getDataTable(list);
    }

    /**
     * 导出空间收纳技巧列表
     */
    @PreAuthorize("@ss.hasPermi('home:space:export')")
    @Log(title = "空间收纳技巧", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HomeStorageSpace homeStorageSpace)
    {
        List<HomeStorageSpace> list = homeStorageSpaceService.selectHomeStorageSpaceList(homeStorageSpace);
        ExcelUtil<HomeStorageSpace> util = new ExcelUtil<HomeStorageSpace>(HomeStorageSpace.class);
        util.exportExcel(response, list, "空间收纳技巧数据");
    }

    /**
     * 获取空间收纳技巧详细信息
     */
    @PreAuthorize("@ss.hasPermi('home:space:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(homeStorageSpaceService.selectHomeStorageSpaceById(id));
    }

    /**
     * 新增空间收纳技巧
     */
    @PreAuthorize("@ss.hasPermi('home:space:add')")
    @Log(title = "空间收纳技巧", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HomeStorageSpace homeStorageSpace)
    {
        return toAjax(homeStorageSpaceService.insertHomeStorageSpace(homeStorageSpace));
    }

    /**
     * 修改空间收纳技巧
     */
    @PreAuthorize("@ss.hasPermi('home:space:edit')")
    @Log(title = "空间收纳技巧", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HomeStorageSpace homeStorageSpace)
    {
        return toAjax(homeStorageSpaceService.updateHomeStorageSpace(homeStorageSpace));
    }

    /**
     * 删除空间收纳技巧
     */
    @PreAuthorize("@ss.hasPermi('home:space:remove')")
    @Log(title = "空间收纳技巧", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(homeStorageSpaceService.deleteHomeStorageSpaceByIds(ids));
    }
}
