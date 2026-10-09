package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.LifeFoodSelect;

/**
 * 食材挑选与保存Mapper接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface LifeFoodSelectMapper 
{
    /**
     * 查询食材挑选与保存
     * 
     * @param id 食材挑选与保存主键
     * @return 食材挑选与保存
     */
    public LifeFoodSelect selectLifeFoodSelectById(Long id);

    /**
     * 查询食材挑选与保存列表
     * 
     * @param lifeFoodSelect 食材挑选与保存
     * @return 食材挑选与保存集合
     */
    public List<LifeFoodSelect> selectLifeFoodSelectList(LifeFoodSelect lifeFoodSelect);

    /**
     * 新增食材挑选与保存
     * 
     * @param lifeFoodSelect 食材挑选与保存
     * @return 结果
     */
    public int insertLifeFoodSelect(LifeFoodSelect lifeFoodSelect);

    /**
     * 修改食材挑选与保存
     * 
     * @param lifeFoodSelect 食材挑选与保存
     * @return 结果
     */
    public int updateLifeFoodSelect(LifeFoodSelect lifeFoodSelect);

    /**
     * 删除食材挑选与保存
     * 
     * @param id 食材挑选与保存主键
     * @return 结果
     */
    public int deleteLifeFoodSelectById(Long id);

    /**
     * 批量删除食材挑选与保存
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLifeFoodSelectByIds(Long[] ids);
}
