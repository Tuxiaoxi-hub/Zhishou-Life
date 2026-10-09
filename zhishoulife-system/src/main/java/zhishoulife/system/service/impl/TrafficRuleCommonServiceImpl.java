package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.TrafficRuleCommonMapper;
import zhishoulife.system.domain.TrafficRuleCommon;
import zhishoulife.system.service.ITrafficRuleCommonService;

/**
 * 交通通行规则Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class TrafficRuleCommonServiceImpl implements ITrafficRuleCommonService 
{
    @Autowired
    private TrafficRuleCommonMapper trafficRuleCommonMapper;

    /**
     * 查询交通通行规则
     * 
     * @param id 交通通行规则主键
     * @return 交通通行规则
     */
    @Override
    public TrafficRuleCommon selectTrafficRuleCommonById(Long id)
    {
        return trafficRuleCommonMapper.selectTrafficRuleCommonById(id);
    }

    /**
     * 查询交通通行规则列表
     * 
     * @param trafficRuleCommon 交通通行规则
     * @return 交通通行规则
     */
    @Override
    public List<TrafficRuleCommon> selectTrafficRuleCommonList(TrafficRuleCommon trafficRuleCommon)
    {
        return trafficRuleCommonMapper.selectTrafficRuleCommonList(trafficRuleCommon);
    }

    /**
     * 新增交通通行规则
     * 
     * @param trafficRuleCommon 交通通行规则
     * @return 结果
     */
    @Override
    public int insertTrafficRuleCommon(TrafficRuleCommon trafficRuleCommon)
    {
        trafficRuleCommon.setCreateTime(DateUtils.getNowDate());
        return trafficRuleCommonMapper.insertTrafficRuleCommon(trafficRuleCommon);
    }

    /**
     * 修改交通通行规则
     * 
     * @param trafficRuleCommon 交通通行规则
     * @return 结果
     */
    @Override
    public int updateTrafficRuleCommon(TrafficRuleCommon trafficRuleCommon)
    {
        return trafficRuleCommonMapper.updateTrafficRuleCommon(trafficRuleCommon);
    }

    /**
     * 批量删除交通通行规则
     * 
     * @param ids 需要删除的交通通行规则主键
     * @return 结果
     */
    @Override
    public int deleteTrafficRuleCommonByIds(Long[] ids)
    {
        return trafficRuleCommonMapper.deleteTrafficRuleCommonByIds(ids);
    }

    /**
     * 删除交通通行规则信息
     * 
     * @param id 交通通行规则主键
     * @return 结果
     */
    @Override
    public int deleteTrafficRuleCommonById(Long id)
    {
        return trafficRuleCommonMapper.deleteTrafficRuleCommonById(id);
    }
}
