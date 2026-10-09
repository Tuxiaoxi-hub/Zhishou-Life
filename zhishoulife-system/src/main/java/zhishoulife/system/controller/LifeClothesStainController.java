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
import zhishoulife.system.domain.LifeClothesStain;
import zhishoulife.system.service.ILifeClothesStainService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 污渍去除技巧Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/life/stain")
public class LifeClothesStainController extends BaseController
{
    @Autowired
    private ILifeClothesStainService lifeClothesStainService;

    /**
     * 查询污渍去除技巧列表
     */
    @PreAuthorize("@ss.hasPermi('life:stain:list')")
    @GetMapping("/list")
    public TableDataInfo list(LifeClothesStain lifeClothesStain)
    {
        startPage();
        List<LifeClothesStain> list = lifeClothesStainService.selectLifeClothesStainList(lifeClothesStain);
        return getDataTable(list);
    }

    /**
     * 导出污渍去除技巧列表
     */
    @PreAuthorize("@ss.hasPermi('life:stain:export')")
    @Log(title = "污渍去除技巧", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LifeClothesStain lifeClothesStain)
    {
        List<LifeClothesStain> list = lifeClothesStainService.selectLifeClothesStainList(lifeClothesStain);
        ExcelUtil<LifeClothesStain> util = new ExcelUtil<LifeClothesStain>(LifeClothesStain.class);
        util.exportExcel(response, list, "污渍去除技巧数据");
    }

    /**
     * 获取污渍去除技巧详细信息
     */
    @PreAuthorize("@ss.hasPermi('life:stain:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(lifeClothesStainService.selectLifeClothesStainById(id));
    }

    /**
     * 新增污渍去除技巧
     */
    @PreAuthorize("@ss.hasPermi('life:stain:add')")
    @Log(title = "污渍去除技巧", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LifeClothesStain lifeClothesStain)
    {
        return toAjax(lifeClothesStainService.insertLifeClothesStain(lifeClothesStain));
    }

    /**
     * 修改污渍去除技巧
     */
    @PreAuthorize("@ss.hasPermi('life:stain:edit')")
    @Log(title = "污渍去除技巧", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LifeClothesStain lifeClothesStain)
    {
        return toAjax(lifeClothesStainService.updateLifeClothesStain(lifeClothesStain));
    }

    /**
     * 删除污渍去除技巧
     */
    @PreAuthorize("@ss.hasPermi('life:stain:remove')")
    @Log(title = "污渍去除技巧", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lifeClothesStainService.deleteLifeClothesStainByIds(ids));
    }
}
