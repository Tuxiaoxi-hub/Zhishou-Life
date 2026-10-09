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
import zhishoulife.system.domain.StudyCertificateLanguage;
import zhishoulife.system.service.IStudyCertificateLanguageService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 语言类证书Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/study/language")
public class StudyCertificateLanguageController extends BaseController
{
    @Autowired
    private IStudyCertificateLanguageService studyCertificateLanguageService;

    /**
     * 查询语言类证书列表
     */
    @PreAuthorize("@ss.hasPermi('study:language:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudyCertificateLanguage studyCertificateLanguage)
    {
        startPage();
        List<StudyCertificateLanguage> list = studyCertificateLanguageService.selectStudyCertificateLanguageList(studyCertificateLanguage);
        return getDataTable(list);
    }

    /**
     * 导出语言类证书列表
     */
    @PreAuthorize("@ss.hasPermi('study:language:export')")
    @Log(title = "语言类证书", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudyCertificateLanguage studyCertificateLanguage)
    {
        List<StudyCertificateLanguage> list = studyCertificateLanguageService.selectStudyCertificateLanguageList(studyCertificateLanguage);
        ExcelUtil<StudyCertificateLanguage> util = new ExcelUtil<StudyCertificateLanguage>(StudyCertificateLanguage.class);
        util.exportExcel(response, list, "语言类证书数据");
    }

    /**
     * 获取语言类证书详细信息
     */
    @PreAuthorize("@ss.hasPermi('study:language:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(studyCertificateLanguageService.selectStudyCertificateLanguageById(id));
    }

    /**
     * 新增语言类证书
     */
    @PreAuthorize("@ss.hasPermi('study:language:add')")
    @Log(title = "语言类证书", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudyCertificateLanguage studyCertificateLanguage)
    {
        return toAjax(studyCertificateLanguageService.insertStudyCertificateLanguage(studyCertificateLanguage));
    }

    /**
     * 修改语言类证书
     */
    @PreAuthorize("@ss.hasPermi('study:language:edit')")
    @Log(title = "语言类证书", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudyCertificateLanguage studyCertificateLanguage)
    {
        return toAjax(studyCertificateLanguageService.updateStudyCertificateLanguage(studyCertificateLanguage));
    }

    /**
     * 删除语言类证书
     */
    @PreAuthorize("@ss.hasPermi('study:language:remove')")
    @Log(title = "语言类证书", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(studyCertificateLanguageService.deleteStudyCertificateLanguageByIds(ids));
    }
}
