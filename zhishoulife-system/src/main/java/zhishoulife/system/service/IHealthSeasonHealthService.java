package zhishoulife.system.service;

import java.util.List;
import zhishoulife.system.domain.HealthSeasonHealth;

/**
 * 四季养生常识Service接口
 * 
 * @author admin
 * @date 2026-03-27
 */
public interface IHealthSeasonHealthService 
{
    /**
     * 查询四季养生常识
     * 
     * @param id 四季养生常识主键
     * @return 四季养生常识
     */
    public HealthSeasonHealth selectHealthSeasonHealthById(Long id);

    /**
     * 查询四季养生常识列表
     * 
     * @param healthSeasonHealth 四季养生常识
     * @return 四季养生常识集合
     */
    public List<HealthSeasonHealth> selectHealthSeasonHealthList(HealthSeasonHealth healthSeasonHealth);

    /**
     * 新增四季养生常识
     * 
     * @param healthSeasonHealth 四季养生常识
     * @return 结果
     */
    public int insertHealthSeasonHealth(HealthSeasonHealth healthSeasonHealth);

    /**
     * 修改四季养生常识
     * 
     * @param healthSeasonHealth 四季养生常识
     * @return 结果
     */
    public int updateHealthSeasonHealth(HealthSeasonHealth healthSeasonHealth);

    /**
     * 批量删除四季养生常识
     * 
     * @param ids 需要删除的四季养生常识主键集合
     * @return 结果
     */
    public int deleteHealthSeasonHealthByIds(Long[] ids);

    /**
     * 删除四季养生常识信息
     * 
     * @param id 四季养生常识主键
     * @return 结果
     */
    public int deleteHealthSeasonHealthById(Long id);
}
