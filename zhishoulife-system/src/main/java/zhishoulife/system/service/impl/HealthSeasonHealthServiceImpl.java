package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.HealthSeasonHealthMapper;
import zhishoulife.system.domain.HealthSeasonHealth;
import zhishoulife.system.service.IHealthSeasonHealthService;

/**
 * 四季养生常识Service业务层处理
 * 
 * @author admin
 * @date 2026-03-27
 */
@Service
public class HealthSeasonHealthServiceImpl implements IHealthSeasonHealthService 
{
    @Autowired
    private HealthSeasonHealthMapper healthSeasonHealthMapper;

    /**
     * 查询四季养生常识
     * 
     * @param id 四季养生常识主键
     * @return 四季养生常识
     */
    @Override
    public HealthSeasonHealth selectHealthSeasonHealthById(Long id)
    {
        return healthSeasonHealthMapper.selectHealthSeasonHealthById(id);
    }

    /**
     * 查询四季养生常识列表
     * 
     * @param healthSeasonHealth 四季养生常识
     * @return 四季养生常识
     */
    @Override
    public List<HealthSeasonHealth> selectHealthSeasonHealthList(HealthSeasonHealth healthSeasonHealth)
    {
        return healthSeasonHealthMapper.selectHealthSeasonHealthList(healthSeasonHealth);
    }

    /**
     * 新增四季养生常识
     * 
     * @param healthSeasonHealth 四季养生常识
     * @return 结果
     */
    @Override
    public int insertHealthSeasonHealth(HealthSeasonHealth healthSeasonHealth)
    {
        healthSeasonHealth.setCreateTime(DateUtils.getNowDate());
        return healthSeasonHealthMapper.insertHealthSeasonHealth(healthSeasonHealth);
    }

    /**
     * 修改四季养生常识
     * 
     * @param healthSeasonHealth 四季养生常识
     * @return 结果
     */
    @Override
    public int updateHealthSeasonHealth(HealthSeasonHealth healthSeasonHealth)
    {
        return healthSeasonHealthMapper.updateHealthSeasonHealth(healthSeasonHealth);
    }

    /**
     * 批量删除四季养生常识
     * 
     * @param ids 需要删除的四季养生常识主键
     * @return 结果
     */
    @Override
    public int deleteHealthSeasonHealthByIds(Long[] ids)
    {
        return healthSeasonHealthMapper.deleteHealthSeasonHealthByIds(ids);
    }

    /**
     * 删除四季养生常识信息
     * 
     * @param id 四季养生常识主键
     * @return 结果
     */
    @Override
    public int deleteHealthSeasonHealthById(Long id)
    {
        return healthSeasonHealthMapper.deleteHealthSeasonHealthById(id);
    }
}
