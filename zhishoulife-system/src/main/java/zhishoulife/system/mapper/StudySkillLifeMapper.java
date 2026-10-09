package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.StudySkillLife;

/**
 * 生活实用技能Mapper接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface StudySkillLifeMapper 
{
    /**
     * 查询生活实用技能
     * 
     * @param id 生活实用技能主键
     * @return 生活实用技能
     */
    public StudySkillLife selectStudySkillLifeById(Long id);

    /**
     * 查询生活实用技能列表
     * 
     * @param studySkillLife 生活实用技能
     * @return 生活实用技能集合
     */
    public List<StudySkillLife> selectStudySkillLifeList(StudySkillLife studySkillLife);

    /**
     * 新增生活实用技能
     * 
     * @param studySkillLife 生活实用技能
     * @return 结果
     */
    public int insertStudySkillLife(StudySkillLife studySkillLife);

    /**
     * 修改生活实用技能
     * 
     * @param studySkillLife 生活实用技能
     * @return 结果
     */
    public int updateStudySkillLife(StudySkillLife studySkillLife);

    /**
     * 删除生活实用技能
     * 
     * @param id 生活实用技能主键
     * @return 结果
     */
    public int deleteStudySkillLifeById(Long id);

    /**
     * 批量删除生活实用技能
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudySkillLifeByIds(Long[] ids);
}
