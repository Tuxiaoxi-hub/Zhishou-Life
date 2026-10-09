package zhishoulife.system.service;

import java.util.List;
import zhishoulife.system.domain.TrafficSignIdentify;

/**
 * 交通标志识别Service接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface ITrafficSignIdentifyService 
{
    /**
     * 查询交通标志识别
     * 
     * @param id 交通标志识别主键
     * @return 交通标志识别
     */
    public TrafficSignIdentify selectTrafficSignIdentifyById(Long id);

    /**
     * 查询交通标志识别列表
     * 
     * @param trafficSignIdentify 交通标志识别
     * @return 交通标志识别集合
     */
    public List<TrafficSignIdentify> selectTrafficSignIdentifyList(TrafficSignIdentify trafficSignIdentify);

    /**
     * 新增交通标志识别
     * 
     * @param trafficSignIdentify 交通标志识别
     * @return 结果
     */
    public int insertTrafficSignIdentify(TrafficSignIdentify trafficSignIdentify);

    /**
     * 修改交通标志识别
     * 
     * @param trafficSignIdentify 交通标志识别
     * @return 结果
     */
    public int updateTrafficSignIdentify(TrafficSignIdentify trafficSignIdentify);

    /**
     * 批量删除交通标志识别
     * 
     * @param ids 需要删除的交通标志识别主键集合
     * @return 结果
     */
    public int deleteTrafficSignIdentifyByIds(Long[] ids);

    /**
     * 删除交通标志识别信息
     * 
     * @param id 交通标志识别主键
     * @return 结果
     */
    public int deleteTrafficSignIdentifyById(Long id);
}
