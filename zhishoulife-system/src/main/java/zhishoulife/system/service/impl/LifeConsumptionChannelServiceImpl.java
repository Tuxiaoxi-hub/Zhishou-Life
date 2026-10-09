package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.LifeConsumptionChannelMapper;
import zhishoulife.system.domain.LifeConsumptionChannel;
import zhishoulife.system.service.ILifeConsumptionChannelService;

/**
 * 消费维权渠道Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class LifeConsumptionChannelServiceImpl implements ILifeConsumptionChannelService 
{
    @Autowired
    private LifeConsumptionChannelMapper lifeConsumptionChannelMapper;

    /**
     * 查询消费维权渠道
     * 
     * @param id 消费维权渠道主键
     * @return 消费维权渠道
     */
    @Override
    public LifeConsumptionChannel selectLifeConsumptionChannelById(Long id)
    {
        return lifeConsumptionChannelMapper.selectLifeConsumptionChannelById(id);
    }

    /**
     * 查询消费维权渠道列表
     * 
     * @param lifeConsumptionChannel 消费维权渠道
     * @return 消费维权渠道
     */
    @Override
    public List<LifeConsumptionChannel> selectLifeConsumptionChannelList(LifeConsumptionChannel lifeConsumptionChannel)
    {
        return lifeConsumptionChannelMapper.selectLifeConsumptionChannelList(lifeConsumptionChannel);
    }

    /**
     * 新增消费维权渠道
     * 
     * @param lifeConsumptionChannel 消费维权渠道
     * @return 结果
     */
    @Override
    public int insertLifeConsumptionChannel(LifeConsumptionChannel lifeConsumptionChannel)
    {
        lifeConsumptionChannel.setCreateTime(DateUtils.getNowDate());
        return lifeConsumptionChannelMapper.insertLifeConsumptionChannel(lifeConsumptionChannel);
    }

    /**
     * 修改消费维权渠道
     * 
     * @param lifeConsumptionChannel 消费维权渠道
     * @return 结果
     */
    @Override
    public int updateLifeConsumptionChannel(LifeConsumptionChannel lifeConsumptionChannel)
    {
        return lifeConsumptionChannelMapper.updateLifeConsumptionChannel(lifeConsumptionChannel);
    }

    /**
     * 批量删除消费维权渠道
     * 
     * @param ids 需要删除的消费维权渠道主键
     * @return 结果
     */
    @Override
    public int deleteLifeConsumptionChannelByIds(Long[] ids)
    {
        return lifeConsumptionChannelMapper.deleteLifeConsumptionChannelByIds(ids);
    }

    /**
     * 删除消费维权渠道信息
     * 
     * @param id 消费维权渠道主键
     * @return 结果
     */
    @Override
    public int deleteLifeConsumptionChannelById(Long id)
    {
        return lifeConsumptionChannelMapper.deleteLifeConsumptionChannelById(id);
    }
}
