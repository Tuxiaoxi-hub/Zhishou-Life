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
import zhishoulife.system.domain.LifeClothesStorage;
import zhishoulife.system.service.ILifeClothesStorageService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 衣物收纳整理Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/life/storageee")
public class LifeClothesStorageController extends BaseController
{
    @Autowired
    private ILifeClothesStorageService lifeClothesStorageService;

    /**
     * 查询衣物收纳整理列表
     */
    @PreAuthorize("@ss.hasPermi('life:storageee:list')")
    @GetMapping("/list")
    public TableDataInfo list(LifeClothesStorage lifeClothesStorage)
    {
        startPage();
        List<LifeClothesStorage> list = lifeClothesStorageService.selectLifeClothesStorageList(lifeClothesStorage);
        return getDataTable(list);
    }

    /**
     * 导出衣物收纳整理列表
     */
    @PreAuthorize("@ss.hasPermi('life:storageee:export')")
    @Log(title = "衣物收纳整理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LifeClothesStorage lifeClothesStorage)
    {
        List<LifeClothesStorage> list = lifeClothesStorageService.selectLifeClothesStorageList(lifeClothesStorage);
        ExcelUtil<LifeClothesStorage> util = new ExcelUtil<LifeClothesStorage>(LifeClothesStorage.class);
        util.exportExcel(response, list, "衣物收纳整理数据");
    }

    /**
     * 获取衣物收纳整理详细信息
     */
    @PreAuthorize("@ss.hasPermi('life:storageee:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(lifeClothesStorageService.selectLifeClothesStorageById(id));
    }

    /**
     * 新增衣物收纳整理
     */
    @PreAuthorize("@ss.hasPermi('life:storageee:add')")
    @Log(title = "衣物收纳整理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LifeClothesStorage lifeClothesStorage)
    {
        return toAjax(lifeClothesStorageService.insertLifeClothesStorage(lifeClothesStorage));
    }

    /**
     * 修改衣物收纳整理
     */
    @PreAuthorize("@ss.hasPermi('life:storageee:edit')")
    @Log(title = "衣物收纳整理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LifeClothesStorage lifeClothesStorage)
    {
        return toAjax(lifeClothesStorageService.updateLifeClothesStorage(lifeClothesStorage));
    }

    /**
     * 删除衣物收纳整理
     */
    @PreAuthorize("@ss.hasPermi('life:storageee:remove')")
    @Log(title = "衣物收纳整理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lifeClothesStorageService.deleteLifeClothesStorageByIds(ids));
    }
}
