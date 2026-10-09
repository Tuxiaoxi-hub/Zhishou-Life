package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.SafetyNetworkFraudMapper;
import zhishoulife.system.domain.SafetyNetworkFraud;
import zhishoulife.system.service.ISafetyNetworkFraudService;

/**
 * 网络诈骗防范Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class SafetyNetworkFraudServiceImpl implements ISafetyNetworkFraudService 
{
    @Autowired
    private SafetyNetworkFraudMapper safetyNetworkFraudMapper;

    /**
     * 查询网络诈骗防范
     * 
     * @param id 网络诈骗防范主键
     * @return 网络诈骗防范
     */
    @Override
    public SafetyNetworkFraud selectSafetyNetworkFraudById(Long id)
    {
        return safetyNetworkFraudMapper.selectSafetyNetworkFraudById(id);
    }

    /**
     * 查询网络诈骗防范列表
     * 
     * @param safetyNetworkFraud 网络诈骗防范
     * @return 网络诈骗防范
     */
    @Override
    public List<SafetyNetworkFraud> selectSafetyNetworkFraudList(SafetyNetworkFraud safetyNetworkFraud)
    {
        return safetyNetworkFraudMapper.selectSafetyNetworkFraudList(safetyNetworkFraud);
    }

    /**
     * 新增网络诈骗防范
     * 
     * @param safetyNetworkFraud 网络诈骗防范
     * @return 结果
     */
    @Override
    public int insertSafetyNetworkFraud(SafetyNetworkFraud safetyNetworkFraud)
    {
        safetyNetworkFraud.setCreateTime(DateUtils.getNowDate());
        return safetyNetworkFraudMapper.insertSafetyNetworkFraud(safetyNetworkFraud);
    }

    /**
     * 修改网络诈骗防范
     * 
     * @param safetyNetworkFraud 网络诈骗防范
     * @return 结果
     */
    @Override
    public int updateSafetyNetworkFraud(SafetyNetworkFraud safetyNetworkFraud)
    {
        return safetyNetworkFraudMapper.updateSafetyNetworkFraud(safetyNetworkFraud);
    }

    /**
     * 批量删除网络诈骗防范
     * 
     * @param ids 需要删除的网络诈骗防范主键
     * @return 结果
     */
    @Override
    public int deleteSafetyNetworkFraudByIds(Long[] ids)
    {
        return safetyNetworkFraudMapper.deleteSafetyNetworkFraudByIds(ids);
    }

    /**
     * 删除网络诈骗防范信息
     * 
     * @param id 网络诈骗防范主键
     * @return 结果
     */
    @Override
    public int deleteSafetyNetworkFraudById(Long id)
    {
        return safetyNetworkFraudMapper.deleteSafetyNetworkFraudById(id);
    }
}
