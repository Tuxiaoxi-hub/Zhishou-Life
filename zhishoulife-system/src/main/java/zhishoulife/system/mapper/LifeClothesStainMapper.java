package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.LifeClothesStain;

/**
 * 污渍去除技巧Mapper接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface LifeClothesStainMapper 
{
    /**
     * 查询污渍去除技巧
     * 
     * @param id 污渍去除技巧主键
     * @return 污渍去除技巧
     */
    public LifeClothesStain selectLifeClothesStainById(Long id);

    /**
     * 查询污渍去除技巧列表
     * 
     * @param lifeClothesStain 污渍去除技巧
     * @return 污渍去除技巧集合
     */
    public List<LifeClothesStain> selectLifeClothesStainList(LifeClothesStain lifeClothesStain);

    /**
     * 新增污渍去除技巧
     * 
     * @param lifeClothesStain 污渍去除技巧
     * @return 结果
     */
    public int insertLifeClothesStain(LifeClothesStain lifeClothesStain);

    /**
     * 修改污渍去除技巧
     * 
     * @param lifeClothesStain 污渍去除技巧
     * @return 结果
     */
    public int updateLifeClothesStain(LifeClothesStain lifeClothesStain);

    /**
     * 删除污渍去除技巧
     * 
     * @param id 污渍去除技巧主键
     * @return 结果
     */
    public int deleteLifeClothesStainById(Long id);

    /**
     * 批量删除污渍去除技巧
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLifeClothesStainByIds(Long[] ids);
}
