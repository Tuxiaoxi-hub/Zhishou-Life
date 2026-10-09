package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.SafetyNetworkAccount;

/**
 * 账号安全防护Mapper接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface SafetyNetworkAccountMapper 
{
    /**
     * 查询账号安全防护
     * 
     * @param id 账号安全防护主键
     * @return 账号安全防护
     */
    public SafetyNetworkAccount selectSafetyNetworkAccountById(Long id);

    /**
     * 查询账号安全防护列表
     * 
     * @param safetyNetworkAccount 账号安全防护
     * @return 账号安全防护集合
     */
    public List<SafetyNetworkAccount> selectSafetyNetworkAccountList(SafetyNetworkAccount safetyNetworkAccount);

    /**
     * 新增账号安全防护
     * 
     * @param safetyNetworkAccount 账号安全防护
     * @return 结果
     */
    public int insertSafetyNetworkAccount(SafetyNetworkAccount safetyNetworkAccount);

    /**
     * 修改账号安全防护
     * 
     * @param safetyNetworkAccount 账号安全防护
     * @return 结果
     */
    public int updateSafetyNetworkAccount(SafetyNetworkAccount safetyNetworkAccount);

    /**
     * 删除账号安全防护
     * 
     * @param id 账号安全防护主键
     * @return 结果
     */
    public int deleteSafetyNetworkAccountById(Long id);

    /**
     * 批量删除账号安全防护
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSafetyNetworkAccountByIds(Long[] ids);
}
