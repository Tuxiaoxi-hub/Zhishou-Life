package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.SafetyHomeFireElectricMapper;
import zhishoulife.system.domain.SafetyHomeFireElectric;
import zhishoulife.system.service.ISafetyHomeFireElectricService;

/**
 * 用火用电安全Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class SafetyHomeFireElectricServiceImpl implements ISafetyHomeFireElectricService 
{
    @Autowired
    private SafetyHomeFireElectricMapper safetyHomeFireElectricMapper;

    /**
     * 查询用火用电安全
     * 
     * @param id 用火用电安全主键
     * @return 用火用电安全
     */
    @Override
    public SafetyHomeFireElectric selectSafetyHomeFireElectricById(Long id)
    {
        return safetyHomeFireElectricMapper.selectSafetyHomeFireElectricById(id);
    }

    /**
     * 查询用火用电安全列表
     * 
     * @param safetyHomeFireElectric 用火用电安全
     * @return 用火用电安全
     */
    @Override
    public List<SafetyHomeFireElectric> selectSafetyHomeFireElectricList(SafetyHomeFireElectric safetyHomeFireElectric)
    {
        return safetyHomeFireElectricMapper.selectSafetyHomeFireElectricList(safetyHomeFireElectric);
    }

    /**
     * 新增用火用电安全
     * 
     * @param safetyHomeFireElectric 用火用电安全
     * @return 结果
     */
    @Override
    public int insertSafetyHomeFireElectric(SafetyHomeFireElectric safetyHomeFireElectric)
    {
        safetyHomeFireElectric.setCreateTime(DateUtils.getNowDate());
        return safetyHomeFireElectricMapper.insertSafetyHomeFireElectric(safetyHomeFireElectric);
    }

    /**
     * 修改用火用电安全
     * 
     * @param safetyHomeFireElectric 用火用电安全
     * @return 结果
     */
    @Override
    public int updateSafetyHomeFireElectric(SafetyHomeFireElectric safetyHomeFireElectric)
    {
        return safetyHomeFireElectricMapper.updateSafetyHomeFireElectric(safetyHomeFireElectric);
    }

    /**
     * 批量删除用火用电安全
     * 
     * @param ids 需要删除的用火用电安全主键
     * @return 结果
     */
    @Override
    public int deleteSafetyHomeFireElectricByIds(Long[] ids)
    {
        return safetyHomeFireElectricMapper.deleteSafetyHomeFireElectricByIds(ids);
    }

    /**
     * 删除用火用电安全信息
     * 
     * @param id 用火用电安全主键
     * @return 结果
     */
    @Override
    public int deleteSafetyHomeFireElectricById(Long id)
    {
        return safetyHomeFireElectricMapper.deleteSafetyHomeFireElectricById(id);
    }
}
