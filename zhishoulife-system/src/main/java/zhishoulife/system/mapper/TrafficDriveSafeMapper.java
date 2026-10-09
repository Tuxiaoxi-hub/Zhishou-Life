package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.TrafficDriveSafe;

/**
 * 自驾出行安全Mapper接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface TrafficDriveSafeMapper 
{
    /**
     * 查询自驾出行安全
     * 
     * @param id 自驾出行安全主键
     * @return 自驾出行安全
     */
    public TrafficDriveSafe selectTrafficDriveSafeById(Long id);

    /**
     * 查询自驾出行安全列表
     * 
     * @param trafficDriveSafe 自驾出行安全
     * @return 自驾出行安全集合
     */
    public List<TrafficDriveSafe> selectTrafficDriveSafeList(TrafficDriveSafe trafficDriveSafe);

    /**
     * 新增自驾出行安全
     * 
     * @param trafficDriveSafe 自驾出行安全
     * @return 结果
     */
    public int insertTrafficDriveSafe(TrafficDriveSafe trafficDriveSafe);

    /**
     * 修改自驾出行安全
     * 
     * @param trafficDriveSafe 自驾出行安全
     * @return 结果
     */
    public int updateTrafficDriveSafe(TrafficDriveSafe trafficDriveSafe);

    /**
     * 删除自驾出行安全
     * 
     * @param id 自驾出行安全主键
     * @return 结果
     */
    public int deleteTrafficDriveSafeById(Long id);

    /**
     * 批量删除自驾出行安全
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTrafficDriveSafeByIds(Long[] ids);
}
