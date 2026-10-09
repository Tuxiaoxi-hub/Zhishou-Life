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
import zhishoulife.system.domain.StudySkillOffice;
import zhishoulife.system.service.IStudySkillOfficeService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 办公软件技能Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/study/office")
public class StudySkillOfficeController extends BaseController
{
    @Autowired
    private IStudySkillOfficeService studySkillOfficeService;

    /**
     * 查询办公软件技能列表
     */
    @PreAuthorize("@ss.hasPermi('study:office:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudySkillOffice studySkillOffice)
    {
        startPage();
        List<StudySkillOffice> list = studySkillOfficeService.selectStudySkillOfficeList(studySkillOffice);
        return getDataTable(list);
    }

    /**
     * 导出办公软件技能列表
     */
    @PreAuthorize("@ss.hasPermi('study:office:export')")
    @Log(title = "办公软件技能", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudySkillOffice studySkillOffice)
    {
        List<StudySkillOffice> list = studySkillOfficeService.selectStudySkillOfficeList(studySkillOffice);
        ExcelUtil<StudySkillOffice> util = new ExcelUtil<StudySkillOffice>(StudySkillOffice.class);
        util.exportExcel(response, list, "办公软件技能数据");
    }

    /**
     * 获取办公软件技能详细信息
     */
    @PreAuthorize("@ss.hasPermi('study:office:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(studySkillOfficeService.selectStudySkillOfficeById(id));
    }

    /**
     * 新增办公软件技能
     */
    @PreAuthorize("@ss.hasPermi('study:office:add')")
    @Log(title = "办公软件技能", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudySkillOffice studySkillOffice)
    {
        return toAjax(studySkillOfficeService.insertStudySkillOffice(studySkillOffice));
    }

    /**
     * 修改办公软件技能
     */
    @PreAuthorize("@ss.hasPermi('study:office:edit')")
    @Log(title = "办公软件技能", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudySkillOffice studySkillOffice)
    {
        return toAjax(studySkillOfficeService.updateStudySkillOffice(studySkillOffice));
    }

    /**
     * 删除办公软件技能
     */
    @PreAuthorize("@ss.hasPermi('study:office:remove')")
    @Log(title = "办公软件技能", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(studySkillOfficeService.deleteStudySkillOfficeByIds(ids));
    }
}
