package zhishoulife.system.service;

import java.util.List;
import zhishoulife.system.domain.SafetyFoodTakeaway;

/**
 * 外卖安全常识Service接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface ISafetyFoodTakeawayService 
{
    /**
     * 查询外卖安全常识
     * 
     * @param id 外卖安全常识主键
     * @return 外卖安全常识
     */
    public SafetyFoodTakeaway selectSafetyFoodTakeawayById(Long id);

    /**
     * 查询外卖安全常识列表
     * 
     * @param safetyFoodTakeaway 外卖安全常识
     * @return 外卖安全常识集合
     */
    public List<SafetyFoodTakeaway> selectSafetyFoodTakeawayList(SafetyFoodTakeaway safetyFoodTakeaway);

    /**
     * 新增外卖安全常识
     * 
     * @param safetyFoodTakeaway 外卖安全常识
     * @return 结果
     */
    public int insertSafetyFoodTakeaway(SafetyFoodTakeaway safetyFoodTakeaway);

    /**
     * 修改外卖安全常识
     * 
     * @param safetyFoodTakeaway 外卖安全常识
     * @return 结果
     */
    public int updateSafetyFoodTakeaway(SafetyFoodTakeaway safetyFoodTakeaway);

    /**
     * 批量删除外卖安全常识
     * 
     * @param ids 需要删除的外卖安全常识主键集合
     * @return 结果
     */
    public int deleteSafetyFoodTakeawayByIds(Long[] ids);

    /**
     * 删除外卖安全常识信息
     * 
     * @param id 外卖安全常识主键
     * @return 结果
     */
    public int deleteSafetyFoodTakeawayById(Long id);
}
