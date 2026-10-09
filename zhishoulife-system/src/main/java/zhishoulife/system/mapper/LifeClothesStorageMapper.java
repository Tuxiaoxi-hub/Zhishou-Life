package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.LifeClothesStorage;

/**
 * 衣物收纳整理Mapper接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface LifeClothesStorageMapper 
{
    /**
     * 查询衣物收纳整理
     * 
     * @param id 衣物收纳整理主键
     * @return 衣物收纳整理
     */
    public LifeClothesStorage selectLifeClothesStorageById(Long id);

    /**
     * 查询衣物收纳整理列表
     * 
     * @param lifeClothesStorage 衣物收纳整理
     * @return 衣物收纳整理集合
     */
    public List<LifeClothesStorage> selectLifeClothesStorageList(LifeClothesStorage lifeClothesStorage);

    /**
     * 新增衣物收纳整理
     * 
     * @param lifeClothesStorage 衣物收纳整理
     * @return 结果
     */
    public int insertLifeClothesStorage(LifeClothesStorage lifeClothesStorage);

    /**
     * 修改衣物收纳整理
     * 
     * @param lifeClothesStorage 衣物收纳整理
     * @return 结果
     */
    public int updateLifeClothesStorage(LifeClothesStorage lifeClothesStorage);

    /**
     * 删除衣物收纳整理
     * 
     * @param id 衣物收纳整理主键
     * @return 结果
     */
    public int deleteLifeClothesStorageById(Long id);

    /**
     * 批量删除衣物收纳整理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLifeClothesStorageByIds(Long[] ids);
}
