package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.HealthSportFitnessMapper;
import zhishoulife.system.domain.HealthSportFitness;
import zhishoulife.system.service.IHealthSportFitnessService;

/**
 * 运动健身常识Service业务层处理
 * 
 * @author admin
 * @date 2026-03-27
 */
@Service
public class HealthSportFitnessServiceImpl implements IHealthSportFitnessService 
{
    @Autowired
    private HealthSportFitnessMapper healthSportFitnessMapper;

    /**
     * 查询运动健身常识
     * 
     * @param id 运动健身常识主键
     * @return 运动健身常识
     */
    @Override
    public HealthSportFitness selectHealthSportFitnessById(Long id)
    {
        return healthSportFitnessMapper.selectHealthSportFitnessById(id);
    }

    /**
     * 查询运动健身常识列表
     * 
     * @param healthSportFitness 运动健身常识
     * @return 运动健身常识
     */
    @Override
    public List<HealthSportFitness> selectHealthSportFitnessList(HealthSportFitness healthSportFitness)
    {
        return healthSportFitnessMapper.selectHealthSportFitnessList(healthSportFitness);
    }

    /**
     * 新增运动健身常识
     * 
     * @param healthSportFitness 运动健身常识
     * @return 结果
     */
    @Override
    public int insertHealthSportFitness(HealthSportFitness healthSportFitness)
    {
        healthSportFitness.setCreateTime(DateUtils.getNowDate());
        return healthSportFitnessMapper.insertHealthSportFitness(healthSportFitness);
    }

    /**
     * 修改运动健身常识
     * 
     * @param healthSportFitness 运动健身常识
     * @return 结果
     */
    @Override
    public int updateHealthSportFitness(HealthSportFitness healthSportFitness)
    {
        return healthSportFitnessMapper.updateHealthSportFitness(healthSportFitness);
    }

    /**
     * 批量删除运动健身常识
     * 
     * @param ids 需要删除的运动健身常识主键
     * @return 结果
     */
    @Override
    public int deleteHealthSportFitnessByIds(Long[] ids)
    {
        return healthSportFitnessMapper.deleteHealthSportFitnessByIds(ids);
    }

    /**
     * 删除运动健身常识信息
     * 
     * @param id 运动健身常识主键
     * @return 结果
     */
    @Override
    public int deleteHealthSportFitnessById(Long id)
    {
        return healthSportFitnessMapper.deleteHealthSportFitnessById(id);
    }
}
