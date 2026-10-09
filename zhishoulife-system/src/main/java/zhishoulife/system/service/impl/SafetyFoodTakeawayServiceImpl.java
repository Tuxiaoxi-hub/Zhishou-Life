package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.SafetyFoodTakeawayMapper;
import zhishoulife.system.domain.SafetyFoodTakeaway;
import zhishoulife.system.service.ISafetyFoodTakeawayService;

/**
 * 外卖安全常识Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class SafetyFoodTakeawayServiceImpl implements ISafetyFoodTakeawayService 
{
    @Autowired
    private SafetyFoodTakeawayMapper safetyFoodTakeawayMapper;

    /**
     * 查询外卖安全常识
     * 
     * @param id 外卖安全常识主键
     * @return 外卖安全常识
     */
    @Override
    public SafetyFoodTakeaway selectSafetyFoodTakeawayById(Long id)
    {
        return safetyFoodTakeawayMapper.selectSafetyFoodTakeawayById(id);
    }

    /**
     * 查询外卖安全常识列表
     * 
     * @param safetyFoodTakeaway 外卖安全常识
     * @return 外卖安全常识
     */
    @Override
    public List<SafetyFoodTakeaway> selectSafetyFoodTakeawayList(SafetyFoodTakeaway safetyFoodTakeaway)
    {
        return safetyFoodTakeawayMapper.selectSafetyFoodTakeawayList(safetyFoodTakeaway);
    }

    /**
     * 新增外卖安全常识
     * 
     * @param safetyFoodTakeaway 外卖安全常识
     * @return 结果
     */
    @Override
    public int insertSafetyFoodTakeaway(SafetyFoodTakeaway safetyFoodTakeaway)
    {
        safetyFoodTakeaway.setCreateTime(DateUtils.getNowDate());
        return safetyFoodTakeawayMapper.insertSafetyFoodTakeaway(safetyFoodTakeaway);
    }

    /**
     * 修改外卖安全常识
     * 
     * @param safetyFoodTakeaway 外卖安全常识
     * @return 结果
     */
    @Override
    public int updateSafetyFoodTakeaway(SafetyFoodTakeaway safetyFoodTakeaway)
    {
        return safetyFoodTakeawayMapper.updateSafetyFoodTakeaway(safetyFoodTakeaway);
    }

    /**
     * 批量删除外卖安全常识
     * 
     * @param ids 需要删除的外卖安全常识主键
     * @return 结果
     */
    @Override
    public int deleteSafetyFoodTakeawayByIds(Long[] ids)
    {
        return safetyFoodTakeawayMapper.deleteSafetyFoodTakeawayByIds(ids);
    }

    /**
     * 删除外卖安全常识信息
     * 
     * @param id 外卖安全常识主键
     * @return 结果
     */
    @Override
    public int deleteSafetyFoodTakeawayById(Long id)
    {
        return safetyFoodTakeawayMapper.deleteSafetyFoodTakeawayById(id);
    }
}
