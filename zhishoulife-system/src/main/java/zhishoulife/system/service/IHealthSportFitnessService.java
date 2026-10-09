package zhishoulife.system.service;

import java.util.List;
import zhishoulife.system.domain.HealthSportFitness;

/**
 * 运动健身常识Service接口
 * 
 * @author admin
 * @date 2026-03-27
 */
public interface IHealthSportFitnessService 
{
    /**
     * 查询运动健身常识
     * 
     * @param id 运动健身常识主键
     * @return 运动健身常识
     */
    public HealthSportFitness selectHealthSportFitnessById(Long id);

    /**
     * 查询运动健身常识列表
     * 
     * @param healthSportFitness 运动健身常识
     * @return 运动健身常识集合
     */
    public List<HealthSportFitness> selectHealthSportFitnessList(HealthSportFitness healthSportFitness);

    /**
     * 新增运动健身常识
     * 
     * @param healthSportFitness 运动健身常识
     * @return 结果
     */
    public int insertHealthSportFitness(HealthSportFitness healthSportFitness);

    /**
     * 修改运动健身常识
     * 
     * @param healthSportFitness 运动健身常识
     * @return 结果
     */
    public int updateHealthSportFitness(HealthSportFitness healthSportFitness);

    /**
     * 批量删除运动健身常识
     * 
     * @param ids 需要删除的运动健身常识主键集合
     * @return 结果
     */
    public int deleteHealthSportFitnessByIds(Long[] ids);

    /**
     * 删除运动健身常识信息
     * 
     * @param id 运动健身常识主键
     * @return 结果
     */
    public int deleteHealthSportFitnessById(Long id);
}
