package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.StudySkillLifeMapper;
import zhishoulife.system.domain.StudySkillLife;
import zhishoulife.system.service.IStudySkillLifeService;

/**
 * 生活实用技能Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class StudySkillLifeServiceImpl implements IStudySkillLifeService 
{
    @Autowired
    private StudySkillLifeMapper studySkillLifeMapper;

    /**
     * 查询生活实用技能
     * 
     * @param id 生活实用技能主键
     * @return 生活实用技能
     */
    @Override
    public StudySkillLife selectStudySkillLifeById(Long id)
    {
        return studySkillLifeMapper.selectStudySkillLifeById(id);
    }

    /**
     * 查询生活实用技能列表
     * 
     * @param studySkillLife 生活实用技能
     * @return 生活实用技能
     */
    @Override
    public List<StudySkillLife> selectStudySkillLifeList(StudySkillLife studySkillLife)
    {
        return studySkillLifeMapper.selectStudySkillLifeList(studySkillLife);
    }

    /**
     * 新增生活实用技能
     * 
     * @param studySkillLife 生活实用技能
     * @return 结果
     */
    @Override
    public int insertStudySkillLife(StudySkillLife studySkillLife)
    {
        studySkillLife.setCreateTime(DateUtils.getNowDate());
        return studySkillLifeMapper.insertStudySkillLife(studySkillLife);
    }

    /**
     * 修改生活实用技能
     * 
     * @param studySkillLife 生活实用技能
     * @return 结果
     */
    @Override
    public int updateStudySkillLife(StudySkillLife studySkillLife)
    {
        return studySkillLifeMapper.updateStudySkillLife(studySkillLife);
    }

    /**
     * 批量删除生活实用技能
     * 
     * @param ids 需要删除的生活实用技能主键
     * @return 结果
     */
    @Override
    public int deleteStudySkillLifeByIds(Long[] ids)
    {
        return studySkillLifeMapper.deleteStudySkillLifeByIds(ids);
    }

    /**
     * 删除生活实用技能信息
     * 
     * @param id 生活实用技能主键
     * @return 结果
     */
    @Override
    public int deleteStudySkillLifeById(Long id)
    {
        return studySkillLifeMapper.deleteStudySkillLifeById(id);
    }
}
