package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.StudyCertificateLanguageMapper;
import zhishoulife.system.domain.StudyCertificateLanguage;
import zhishoulife.system.service.IStudyCertificateLanguageService;

/**
 * 语言类证书Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class StudyCertificateLanguageServiceImpl implements IStudyCertificateLanguageService 
{
    @Autowired
    private StudyCertificateLanguageMapper studyCertificateLanguageMapper;

    /**
     * 查询语言类证书
     * 
     * @param id 语言类证书主键
     * @return 语言类证书
     */
    @Override
    public StudyCertificateLanguage selectStudyCertificateLanguageById(Long id)
    {
        return studyCertificateLanguageMapper.selectStudyCertificateLanguageById(id);
    }

    /**
     * 查询语言类证书列表
     * 
     * @param studyCertificateLanguage 语言类证书
     * @return 语言类证书
     */
    @Override
    public List<StudyCertificateLanguage> selectStudyCertificateLanguageList(StudyCertificateLanguage studyCertificateLanguage)
    {
        return studyCertificateLanguageMapper.selectStudyCertificateLanguageList(studyCertificateLanguage);
    }

    /**
     * 新增语言类证书
     * 
     * @param studyCertificateLanguage 语言类证书
     * @return 结果
     */
    @Override
    public int insertStudyCertificateLanguage(StudyCertificateLanguage studyCertificateLanguage)
    {
        studyCertificateLanguage.setCreateTime(DateUtils.getNowDate());
        return studyCertificateLanguageMapper.insertStudyCertificateLanguage(studyCertificateLanguage);
    }

    /**
     * 修改语言类证书
     * 
     * @param studyCertificateLanguage 语言类证书
     * @return 结果
     */
    @Override
    public int updateStudyCertificateLanguage(StudyCertificateLanguage studyCertificateLanguage)
    {
        return studyCertificateLanguageMapper.updateStudyCertificateLanguage(studyCertificateLanguage);
    }

    /**
     * 批量删除语言类证书
     * 
     * @param ids 需要删除的语言类证书主键
     * @return 结果
     */
    @Override
    public int deleteStudyCertificateLanguageByIds(Long[] ids)
    {
        return studyCertificateLanguageMapper.deleteStudyCertificateLanguageByIds(ids);
    }

    /**
     * 删除语言类证书信息
     * 
     * @param id 语言类证书主键
     * @return 结果
     */
    @Override
    public int deleteStudyCertificateLanguageById(Long id)
    {
        return studyCertificateLanguageMapper.deleteStudyCertificateLanguageById(id);
    }
}
