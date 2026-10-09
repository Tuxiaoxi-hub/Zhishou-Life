package zhishoulife.system.service;

import java.util.List;
import zhishoulife.system.domain.LifeClothesClean;

/**
 * 衣物清洗保养Service接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface ILifeClothesCleanService 
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
     * 批量删除衣物清洗保养
     * 
     * @param ids 需要删除的衣物清洗保养主键集合
     * @return 结果
     */
    public int deleteLifeClothesCleanByIds(Long[] ids);

    /**
     * 删除衣物清洗保养信息
     * 
     * @param id 衣物清洗保养主键
     * @return 结果
     */
    public int deleteLifeClothesCleanById(Long id);
}
