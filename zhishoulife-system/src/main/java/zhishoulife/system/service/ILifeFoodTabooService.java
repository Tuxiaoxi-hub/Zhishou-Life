package zhishoulife.system.service;

import java.util.List;
import zhishoulife.system.domain.LifeFoodTaboo;

/**
 * 饮食禁忌与搭配Service接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface ILifeFoodTabooService 
{
    /**
     * 查询饮食禁忌与搭配
     * 
     * @param id 饮食禁忌与搭配主键
     * @return 饮食禁忌与搭配
     */
    public LifeFoodTaboo selectLifeFoodTabooById(Long id);

    /**
     * 查询饮食禁忌与搭配列表
     * 
     * @param lifeFoodTaboo 饮食禁忌与搭配
     * @return 饮食禁忌与搭配集合
     */
    public List<LifeFoodTaboo> selectLifeFoodTabooList(LifeFoodTaboo lifeFoodTaboo);

    /**
     * 新增饮食禁忌与搭配
     * 
     * @param lifeFoodTaboo 饮食禁忌与搭配
     * @return 结果
     */
    public int insertLifeFoodTaboo(LifeFoodTaboo lifeFoodTaboo);

    /**
     * 修改饮食禁忌与搭配
     * 
     * @param lifeFoodTaboo 饮食禁忌与搭配
     * @return 结果
     */
    public int updateLifeFoodTaboo(LifeFoodTaboo lifeFoodTaboo);

    /**
     * 批量删除饮食禁忌与搭配
     * 
     * @param ids 需要删除的饮食禁忌与搭配主键集合
     * @return 结果
     */
    public int deleteLifeFoodTabooByIds(Long[] ids);

    /**
     * 删除饮食禁忌与搭配信息
     * 
     * @param id 饮食禁忌与搭配主键
     * @return 结果
     */
    public int deleteLifeFoodTabooById(Long id);
}
