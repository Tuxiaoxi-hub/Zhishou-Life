package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.SafetyNetworkPrivacyMapper;
import zhishoulife.system.domain.SafetyNetworkPrivacy;
import zhishoulife.system.service.ISafetyNetworkPrivacyService;

/**
 * 个人隐私保护Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class SafetyNetworkPrivacyServiceImpl implements ISafetyNetworkPrivacyService 
{
    @Autowired
    private SafetyNetworkPrivacyMapper safetyNetworkPrivacyMapper;

    /**
     * 查询个人隐私保护
     * 
     * @param id 个人隐私保护主键
     * @return 个人隐私保护
     */
    @Override
    public SafetyNetworkPrivacy selectSafetyNetworkPrivacyById(Long id)
    {
        return safetyNetworkPrivacyMapper.selectSafetyNetworkPrivacyById(id);
    }

    /**
     * 查询个人隐私保护列表
     * 
     * @param safetyNetworkPrivacy 个人隐私保护
     * @return 个人隐私保护
     */
    @Override
    public List<SafetyNetworkPrivacy> selectSafetyNetworkPrivacyList(SafetyNetworkPrivacy safetyNetworkPrivacy)
    {
        return safetyNetworkPrivacyMapper.selectSafetyNetworkPrivacyList(safetyNetworkPrivacy);
    }

    /**
     * 新增个人隐私保护
     * 
     * @param safetyNetworkPrivacy 个人隐私保护
     * @return 结果
     */
    @Override
    public int insertSafetyNetworkPrivacy(SafetyNetworkPrivacy safetyNetworkPrivacy)
    {
        safetyNetworkPrivacy.setCreateTime(DateUtils.getNowDate());
        return safetyNetworkPrivacyMapper.insertSafetyNetworkPrivacy(safetyNetworkPrivacy);
    }

    /**
     * 修改个人隐私保护
     * 
     * @param safetyNetworkPrivacy 个人隐私保护
     * @return 结果
     */
    @Override
    public int updateSafetyNetworkPrivacy(SafetyNetworkPrivacy safetyNetworkPrivacy)
    {
        return safetyNetworkPrivacyMapper.updateSafetyNetworkPrivacy(safetyNetworkPrivacy);
    }

    /**
     * 批量删除个人隐私保护
     * 
     * @param ids 需要删除的个人隐私保护主键
     * @return 结果
     */
    @Override
    public int deleteSafetyNetworkPrivacyByIds(Long[] ids)
    {
        return safetyNetworkPrivacyMapper.deleteSafetyNetworkPrivacyByIds(ids);
    }

    /**
     * 删除个人隐私保护信息
     * 
     * @param id 个人隐私保护主键
     * @return 结果
     */
    @Override
    public int deleteSafetyNetworkPrivacyById(Long id)
    {
        return safetyNetworkPrivacyMapper.deleteSafetyNetworkPrivacyById(id);
    }
}
