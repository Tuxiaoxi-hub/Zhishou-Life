package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.SafetyFoodStorageMapper;
import zhishoulife.system.domain.SafetyFoodStorage;
import zhishoulife.system.service.ISafetyFoodStorageService;

/**
 * 食品储存安全Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class SafetyFoodStorageServiceImpl implements ISafetyFoodStorageService 
{
    @Autowired
    private SafetyFoodStorageMapper safetyFoodStorageMapper;

    /**
     * 查询食品储存安全
     * 
     * @param id 食品储存安全主键
     * @return 食品储存安全
     */
    @Override
    public SafetyFoodStorage selectSafetyFoodStorageById(Long id)
    {
        return safetyFoodStorageMapper.selectSafetyFoodStorageById(id);
    }

    /**
     * 查询食品储存安全列表
     * 
     * @param safetyFoodStorage 食品储存安全
     * @return 食品储存安全
     */
    @Override
    public List<SafetyFoodStorage> selectSafetyFoodStorageList(SafetyFoodStorage safetyFoodStorage)
    {
        return safetyFoodStorageMapper.selectSafetyFoodStorageList(safetyFoodStorage);
    }

    /**
     * 新增食品储存安全
     * 
     * @param safetyFoodStorage 食品储存安全
     * @return 结果
     */
    @Override
    public int insertSafetyFoodStorage(SafetyFoodStorage safetyFoodStorage)
    {
        safetyFoodStorage.setCreateTime(DateUtils.getNowDate());
        return safetyFoodStorageMapper.insertSafetyFoodStorage(safetyFoodStorage);
    }

    /**
     * 修改食品储存安全
     * 
     * @param safetyFoodStorage 食品储存安全
     * @return 结果
     */
    @Override
    public int updateSafetyFoodStorage(SafetyFoodStorage safetyFoodStorage)
    {
        return safetyFoodStorageMapper.updateSafetyFoodStorage(safetyFoodStorage);
    }

    /**
     * 批量删除食品储存安全
     * 
     * @param ids 需要删除的食品储存安全主键
     * @return 结果
     */
    @Override
    public int deleteSafetyFoodStorageByIds(Long[] ids)
    {
        return safetyFoodStorageMapper.deleteSafetyFoodStorageByIds(ids);
    }

    /**
     * 删除食品储存安全信息
     * 
     * @param id 食品储存安全主键
     * @return 结果
     */
    @Override
    public int deleteSafetyFoodStorageById(Long id)
    {
        return safetyFoodStorageMapper.deleteSafetyFoodStorageById(id);
    }
}
