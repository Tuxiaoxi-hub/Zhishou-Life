package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.TrafficSignIdentifyMapper;
import zhishoulife.system.domain.TrafficSignIdentify;
import zhishoulife.system.service.ITrafficSignIdentifyService;

/**
 * 交通标志识别Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class TrafficSignIdentifyServiceImpl implements ITrafficSignIdentifyService 
{
    @Autowired
    private TrafficSignIdentifyMapper trafficSignIdentifyMapper;

    /**
     * 查询交通标志识别
     * 
     * @param id 交通标志识别主键
     * @return 交通标志识别
     */
    @Override
    public TrafficSignIdentify selectTrafficSignIdentifyById(Long id)
    {
        return trafficSignIdentifyMapper.selectTrafficSignIdentifyById(id);
    }

    /**
     * 查询交通标志识别列表
     * 
     * @param trafficSignIdentify 交通标志识别
     * @return 交通标志识别
     */
    @Override
    public List<TrafficSignIdentify> selectTrafficSignIdentifyList(TrafficSignIdentify trafficSignIdentify)
    {
        return trafficSignIdentifyMapper.selectTrafficSignIdentifyList(trafficSignIdentify);
    }

    /**
     * 新增交通标志识别
     * 
     * @param trafficSignIdentify 交通标志识别
     * @return 结果
     */
    @Override
    public int insertTrafficSignIdentify(TrafficSignIdentify trafficSignIdentify)
    {
        trafficSignIdentify.setCreateTime(DateUtils.getNowDate());
        return trafficSignIdentifyMapper.insertTrafficSignIdentify(trafficSignIdentify);
    }

    /**
     * 修改交通标志识别
     * 
     * @param trafficSignIdentify 交通标志识别
     * @return 结果
     */
    @Override
    public int updateTrafficSignIdentify(TrafficSignIdentify trafficSignIdentify)
    {
        return trafficSignIdentifyMapper.updateTrafficSignIdentify(trafficSignIdentify);
    }

    /**
     * 批量删除交通标志识别
     * 
     * @param ids 需要删除的交通标志识别主键
     * @return 结果
     */
    @Override
    public int deleteTrafficSignIdentifyByIds(Long[] ids)
    {
        return trafficSignIdentifyMapper.deleteTrafficSignIdentifyByIds(ids);
    }

    /**
     * 删除交通标志识别信息
     * 
     * @param id 交通标志识别主键
     * @return 结果
     */
    @Override
    public int deleteTrafficSignIdentifyById(Long id)
    {
        return trafficSignIdentifyMapper.deleteTrafficSignIdentifyById(id);
    }
}
