package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.StudyCertificateProfessionMapper;
import zhishoulife.system.domain.StudyCertificateProfession;
import zhishoulife.system.service.IStudyCertificateProfessionService;

/**
 * 职业资格证书Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class StudyCertificateProfessionServiceImpl implements IStudyCertificateProfessionService 
{
    @Autowired
    private StudyCertificateProfessionMapper studyCertificateProfessionMapper;

    /**
     * 查询职业资格证书
     * 
     * @param id 职业资格证书主键
     * @return 职业资格证书
     */
    @Override
    public StudyCertificateProfession selectStudyCertificateProfessionById(Long id)
    {
        return studyCertificateProfessionMapper.selectStudyCertificateProfessionById(id);
    }

    /**
     * 查询职业资格证书列表
     * 
     * @param studyCertificateProfession 职业资格证书
     * @return 职业资格证书
     */
    @Override
    public List<StudyCertificateProfession> selectStudyCertificateProfessionList(StudyCertificateProfession studyCertificateProfession)
    {
        return studyCertificateProfessionMapper.selectStudyCertificateProfessionList(studyCertificateProfession);
    }

    /**
     * 新增职业资格证书
     * 
     * @param studyCertificateProfession 职业资格证书
     * @return 结果
     */
    @Override
    public int insertStudyCertificateProfession(StudyCertificateProfession studyCertificateProfession)
    {
        studyCertificateProfession.setCreateTime(DateUtils.getNowDate());
        return studyCertificateProfessionMapper.insertStudyCertificateProfession(studyCertificateProfession);
    }

    /**
     * 修改职业资格证书
     * 
     * @param studyCertificateProfession 职业资格证书
     * @return 结果
     */
    @Override
    public int updateStudyCertificateProfession(StudyCertificateProfession studyCertificateProfession)
    {
        return studyCertificateProfessionMapper.updateStudyCertificateProfession(studyCertificateProfession);
    }

    /**
     * 批量删除职业资格证书
     * 
     * @param ids 需要删除的职业资格证书主键
     * @return 结果
     */
    @Override
    public int deleteStudyCertificateProfessionByIds(Long[] ids)
    {
        return studyCertificateProfessionMapper.deleteStudyCertificateProfessionByIds(ids);
    }

    /**
     * 删除职业资格证书信息
     * 
     * @param id 职业资格证书主键
     * @return 结果
     */
    @Override
    public int deleteStudyCertificateProfessionById(Long id)
    {
        return studyCertificateProfessionMapper.deleteStudyCertificateProfessionById(id);
    }
}
