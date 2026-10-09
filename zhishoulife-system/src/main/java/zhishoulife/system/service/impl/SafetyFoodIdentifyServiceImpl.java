package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.SafetyFoodIdentifyMapper;
import zhishoulife.system.domain.SafetyFoodIdentify;
import zhishoulife.system.service.ISafetyFoodIdentifyService;

/**
 * 食品辨别技巧Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class SafetyFoodIdentifyServiceImpl implements ISafetyFoodIdentifyService 
{
    @Autowired
    private SafetyFoodIdentifyMapper safetyFoodIdentifyMapper;

    /**
     * 查询食品辨别技巧
     * 
     * @param id 食品辨别技巧主键
     * @return 食品辨别技巧
     */
    @Override
    public SafetyFoodIdentify selectSafetyFoodIdentifyById(Long id)
    {
        return safetyFoodIdentifyMapper.selectSafetyFoodIdentifyById(id);
    }

    /**
     * 查询食品辨别技巧列表
     * 
     * @param safetyFoodIdentify 食品辨别技巧
     * @return 食品辨别技巧
     */
    @Override
    public List<SafetyFoodIdentify> selectSafetyFoodIdentifyList(SafetyFoodIdentify safetyFoodIdentify)
    {
        return safetyFoodIdentifyMapper.selectSafetyFoodIdentifyList(safetyFoodIdentify);
    }

    /**
     * 新增食品辨别技巧
     * 
     * @param safetyFoodIdentify 食品辨别技巧
     * @return 结果
     */
    @Override
    public int insertSafetyFoodIdentify(SafetyFoodIdentify safetyFoodIdentify)
    {
        safetyFoodIdentify.setCreateTime(DateUtils.getNowDate());
        return safetyFoodIdentifyMapper.insertSafetyFoodIdentify(safetyFoodIdentify);
    }

    /**
     * 修改食品辨别技巧
     * 
     * @param safetyFoodIdentify 食品辨别技巧
     * @return 结果
     */
    @Override
    public int updateSafetyFoodIdentify(SafetyFoodIdentify safetyFoodIdentify)
    {
        return safetyFoodIdentifyMapper.updateSafetyFoodIdentify(safetyFoodIdentify);
    }

    /**
     * 批量删除食品辨别技巧
     * 
     * @param ids 需要删除的食品辨别技巧主键
     * @return 结果
     */
    @Override
    public int deleteSafetyFoodIdentifyByIds(Long[] ids)
    {
        return safetyFoodIdentifyMapper.deleteSafetyFoodIdentifyByIds(ids);
    }

    /**
     * 删除食品辨别技巧信息
     * 
     * @param id 食品辨别技巧主键
     * @return 结果
     */
    @Override
    public int deleteSafetyFoodIdentifyById(Long id)
    {
        return safetyFoodIdentifyMapper.deleteSafetyFoodIdentifyById(id);
    }
}
