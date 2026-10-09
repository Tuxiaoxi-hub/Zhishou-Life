package zhishoulife.system.service;

import java.util.List;
import zhishoulife.system.domain.SafetyNetworkFraud;

/**
 * 网络诈骗防范Service接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface ISafetyNetworkFraudService 
{
    /**
     * 查询网络诈骗防范
     * 
     * @param id 网络诈骗防范主键
     * @return 网络诈骗防范
     */
    public SafetyNetworkFraud selectSafetyNetworkFraudById(Long id);

    /**
     * 查询网络诈骗防范列表
     * 
     * @param safetyNetworkFraud 网络诈骗防范
     * @return 网络诈骗防范集合
     */
    public List<SafetyNetworkFraud> selectSafetyNetworkFraudList(SafetyNetworkFraud safetyNetworkFraud);

    /**
     * 新增网络诈骗防范
     * 
     * @param safetyNetworkFraud 网络诈骗防范
     * @return 结果
     */
    public int insertSafetyNetworkFraud(SafetyNetworkFraud safetyNetworkFraud);

    /**
     * 修改网络诈骗防范
     * 
     * @param safetyNetworkFraud 网络诈骗防范
     * @return 结果
     */
    public int updateSafetyNetworkFraud(SafetyNetworkFraud safetyNetworkFraud);

    /**
     * 批量删除网络诈骗防范
     * 
     * @param ids 需要删除的网络诈骗防范主键集合
     * @return 结果
     */
    public int deleteSafetyNetworkFraudByIds(Long[] ids);

    /**
     * 删除网络诈骗防范信息
     * 
     * @param id 网络诈骗防范主键
     * @return 结果
     */
    public int deleteSafetyNetworkFraudById(Long id);
}
