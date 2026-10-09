package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.HealthDrugSafety;

/**
 * 药物安全Mapper接口
 * 
 * @author admin
 * @date 2026-04-13
 */
public interface HealthDrugSafetyMapper 
{
    /**
     * 查询药物安全
     * 
     * @param id 药物安全主键
     * @return 药物安全
     */
    public HealthDrugSafety selectHealthDrugSafetyById(Long id);

    /**
     * 查询药物安全列表
     * 
     * @param healthDrugSafety 药物安全
     * @return 药物安全集合
     */
    public List<HealthDrugSafety> selectHealthDrugSafetyList(HealthDrugSafety healthDrugSafety);

    /**
     * 新增药物安全
     * 
     * @param healthDrugSafety 药物安全
     * @return 结果
     */
    public int insertHealthDrugSafety(HealthDrugSafety healthDrugSafety);

    /**
     * 修改药物安全
     * 
     * @param healthDrugSafety 药物安全
     * @return 结果
     */
    public int updateHealthDrugSafety(HealthDrugSafety healthDrugSafety);

    /**
     * 删除药物安全
     * 
     * @param id 药物安全主键
     * @return 结果
     */
    public int deleteHealthDrugSafetyById(Long id);

    /**
     * 批量删除药物安全
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHealthDrugSafetyByIds(Long[] ids);
}
