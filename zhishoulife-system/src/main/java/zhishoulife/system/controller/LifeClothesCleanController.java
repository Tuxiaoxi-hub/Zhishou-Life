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
import zhishoulife.system.domain.LifeClothesClean;
import zhishoulife.system.service.ILifeClothesCleanService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 衣物清洗保养Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/life/clean")
public class LifeClothesCleanController extends BaseController
{
    @Autowired
    private ILifeClothesCleanService lifeClothesCleanService;

    /**
     * 查询衣物清洗保养列表
     */
    @PreAuthorize("@ss.hasPermi('life:clean:list')")
    @GetMapping("/list")
    public TableDataInfo list(LifeClothesClean lifeClothesClean)
    {
        startPage();
        List<LifeClothesClean> list = lifeClothesCleanService.selectLifeClothesCleanList(lifeClothesClean);
        return getDataTable(list);
    }

    /**
     * 导出衣物清洗保养列表
     */
    @PreAuthorize("@ss.hasPermi('life:clean:export')")
    @Log(title = "衣物清洗保养", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LifeClothesClean lifeClothesClean)
    {
        List<LifeClothesClean> list = lifeClothesCleanService.selectLifeClothesCleanList(lifeClothesClean);
        ExcelUtil<LifeClothesClean> util = new ExcelUtil<LifeClothesClean>(LifeClothesClean.class);
        util.exportExcel(response, list, "衣物清洗保养数据");
    }

    /**
     * 获取衣物清洗保养详细信息
     */
    @PreAuthorize("@ss.hasPermi('life:clean:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(lifeClothesCleanService.selectLifeClothesCleanById(id));
    }

    /**
     * 新增衣物清洗保养
     */
    @PreAuthorize("@ss.hasPermi('life:clean:add')")
    @Log(title = "衣物清洗保养", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LifeClothesClean lifeClothesClean)
    {
        return toAjax(lifeClothesCleanService.insertLifeClothesClean(lifeClothesClean));
    }

    /**
     * 修改衣物清洗保养
     */
    @PreAuthorize("@ss.hasPermi('life:clean:edit')")
    @Log(title = "衣物清洗保养", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LifeClothesClean lifeClothesClean)
    {
        return toAjax(lifeClothesCleanService.updateLifeClothesClean(lifeClothesClean));
    }

    /**
     * 删除衣物清洗保养
     */
    @PreAuthorize("@ss.hasPermi('life:clean:remove')")
    @Log(title = "衣物清洗保养", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lifeClothesCleanService.deleteLifeClothesCleanByIds(ids));
    }
}
