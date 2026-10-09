package zhishoulife.system.service;

import java.util.List;
import zhishoulife.system.domain.HealthFirstAid;

/**
 * 常见急救方法Service接口
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
public interface IHealthFirstAidService 
{
    /**
     * 查询常见急救方法
     * 
     * @param id 常见急救方法主键
     * @return 常见急救方法
     */
    public HealthFirstAid selectHealthFirstAidById(Long id);

    /**
     * 查询常见急救方法列表
     * 
     * @param healthFirstAid 常见急救方法
     * @return 常见急救方法集合
     */
    public List<HealthFirstAid> selectHealthFirstAidList(HealthFirstAid healthFirstAid);

    /**
     * 新增常见急救方法
     * 
     * @param healthFirstAid 常见急救方法
     * @return 结果
     */
    public int insertHealthFirstAid(HealthFirstAid healthFirstAid);

    /**
     * 修改常见急救方法
     * 
     * @param healthFirstAid 常见急救方法
     * @return 结果
     */
    public int updateHealthFirstAid(HealthFirstAid healthFirstAid);

    /**
     * 批量删除常见急救方法
     * 
     * @param ids 需要删除的常见急救方法主键集合
     * @return 结果
     */
    public int deleteHealthFirstAidByIds(Long[] ids);

    /**
     * 删除常见急救方法信息
     * 
     * @param id 常见急救方法主键
     * @return 结果
     */
    public int deleteHealthFirstAidById(Long id);
}
