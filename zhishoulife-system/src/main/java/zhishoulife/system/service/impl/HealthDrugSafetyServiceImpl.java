package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.HealthDrugSafetyMapper;
import zhishoulife.system.domain.HealthDrugSafety;
import zhishoulife.system.service.IHealthDrugSafetyService;

/**
 * 药物安全Service业务层处理
 * 
 * @author admin
 * @date 2026-04-13
 */
@Service
public class HealthDrugSafetyServiceImpl implements IHealthDrugSafetyService 
{
    @Autowired
    private HealthDrugSafetyMapper healthDrugSafetyMapper;

    /**
     * 查询药物安全
     * 
     * @param id 药物安全主键
     * @return 药物安全
     */
    @Override
    public HealthDrugSafety selectHealthDrugSafetyById(Long id)
    {
        return healthDrugSafetyMapper.selectHealthDrugSafetyById(id);
    }

    /**
     * 查询药物安全列表
     * 
     * @param healthDrugSafety 药物安全
     * @return 药物安全
     */
    @Override
    public List<HealthDrugSafety> selectHealthDrugSafetyList(HealthDrugSafety healthDrugSafety)
    {
        return healthDrugSafetyMapper.selectHealthDrugSafetyList(healthDrugSafety);
    }

    /**
     * 新增药物安全
     * 
     * @param healthDrugSafety 药物安全
     * @return 结果
     */
    @Override
    public int insertHealthDrugSafety(HealthDrugSafety healthDrugSafety)
    {
        healthDrugSafety.setCreateTime(DateUtils.getNowDate());
        return healthDrugSafetyMapper.insertHealthDrugSafety(healthDrugSafety);
    }

    /**
     * 修改药物安全
     * 
     * @param healthDrugSafety 药物安全
     * @return 结果
     */
    @Override
    public int updateHealthDrugSafety(HealthDrugSafety healthDrugSafety)
    {
        return healthDrugSafetyMapper.updateHealthDrugSafety(healthDrugSafety);
    }

    /**
     * 批量删除药物安全
     * 
     * @param ids 需要删除的药物安全主键
     * @return 结果
     */
    @Override
    public int deleteHealthDrugSafetyByIds(Long[] ids)
    {
        return healthDrugSafetyMapper.deleteHealthDrugSafetyByIds(ids);
    }

    /**
     * 删除药物安全信息
     * 
     * @param id 药物安全主键
     * @return 结果
     */
    @Override
    public int deleteHealthDrugSafetyById(Long id)
    {
        return healthDrugSafetyMapper.deleteHealthDrugSafetyById(id);
    }
}
