package zhishoulife.system.service;

import java.util.List;
import zhishoulife.system.domain.StudySkillOffice;

/**
 * 办公软件技能Service接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface IStudySkillOfficeService 
{
    /**
     * 查询办公软件技能
     * 
     * @param id 办公软件技能主键
     * @return 办公软件技能
     */
    public StudySkillOffice selectStudySkillOfficeById(Long id);

    /**
     * 查询办公软件技能列表
     * 
     * @param studySkillOffice 办公软件技能
     * @return 办公软件技能集合
     */
    public List<StudySkillOffice> selectStudySkillOfficeList(StudySkillOffice studySkillOffice);

    /**
     * 新增办公软件技能
     * 
     * @param studySkillOffice 办公软件技能
     * @return 结果
     */
    public int insertStudySkillOffice(StudySkillOffice studySkillOffice);

    /**
     * 修改办公软件技能
     * 
     * @param studySkillOffice 办公软件技能
     * @return 结果
     */
    public int updateStudySkillOffice(StudySkillOffice studySkillOffice);

    /**
     * 批量删除办公软件技能
     * 
     * @param ids 需要删除的办公软件技能主键集合
     * @return 结果
     */
    public int deleteStudySkillOfficeByIds(Long[] ids);

    /**
     * 删除办公软件技能信息
     * 
     * @param id 办公软件技能主键
     * @return 结果
     */
    public int deleteStudySkillOfficeById(Long id);
}
