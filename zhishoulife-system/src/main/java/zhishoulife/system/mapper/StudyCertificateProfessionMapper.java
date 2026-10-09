package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.StudyCertificateProfession;

/**
 * 职业资格证书Mapper接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface StudyCertificateProfessionMapper 
{
    /**
     * 查询职业资格证书
     * 
     * @param id 职业资格证书主键
     * @return 职业资格证书
     */
    public StudyCertificateProfession selectStudyCertificateProfessionById(Long id);

    /**
     * 查询职业资格证书列表
     * 
     * @param studyCertificateProfession 职业资格证书
     * @return 职业资格证书集合
     */
    public List<StudyCertificateProfession> selectStudyCertificateProfessionList(StudyCertificateProfession studyCertificateProfession);

    /**
     * 新增职业资格证书
     * 
     * @param studyCertificateProfession 职业资格证书
     * @return 结果
     */
    public int insertStudyCertificateProfession(StudyCertificateProfession studyCertificateProfession);

    /**
     * 修改职业资格证书
     * 
     * @param studyCertificateProfession 职业资格证书
     * @return 结果
     */
    public int updateStudyCertificateProfession(StudyCertificateProfession studyCertificateProfession);

    /**
     * 删除职业资格证书
     * 
     * @param id 职业资格证书主键
     * @return 结果
     */
    public int deleteStudyCertificateProfessionById(Long id);

    /**
     * 批量删除职业资格证书
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudyCertificateProfessionByIds(Long[] ids);
}
