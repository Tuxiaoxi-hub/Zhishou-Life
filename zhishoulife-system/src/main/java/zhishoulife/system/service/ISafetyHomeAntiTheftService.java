package zhishoulife.system.service;

import java.util.List;
import zhishoulife.system.domain.SafetyHomeAntiTheft;

/**
 * 防盗防入侵Service接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface ISafetyHomeAntiTheftService 
{
    /**
     * 查询防盗防入侵
     * 
     * @param id 防盗防入侵主键
     * @return 防盗防入侵
     */
    public SafetyHomeAntiTheft selectSafetyHomeAntiTheftById(Long id);

    /**
     * 查询防盗防入侵列表
     * 
     * @param safetyHomeAntiTheft 防盗防入侵
     * @return 防盗防入侵集合
     */
    public List<SafetyHomeAntiTheft> selectSafetyHomeAntiTheftList(SafetyHomeAntiTheft safetyHomeAntiTheft);

    /**
     * 新增防盗防入侵
     * 
     * @param safetyHomeAntiTheft 防盗防入侵
     * @return 结果
     */
    public int insertSafetyHomeAntiTheft(SafetyHomeAntiTheft safetyHomeAntiTheft);

    /**
     * 修改防盗防入侵
     * 
     * @param safetyHomeAntiTheft 防盗防入侵
     * @return 结果
     */
    public int updateSafetyHomeAntiTheft(SafetyHomeAntiTheft safetyHomeAntiTheft);

    /**
     * 批量删除防盗防入侵
     * 
     * @param ids 需要删除的防盗防入侵主键集合
     * @return 结果
     */
    public int deleteSafetyHomeAntiTheftByIds(Long[] ids);

    /**
     * 删除防盗防入侵信息
     * 
     * @param id 防盗防入侵主键
     * @return 结果
     */
    public int deleteSafetyHomeAntiTheftById(Long id);
}
