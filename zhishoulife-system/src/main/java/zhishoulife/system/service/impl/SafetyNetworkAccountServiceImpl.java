package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.SafetyNetworkAccountMapper;
import zhishoulife.system.domain.SafetyNetworkAccount;
import zhishoulife.system.service.ISafetyNetworkAccountService;

/**
 * 账号安全防护Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class SafetyNetworkAccountServiceImpl implements ISafetyNetworkAccountService 
{
    @Autowired
    private SafetyNetworkAccountMapper safetyNetworkAccountMapper;

    /**
     * 查询账号安全防护
     * 
     * @param id 账号安全防护主键
     * @return 账号安全防护
     */
    @Override
    public SafetyNetworkAccount selectSafetyNetworkAccountById(Long id)
    {
        return safetyNetworkAccountMapper.selectSafetyNetworkAccountById(id);
    }

    /**
     * 查询账号安全防护列表
     * 
     * @param safetyNetworkAccount 账号安全防护
     * @return 账号安全防护
     */
    @Override
    public List<SafetyNetworkAccount> selectSafetyNetworkAccountList(SafetyNetworkAccount safetyNetworkAccount)
    {
        return safetyNetworkAccountMapper.selectSafetyNetworkAccountList(safetyNetworkAccount);
    }

    /**
     * 新增账号安全防护
     * 
     * @param safetyNetworkAccount 账号安全防护
     * @return 结果
     */
    @Override
    public int insertSafetyNetworkAccount(SafetyNetworkAccount safetyNetworkAccount)
    {
        safetyNetworkAccount.setCreateTime(DateUtils.getNowDate());
        return safetyNetworkAccountMapper.insertSafetyNetworkAccount(safetyNetworkAccount);
    }

    /**
     * 修改账号安全防护
     * 
     * @param safetyNetworkAccount 账号安全防护
     * @return 结果
     */
    @Override
    public int updateSafetyNetworkAccount(SafetyNetworkAccount safetyNetworkAccount)
    {
        return safetyNetworkAccountMapper.updateSafetyNetworkAccount(safetyNetworkAccount);
    }

    /**
     * 批量删除账号安全防护
     * 
     * @param ids 需要删除的账号安全防护主键
     * @return 结果
     */
    @Override
    public int deleteSafetyNetworkAccountByIds(Long[] ids)
    {
        return safetyNetworkAccountMapper.deleteSafetyNetworkAccountByIds(ids);
    }

    /**
     * 删除账号安全防护信息
     * 
     * @param id 账号安全防护主键
     * @return 结果
     */
    @Override
    public int deleteSafetyNetworkAccountById(Long id)
    {
        return safetyNetworkAccountMapper.deleteSafetyNetworkAccountById(id);
    }
}
