package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.TrafficPublicSafe;

/**
 * 公共出行安全Mapper接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface TrafficPublicSafeMapper 
{
    /**
     * 查询公共出行安全
     * 
     * @param id 公共出行安全主键
     * @return 公共出行安全
     */
    public TrafficPublicSafe selectTrafficPublicSafeById(Long id);

    /**
     * 查询公共出行安全列表
     * 
     * @param trafficPublicSafe 公共出行安全
     * @return 公共出行安全集合
     */
    public List<TrafficPublicSafe> selectTrafficPublicSafeList(TrafficPublicSafe trafficPublicSafe);

    /**
     * 新增公共出行安全
     * 
     * @param trafficPublicSafe 公共出行安全
     * @return 结果
     */
    public int insertTrafficPublicSafe(TrafficPublicSafe trafficPublicSafe);

    /**
     * 修改公共出行安全
     * 
     * @param trafficPublicSafe 公共出行安全
     * @return 结果
     */
    public int updateTrafficPublicSafe(TrafficPublicSafe trafficPublicSafe);

    /**
     * 删除公共出行安全
     * 
     * @param id 公共出行安全主键
     * @return 结果
     */
    public int deleteTrafficPublicSafeById(Long id);

    /**
     * 批量删除公共出行安全
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTrafficPublicSafeByIds(Long[] ids);
}
