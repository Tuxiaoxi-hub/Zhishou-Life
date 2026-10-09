package zhishoulife.system.service;

import java.util.List;
import zhishoulife.system.domain.LifeConsumptionDispute;

/**
 * 常见消费纠纷处理Service接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface ILifeConsumptionDisputeService 
{
    /**
     * 查询常见消费纠纷处理
     * 
     * @param id 常见消费纠纷处理主键
     * @return 常见消费纠纷处理
     */
    public LifeConsumptionDispute selectLifeConsumptionDisputeById(Long id);

    /**
     * 查询常见消费纠纷处理列表
     * 
     * @param lifeConsumptionDispute 常见消费纠纷处理
     * @return 常见消费纠纷处理集合
     */
    public List<LifeConsumptionDispute> selectLifeConsumptionDisputeList(LifeConsumptionDispute lifeConsumptionDispute);

    /**
     * 新增常见消费纠纷处理
     * 
     * @param lifeConsumptionDispute 常见消费纠纷处理
     * @return 结果
     */
    public int insertLifeConsumptionDispute(LifeConsumptionDispute lifeConsumptionDispute);

    /**
     * 修改常见消费纠纷处理
     * 
     * @param lifeConsumptionDispute 常见消费纠纷处理
     * @return 结果
     */
    public int updateLifeConsumptionDispute(LifeConsumptionDispute lifeConsumptionDispute);

    /**
     * 批量删除常见消费纠纷处理
     * 
     * @param ids 需要删除的常见消费纠纷处理主键集合
     * @return 结果
     */
    public int deleteLifeConsumptionDisputeByIds(Long[] ids);

    /**
     * 删除常见消费纠纷处理信息
     * 
     * @param id 常见消费纠纷处理主键
     * @return 结果
     */
    public int deleteLifeConsumptionDisputeById(Long id);
}
