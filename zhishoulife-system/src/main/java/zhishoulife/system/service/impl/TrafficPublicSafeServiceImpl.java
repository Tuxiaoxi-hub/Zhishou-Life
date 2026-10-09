package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.TrafficPublicSafeMapper;
import zhishoulife.system.domain.TrafficPublicSafe;
import zhishoulife.system.service.ITrafficPublicSafeService;

/**
 * 公共出行安全Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class TrafficPublicSafeServiceImpl implements ITrafficPublicSafeService 
{
    @Autowired
    private TrafficPublicSafeMapper trafficPublicSafeMapper;

    /**
     * 查询公共出行安全
     * 
     * @param id 公共出行安全主键
     * @return 公共出行安全
     */
    @Override
    public TrafficPublicSafe selectTrafficPublicSafeById(Long id)
    {
        return trafficPublicSafeMapper.selectTrafficPublicSafeById(id);
    }

    /**
     * 查询公共出行安全列表
     * 
     * @param trafficPublicSafe 公共出行安全
     * @return 公共出行安全
     */
    @Override
    public List<TrafficPublicSafe> selectTrafficPublicSafeList(TrafficPublicSafe trafficPublicSafe)
    {
        return trafficPublicSafeMapper.selectTrafficPublicSafeList(trafficPublicSafe);
    }

    /**
     * 新增公共出行安全
     * 
     * @param trafficPublicSafe 公共出行安全
     * @return 结果
     */
    @Override
    public int insertTrafficPublicSafe(TrafficPublicSafe trafficPublicSafe)
    {
        trafficPublicSafe.setCreateTime(DateUtils.getNowDate());
        return trafficPublicSafeMapper.insertTrafficPublicSafe(trafficPublicSafe);
    }

    /**
     * 修改公共出行安全
     * 
     * @param trafficPublicSafe 公共出行安全
     * @return 结果
     */
    @Override
    public int updateTrafficPublicSafe(TrafficPublicSafe trafficPublicSafe)
    {
        return trafficPublicSafeMapper.updateTrafficPublicSafe(trafficPublicSafe);
    }

    /**
     * 批量删除公共出行安全
     * 
     * @param ids 需要删除的公共出行安全主键
     * @return 结果
     */
    @Override
    public int deleteTrafficPublicSafeByIds(Long[] ids)
    {
        return trafficPublicSafeMapper.deleteTrafficPublicSafeByIds(ids);
    }

    /**
     * 删除公共出行安全信息
     * 
     * @param id 公共出行安全主键
     * @return 结果
     */
    @Override
    public int deleteTrafficPublicSafeById(Long id)
    {
        return trafficPublicSafeMapper.deleteTrafficPublicSafeById(id);
    }
}
