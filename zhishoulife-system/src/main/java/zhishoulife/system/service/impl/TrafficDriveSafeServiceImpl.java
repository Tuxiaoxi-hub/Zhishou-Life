package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.TrafficDriveSafeMapper;
import zhishoulife.system.domain.TrafficDriveSafe;
import zhishoulife.system.service.ITrafficDriveSafeService;

/**
 * 自驾出行安全Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class TrafficDriveSafeServiceImpl implements ITrafficDriveSafeService 
{
    @Autowired
    private TrafficDriveSafeMapper trafficDriveSafeMapper;

    /**
     * 查询自驾出行安全
     * 
     * @param id 自驾出行安全主键
     * @return 自驾出行安全
     */
    @Override
    public TrafficDriveSafe selectTrafficDriveSafeById(Long id)
    {
        return trafficDriveSafeMapper.selectTrafficDriveSafeById(id);
    }

    /**
     * 查询自驾出行安全列表
     * 
     * @param trafficDriveSafe 自驾出行安全
     * @return 自驾出行安全
     */
    @Override
    public List<TrafficDriveSafe> selectTrafficDriveSafeList(TrafficDriveSafe trafficDriveSafe)
    {
        return trafficDriveSafeMapper.selectTrafficDriveSafeList(trafficDriveSafe);
    }

    /**
     * 新增自驾出行安全
     * 
     * @param trafficDriveSafe 自驾出行安全
     * @return 结果
     */
    @Override
    public int insertTrafficDriveSafe(TrafficDriveSafe trafficDriveSafe)
    {
        trafficDriveSafe.setCreateTime(DateUtils.getNowDate());
        return trafficDriveSafeMapper.insertTrafficDriveSafe(trafficDriveSafe);
    }

    /**
     * 修改自驾出行安全
     * 
     * @param trafficDriveSafe 自驾出行安全
     * @return 结果
     */
    @Override
    public int updateTrafficDriveSafe(TrafficDriveSafe trafficDriveSafe)
    {
        return trafficDriveSafeMapper.updateTrafficDriveSafe(trafficDriveSafe);
    }

    /**
     * 批量删除自驾出行安全
     * 
     * @param ids 需要删除的自驾出行安全主键
     * @return 结果
     */
    @Override
    public int deleteTrafficDriveSafeByIds(Long[] ids)
    {
        return trafficDriveSafeMapper.deleteTrafficDriveSafeByIds(ids);
    }

    /**
     * 删除自驾出行安全信息
     * 
     * @param id 自驾出行安全主键
     * @return 结果
     */
    @Override
    public int deleteTrafficDriveSafeById(Long id)
    {
        return trafficDriveSafeMapper.deleteTrafficDriveSafeById(id);
    }
}
