package zhishoulife.system.service;

import java.util.List;
import zhishoulife.system.domain.StudyCertificateLanguage;

/**
 * 语言类证书Service接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface IStudyCertificateLanguageService 
{
    /**
     * 查询语言类证书
     * 
     * @param id 语言类证书主键
     * @return 语言类证书
     */
    public StudyCertificateLanguage selectStudyCertificateLanguageById(Long id);

    /**
     * 查询语言类证书列表
     * 
     * @param studyCertificateLanguage 语言类证书
     * @return 语言类证书集合
     */
    public List<StudyCertificateLanguage> selectStudyCertificateLanguageList(StudyCertificateLanguage studyCertificateLanguage);

    /**
     * 新增语言类证书
     * 
     * @param studyCertificateLanguage 语言类证书
     * @return 结果
     */
    public int insertStudyCertificateLanguage(StudyCertificateLanguage studyCertificateLanguage);

    /**
     * 修改语言类证书
     * 
     * @param studyCertificateLanguage 语言类证书
     * @return 结果
     */
    public int updateStudyCertificateLanguage(StudyCertificateLanguage studyCertificateLanguage);

    /**
     * 批量删除语言类证书
     * 
     * @param ids 需要删除的语言类证书主键集合
     * @return 结果
     */
    public int deleteStudyCertificateLanguageByIds(Long[] ids);

    /**
     * 删除语言类证书信息
     * 
     * @param id 语言类证书主键
     * @return 结果
     */
    public int deleteStudyCertificateLanguageById(Long id);
}
