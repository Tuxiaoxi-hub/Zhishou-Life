package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.TrafficSignIdentify;

/**
 * 交通标志识别Mapper接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface TrafficSignIdentifyMapper 
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
     * 删除交通标志识别
     * 
     * @param id 交通标志识别主键
     * @return 结果
     */
    public int deleteTrafficSignIdentifyById(Long id);

    /**
     * 批量删除交通标志识别
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTrafficSignIdentifyByIds(Long[] ids);
}
