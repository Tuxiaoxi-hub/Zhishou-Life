package zhishoulife.system.service;

import java.util.List;
import zhishoulife.system.domain.LifeFoodCook;

/**
 * 家常菜烹饪Service接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface ILifeFoodCookService 
{
    /**
     * 查询家常菜烹饪
     * 
     * @param id 家常菜烹饪主键
     * @return 家常菜烹饪
     */
    public LifeFoodCook selectLifeFoodCookById(Long id);

    /**
     * 查询家常菜烹饪列表
     * 
     * @param lifeFoodCook 家常菜烹饪
     * @return 家常菜烹饪集合
     */
    public List<LifeFoodCook> selectLifeFoodCookList(LifeFoodCook lifeFoodCook);

    /**
     * 新增家常菜烹饪
     * 
     * @param lifeFoodCook 家常菜烹饪
     * @return 结果
     */
    public int insertLifeFoodCook(LifeFoodCook lifeFoodCook);

    /**
     * 修改家常菜烹饪
     * 
     * @param lifeFoodCook 家常菜烹饪
     * @return 结果
     */
    public int updateLifeFoodCook(LifeFoodCook lifeFoodCook);

    /**
     * 批量删除家常菜烹饪
     * 
     * @param ids 需要删除的家常菜烹饪主键集合
     * @return 结果
     */
    public int deleteLifeFoodCookByIds(Long[] ids);

    /**
     * 删除家常菜烹饪信息
     * 
     * @param id 家常菜烹饪主键
     * @return 结果
     */
    public int deleteLifeFoodCookById(Long id);
}
