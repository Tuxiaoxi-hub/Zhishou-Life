package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.SafetyFoodStorage;

/**
 * 食品储存安全Mapper接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface SafetyFoodStorageMapper 
{
    /**
     * 查询食品储存安全
     * 
     * @param id 食品储存安全主键
     * @return 食品储存安全
     */
    public SafetyFoodStorage selectSafetyFoodStorageById(Long id);

    /**
     * 查询食品储存安全列表
     * 
     * @param safetyFoodStorage 食品储存安全
     * @return 食品储存安全集合
     */
    public List<SafetyFoodStorage> selectSafetyFoodStorageList(SafetyFoodStorage safetyFoodStorage);

    /**
     * 新增食品储存安全
     * 
     * @param safetyFoodStorage 食品储存安全
     * @return 结果
     */
    public int insertSafetyFoodStorage(SafetyFoodStorage safetyFoodStorage);

    /**
     * 修改食品储存安全
     * 
     * @param safetyFoodStorage 食品储存安全
     * @return 结果
     */
    public int updateSafetyFoodStorage(SafetyFoodStorage safetyFoodStorage);

    /**
     * 删除食品储存安全
     * 
     * @param id 食品储存安全主键
     * @return 结果
     */
    public int deleteSafetyFoodStorageById(Long id);

    /**
     * 批量删除食品储存安全
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSafetyFoodStorageByIds(Long[] ids);
}
