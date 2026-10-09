package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.LifeClothesClean;

/**
 * 衣物清洗保养Mapper接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface LifeClothesCleanMapper 
{
    /**
     * 查询衣物清洗保养
     * 
     * @param id 衣物清洗保养主键
     * @return 衣物清洗保养
     */
    public LifeClothesClean selectLifeClothesCleanById(Long id);

    /**
     * 查询衣物清洗保养列表
     * 
     * @param lifeClothesClean 衣物清洗保养
     * @return 衣物清洗保养集合
     */
    public List<LifeClothesClean> selectLifeClothesCleanList(LifeClothesClean lifeClothesClean);

    /**
     * 新增衣物清洗保养
     * 
     * @param lifeClothesClean 衣物清洗保养
     * @return 结果
     */
    public int insertLifeClothesClean(LifeClothesClean lifeClothesClean);

    /**
     * 修改衣物清洗保养
     * 
     * @param lifeClothesClean 衣物清洗保养
     * @return 结果
     */
    public int updateLifeClothesClean(LifeClothesClean lifeClothesClean);

    /**
     * 删除衣物清洗保养
     * 
     * @param id 衣物清洗保养主键
     * @return 结果
     */
    public int deleteLifeClothesCleanById(Long id);

    /**
     * 批量删除衣物清洗保养
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLifeClothesCleanByIds(Long[] ids);
}
