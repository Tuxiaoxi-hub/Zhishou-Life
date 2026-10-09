package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.TrafficRuleCommon;

/**
 * 交通通行规则Mapper接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface TrafficRuleCommonMapper 
{
    /**
     * 查询交通通行规则
     * 
     * @param id 交通通行规则主键
     * @return 交通通行规则
     */
    public TrafficRuleCommon selectTrafficRuleCommonById(Long id);

    /**
     * 查询交通通行规则列表
     * 
     * @param trafficRuleCommon 交通通行规则
     * @return 交通通行规则集合
     */
    public List<TrafficRuleCommon> selectTrafficRuleCommonList(TrafficRuleCommon trafficRuleCommon);

    /**
     * 新增交通通行规则
     * 
     * @param trafficRuleCommon 交通通行规则
     * @return 结果
     */
    public int insertTrafficRuleCommon(TrafficRuleCommon trafficRuleCommon);

    /**
     * 修改交通通行规则
     * 
     * @param trafficRuleCommon 交通通行规则
     * @return 结果
     */
    public int updateTrafficRuleCommon(TrafficRuleCommon trafficRuleCommon);

    /**
     * 删除交通通行规则
     * 
     * @param id 交通通行规则主键
     * @return 结果
     */
    public int deleteTrafficRuleCommonById(Long id);

    /**
     * 批量删除交通通行规则
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTrafficRuleCommonByIds(Long[] ids);
}
