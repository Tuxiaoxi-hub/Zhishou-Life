package zhishoulife.system.service;

import java.util.List;
import zhishoulife.system.domain.SafetyFoodStorage;

/**
 * 食品储存安全Service接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface ISafetyFoodStorageService 
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
     * 批量删除食品储存安全
     * 
     * @param ids 需要删除的食品储存安全主键集合
     * @return 结果
     */
    public int deleteSafetyFoodStorageByIds(Long[] ids);

    /**
     * 删除食品储存安全信息
     * 
     * @param id 食品储存安全主键
     * @return 结果
     */
    public int deleteSafetyFoodStorageById(Long id);
}
