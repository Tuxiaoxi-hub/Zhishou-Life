package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.SafetyFoodIdentify;

/**
 * 食品辨别技巧Mapper接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface SafetyFoodIdentifyMapper 
{
    /**
     * 查询食品辨别技巧
     * 
     * @param id 食品辨别技巧主键
     * @return 食品辨别技巧
     */
    public SafetyFoodIdentify selectSafetyFoodIdentifyById(Long id);

    /**
     * 查询食品辨别技巧列表
     * 
     * @param safetyFoodIdentify 食品辨别技巧
     * @return 食品辨别技巧集合
     */
    public List<SafetyFoodIdentify> selectSafetyFoodIdentifyList(SafetyFoodIdentify safetyFoodIdentify);

    /**
     * 新增食品辨别技巧
     * 
     * @param safetyFoodIdentify 食品辨别技巧
     * @return 结果
     */
    public int insertSafetyFoodIdentify(SafetyFoodIdentify safetyFoodIdentify);

    /**
     * 修改食品辨别技巧
     * 
     * @param safetyFoodIdentify 食品辨别技巧
     * @return 结果
     */
    public int updateSafetyFoodIdentify(SafetyFoodIdentify safetyFoodIdentify);

    /**
     * 删除食品辨别技巧
     * 
     * @param id 食品辨别技巧主键
     * @return 结果
     */
    public int deleteSafetyFoodIdentifyById(Long id);

    /**
     * 批量删除食品辨别技巧
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSafetyFoodIdentifyByIds(Long[] ids);
}
