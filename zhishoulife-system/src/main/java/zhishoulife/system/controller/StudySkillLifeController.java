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
import zhishoulife.system.domain.StudySkillLife;
import zhishoulife.system.service.IStudySkillLifeService;
import zhishoulife.common.utils.poi.ExcelUtil;
import zhishoulife.common.core.page.TableDataInfo;

/**
 * 生活实用技能Controller
 * 
 * @author admin
 * @date 2026-03-28
 */
@RestController
@RequestMapping("/study/lifee")
public class StudySkillLifeController extends BaseController
{
    @Autowired
    private IStudySkillLifeService studySkillLifeService;

    /**
     * 查询生活实用技能列表
     */
    @PreAuthorize("@ss.hasPermi('study:lifee:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudySkillLife studySkillLife)
    {
        startPage();
        List<StudySkillLife> list = studySkillLifeService.selectStudySkillLifeList(studySkillLife);
        return getDataTable(list);
    }

    /**
     * 导出生活实用技能列表
     */
    @PreAuthorize("@ss.hasPermi('study:lifee:export')")
    @Log(title = "生活实用技能", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StudySkillLife studySkillLife)
    {
        List<StudySkillLife> list = studySkillLifeService.selectStudySkillLifeList(studySkillLife);
        ExcelUtil<StudySkillLife> util = new ExcelUtil<StudySkillLife>(StudySkillLife.class);
        util.exportExcel(response, list, "生活实用技能数据");
    }

    /**
     * 获取生活实用技能详细信息
     */
    @PreAuthorize("@ss.hasPermi('study:lifee:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(studySkillLifeService.selectStudySkillLifeById(id));
    }

    /**
     * 新增生活实用技能
     */
    @PreAuthorize("@ss.hasPermi('study:lifee:add')")
    @Log(title = "生活实用技能", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudySkillLife studySkillLife)
    {
        return toAjax(studySkillLifeService.insertStudySkillLife(studySkillLife));
    }

    /**
     * 修改生活实用技能
     */
    @PreAuthorize("@ss.hasPermi('study:lifee:edit')")
    @Log(title = "生活实用技能", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudySkillLife studySkillLife)
    {
        return toAjax(studySkillLifeService.updateStudySkillLife(studySkillLife));
    }

    /**
     * 删除生活实用技能
     */
    @PreAuthorize("@ss.hasPermi('study:lifee:remove')")
    @Log(title = "生活实用技能", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(studySkillLifeService.deleteStudySkillLifeByIds(ids));
    }
}
