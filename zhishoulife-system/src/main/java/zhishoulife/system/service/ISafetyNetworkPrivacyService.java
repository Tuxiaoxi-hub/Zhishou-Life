package zhishoulife.system.service;

import java.util.List;
import zhishoulife.system.domain.SafetyNetworkPrivacy;

/**
 * 个人隐私保护Service接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface ISafetyNetworkPrivacyService 
{
    /**
     * 查询个人隐私保护
     * 
     * @param id 个人隐私保护主键
     * @return 个人隐私保护
     */
    public SafetyNetworkPrivacy selectSafetyNetworkPrivacyById(Long id);

    /**
     * 查询个人隐私保护列表
     * 
     * @param safetyNetworkPrivacy 个人隐私保护
     * @return 个人隐私保护集合
     */
    public List<SafetyNetworkPrivacy> selectSafetyNetworkPrivacyList(SafetyNetworkPrivacy safetyNetworkPrivacy);

    /**
     * 新增个人隐私保护
     * 
     * @param safetyNetworkPrivacy 个人隐私保护
     * @return 结果
     */
    public int insertSafetyNetworkPrivacy(SafetyNetworkPrivacy safetyNetworkPrivacy);

    /**
     * 修改个人隐私保护
     * 
     * @param safetyNetworkPrivacy 个人隐私保护
     * @return 结果
     */
    public int updateSafetyNetworkPrivacy(SafetyNetworkPrivacy safetyNetworkPrivacy);

    /**
     * 批量删除个人隐私保护
     * 
     * @param ids 需要删除的个人隐私保护主键集合
     * @return 结果
     */
    public int deleteSafetyNetworkPrivacyByIds(Long[] ids);

    /**
     * 删除个人隐私保护信息
     * 
     * @param id 个人隐私保护主键
     * @return 结果
     */
    public int deleteSafetyNetworkPrivacyById(Long id);
}
