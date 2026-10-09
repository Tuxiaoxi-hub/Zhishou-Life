package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.SafetyHomeFireElectric;

/**
 * 用火用电安全Mapper接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface SafetyHomeFireElectricMapper 
{
    /**
     * 查询用火用电安全
     * 
     * @param id 用火用电安全主键
     * @return 用火用电安全
     */
    public SafetyHomeFireElectric selectSafetyHomeFireElectricById(Long id);

    /**
     * 查询用火用电安全列表
     * 
     * @param safetyHomeFireElectric 用火用电安全
     * @return 用火用电安全集合
     */
    public List<SafetyHomeFireElectric> selectSafetyHomeFireElectricList(SafetyHomeFireElectric safetyHomeFireElectric);

    /**
     * 新增用火用电安全
     * 
     * @param safetyHomeFireElectric 用火用电安全
     * @return 结果
     */
    public int insertSafetyHomeFireElectric(SafetyHomeFireElectric safetyHomeFireElectric);

    /**
     * 修改用火用电安全
     * 
     * @param safetyHomeFireElectric 用火用电安全
     * @return 结果
     */
    public int updateSafetyHomeFireElectric(SafetyHomeFireElectric safetyHomeFireElectric);

    /**
     * 删除用火用电安全
     * 
     * @param id 用火用电安全主键
     * @return 结果
     */
    public int deleteSafetyHomeFireElectricById(Long id);

    /**
     * 批量删除用火用电安全
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSafetyHomeFireElectricByIds(Long[] ids);
}
