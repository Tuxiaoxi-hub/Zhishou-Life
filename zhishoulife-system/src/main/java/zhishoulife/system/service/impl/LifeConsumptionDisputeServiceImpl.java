package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.LifeConsumptionDisputeMapper;
import zhishoulife.system.domain.LifeConsumptionDispute;
import zhishoulife.system.service.ILifeConsumptionDisputeService;

/**
 * 常见消费纠纷处理Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class LifeConsumptionDisputeServiceImpl implements ILifeConsumptionDisputeService 
{
    @Autowired
    private LifeConsumptionDisputeMapper lifeConsumptionDisputeMapper;

    /**
     * 查询常见消费纠纷处理
     * 
     * @param id 常见消费纠纷处理主键
     * @return 常见消费纠纷处理
     */
    @Override
    public LifeConsumptionDispute selectLifeConsumptionDisputeById(Long id)
    {
        return lifeConsumptionDisputeMapper.selectLifeConsumptionDisputeById(id);
    }

    /**
     * 查询常见消费纠纷处理列表
     * 
     * @param lifeConsumptionDispute 常见消费纠纷处理
     * @return 常见消费纠纷处理
     */
    @Override
    public List<LifeConsumptionDispute> selectLifeConsumptionDisputeList(LifeConsumptionDispute lifeConsumptionDispute)
    {
        return lifeConsumptionDisputeMapper.selectLifeConsumptionDisputeList(lifeConsumptionDispute);
    }

    /**
     * 新增常见消费纠纷处理
     * 
     * @param lifeConsumptionDispute 常见消费纠纷处理
     * @return 结果
     */
    @Override
    public int insertLifeConsumptionDispute(LifeConsumptionDispute lifeConsumptionDispute)
    {
        lifeConsumptionDispute.setCreateTime(DateUtils.getNowDate());
        return lifeConsumptionDisputeMapper.insertLifeConsumptionDispute(lifeConsumptionDispute);
    }

    /**
     * 修改常见消费纠纷处理
     * 
     * @param lifeConsumptionDispute 常见消费纠纷处理
     * @return 结果
     */
    @Override
    public int updateLifeConsumptionDispute(LifeConsumptionDispute lifeConsumptionDispute)
    {
        return lifeConsumptionDisputeMapper.updateLifeConsumptionDispute(lifeConsumptionDispute);
    }

    /**
     * 批量删除常见消费纠纷处理
     * 
     * @param ids 需要删除的常见消费纠纷处理主键
     * @return 结果
     */
    @Override
    public int deleteLifeConsumptionDisputeByIds(Long[] ids)
    {
        return lifeConsumptionDisputeMapper.deleteLifeConsumptionDisputeByIds(ids);
    }

    /**
     * 删除常见消费纠纷处理信息
     * 
     * @param id 常见消费纠纷处理主键
     * @return 结果
     */
    @Override
    public int deleteLifeConsumptionDisputeById(Long id)
    {
        return lifeConsumptionDisputeMapper.deleteLifeConsumptionDisputeById(id);
    }
}
