package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.LifeConsumptionChannel;

/**
 * 消费维权渠道Mapper接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface LifeConsumptionChannelMapper 
{
    /**
     * 查询消费维权渠道
     * 
     * @param id 消费维权渠道主键
     * @return 消费维权渠道
     */
    public LifeConsumptionChannel selectLifeConsumptionChannelById(Long id);

    /**
     * 查询消费维权渠道列表
     * 
     * @param lifeConsumptionChannel 消费维权渠道
     * @return 消费维权渠道集合
     */
    public List<LifeConsumptionChannel> selectLifeConsumptionChannelList(LifeConsumptionChannel lifeConsumptionChannel);

    /**
     * 新增消费维权渠道
     * 
     * @param lifeConsumptionChannel 消费维权渠道
     * @return 结果
     */
    public int insertLifeConsumptionChannel(LifeConsumptionChannel lifeConsumptionChannel);

    /**
     * 修改消费维权渠道
     * 
     * @param lifeConsumptionChannel 消费维权渠道
     * @return 结果
     */
    public int updateLifeConsumptionChannel(LifeConsumptionChannel lifeConsumptionChannel);

    /**
     * 删除消费维权渠道
     * 
     * @param id 消费维权渠道主键
     * @return 结果
     */
    public int deleteLifeConsumptionChannelById(Long id);

    /**
     * 批量删除消费维权渠道
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLifeConsumptionChannelByIds(Long[] ids);
}
