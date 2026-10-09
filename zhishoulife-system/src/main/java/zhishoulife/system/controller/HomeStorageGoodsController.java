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
import zhishoulife.system.domain.HomeStorageGoods;
import zhishoulife.system.service.IHomeStorageGoodsService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 物品收纳整理Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/home/goods")
public class HomeStorageGoodsController extends BaseController
{
    @Autowired
    private IHomeStorageGoodsService homeStorageGoodsService;

    /**
     * 查询物品收纳整理列表
     */
    @PreAuthorize("@ss.hasPermi('home:goods:list')")
    @GetMapping("/list")
    public TableDataInfo list(HomeStorageGoods homeStorageGoods)
    {
        startPage();
        List<HomeStorageGoods> list = homeStorageGoodsService.selectHomeStorageGoodsList(homeStorageGoods);
        return getDataTable(list);
    }

    /**
     * 导出物品收纳整理列表
     */
    @PreAuthorize("@ss.hasPermi('home:goods:export')")
    @Log(title = "物品收纳整理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HomeStorageGoods homeStorageGoods)
    {
        List<HomeStorageGoods> list = homeStorageGoodsService.selectHomeStorageGoodsList(homeStorageGoods);
        ExcelUtil<HomeStorageGoods> util = new ExcelUtil<HomeStorageGoods>(HomeStorageGoods.class);
        util.exportExcel(response, list, "物品收纳整理数据");
    }

    /**
     * 获取物品收纳整理详细信息
     */
    @PreAuthorize("@ss.hasPermi('home:goods:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(homeStorageGoodsService.selectHomeStorageGoodsById(id));
    }

    /**
     * 新增物品收纳整理
     */
    @PreAuthorize("@ss.hasPermi('home:goods:add')")
    @Log(title = "物品收纳整理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HomeStorageGoods homeStorageGoods)
    {
        return toAjax(homeStorageGoodsService.insertHomeStorageGoods(homeStorageGoods));
    }

    /**
     * 修改物品收纳整理
     */
    @PreAuthorize("@ss.hasPermi('home:goods:edit')")
    @Log(title = "物品收纳整理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HomeStorageGoods homeStorageGoods)
    {
        return toAjax(homeStorageGoodsService.updateHomeStorageGoods(homeStorageGoods));
    }

    /**
     * 删除物品收纳整理
     */
    @PreAuthorize("@ss.hasPermi('home:goods:remove')")
    @Log(title = "物品收纳整理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(homeStorageGoodsService.deleteHomeStorageGoodsByIds(ids));
    }
}
