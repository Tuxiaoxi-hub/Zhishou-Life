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
import zhishoulife.system.domain.StudyCertificateProfession;
import zhishoulife.system.service.IStudyCertificateProfessionService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 职业资格证书Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/study/profession")
public class StudyCertificateProfessionController extends BaseController
{
    @Autowired
    private IStudyCertificateProfessionService studyCertificateProfessionService;

    /**
     * 查询职业资格证书列表
     */
    @PreAuthorize("@ss.hasPermi('study:profession:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudyCertificateProfession studyCertificateProfession)
    {
        startPage();
        List<StudyCertificateProfession> list = studyCertificateProfessionService.selectStudyCertificateProfessionList(studyCertificateProfession);
        return getDataTable(list);
    }

    /**
     * 导出职业资格证书列表
     */
    @PreAuthorize("@ss.hasPermi('study:profession:export')")
    @Log(title = "职业资格证书", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudyCertificateProfession studyCertificateProfession)
    {
        List<StudyCertificateProfession> list = studyCertificateProfessionService.selectStudyCertificateProfessionList(studyCertificateProfession);
        ExcelUtil<StudyCertificateProfession> util = new ExcelUtil<StudyCertificateProfession>(StudyCertificateProfession.class);
        util.exportExcel(response, list, "职业资格证书数据");
    }

    /**
     * 获取职业资格证书详细信息
     */
    @PreAuthorize("@ss.hasPermi('study:profession:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(studyCertificateProfessionService.selectStudyCertificateProfessionById(id));
    }

    /**
     * 新增职业资格证书
     */
    @PreAuthorize("@ss.hasPermi('study:profession:add')")
    @Log(title = "职业资格证书", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudyCertificateProfession studyCertificateProfession)
    {
        return toAjax(studyCertificateProfessionService.insertStudyCertificateProfession(studyCertificateProfession));
    }

    /**
     * 修改职业资格证书
     */
    @PreAuthorize("@ss.hasPermi('study:profession:edit')")
    @Log(title = "职业资格证书", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudyCertificateProfession studyCertificateProfession)
    {
        return toAjax(studyCertificateProfessionService.updateStudyCertificateProfession(studyCertificateProfession));
    }

    /**
     * 删除职业资格证书
     */
    @PreAuthorize("@ss.hasPermi('study:profession:remove')")
    @Log(title = "职业资格证书", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(studyCertificateProfessionService.deleteStudyCertificateProfessionByIds(ids));
    }
}
