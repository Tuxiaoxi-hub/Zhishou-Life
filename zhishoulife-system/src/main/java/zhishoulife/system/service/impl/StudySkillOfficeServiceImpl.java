package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.StudySkillOfficeMapper;
import zhishoulife.system.domain.StudySkillOffice;
import zhishoulife.system.service.IStudySkillOfficeService;

/**
 * 办公软件技能Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class StudySkillOfficeServiceImpl implements IStudySkillOfficeService 
{
    @Autowired
    private StudySkillOfficeMapper studySkillOfficeMapper;

    /**
     * 查询办公软件技能
     * 
     * @param id 办公软件技能主键
     * @return 办公软件技能
     */
    @Override
    public StudySkillOffice selectStudySkillOfficeById(Long id)
    {
        return studySkillOfficeMapper.selectStudySkillOfficeById(id);
    }

    /**
     * 查询办公软件技能列表
     * 
     * @param studySkillOffice 办公软件技能
     * @return 办公软件技能
     */
    @Override
    public List<StudySkillOffice> selectStudySkillOfficeList(StudySkillOffice studySkillOffice)
    {
        return studySkillOfficeMapper.selectStudySkillOfficeList(studySkillOffice);
    }

    /**
     * 新增办公软件技能
     * 
     * @param studySkillOffice 办公软件技能
     * @return 结果
     */
    @Override
    public int insertStudySkillOffice(StudySkillOffice studySkillOffice)
    {
        studySkillOffice.setCreateTime(DateUtils.getNowDate());
        return studySkillOfficeMapper.insertStudySkillOffice(studySkillOffice);
    }

    /**
     * 修改办公软件技能
     * 
     * @param studySkillOffice 办公软件技能
     * @return 结果
     */
    @Override
    public int updateStudySkillOffice(StudySkillOffice studySkillOffice)
    {
        return studySkillOfficeMapper.updateStudySkillOffice(studySkillOffice);
    }

    /**
     * 批量删除办公软件技能
     * 
     * @param ids 需要删除的办公软件技能主键
     * @return 结果
     */
    @Override
    public int deleteStudySkillOfficeByIds(Long[] ids)
    {
        return studySkillOfficeMapper.deleteStudySkillOfficeByIds(ids);
    }

    /**
     * 删除办公软件技能信息
     * 
     * @param id 办公软件技能主键
     * @return 结果
     */
    @Override
    public int deleteStudySkillOfficeById(Long id)
    {
        return studySkillOfficeMapper.deleteStudySkillOfficeById(id);
    }
}
