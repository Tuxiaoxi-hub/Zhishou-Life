package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.HealthMedicalProcessMapper;
import zhishoulife.system.domain.HealthMedicalProcess;
import zhishoulife.system.service.IHealthMedicalProcessService;

/**
 * 就医流程指南Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
@Service
public class HealthMedicalProcessServiceImpl implements IHealthMedicalProcessService 
{
    @Autowired
    private HealthMedicalProcessMapper healthMedicalProcessMapper;

    /**
     * 查询就医流程指南
     * 
     * @param id 就医流程指南主键
     * @return 就医流程指南
     */
    @Override
    public HealthMedicalProcess selectHealthMedicalProcessById(Long id)
    {
        return healthMedicalProcessMapper.selectHealthMedicalProcessById(id);
    }

    /**
     * 查询就医流程指南列表
     * 
     * @param healthMedicalProcess 就医流程指南
     * @return 就医流程指南
     */
    @Override
    public List<HealthMedicalProcess> selectHealthMedicalProcessList(HealthMedicalProcess healthMedicalProcess)
    {
        return healthMedicalProcessMapper.selectHealthMedicalProcessList(healthMedicalProcess);
    }

    /**
     * 新增就医流程指南
     * 
     * @param healthMedicalProcess 就医流程指南
     * @return 结果
     */
    @Override
    public int insertHealthMedicalProcess(HealthMedicalProcess healthMedicalProcess)
    {
        healthMedicalProcess.setCreateTime(DateUtils.getNowDate());
        return healthMedicalProcessMapper.insertHealthMedicalProcess(healthMedicalProcess);
    }

    /**
     * 修改就医流程指南
     * 
     * @param healthMedicalProcess 就医流程指南
     * @return 结果
     */
    @Override
    public int updateHealthMedicalProcess(HealthMedicalProcess healthMedicalProcess)
    {
        return healthMedicalProcessMapper.updateHealthMedicalProcess(healthMedicalProcess);
    }

    /**
     * 批量删除就医流程指南
     * 
     * @param ids 需要删除的就医流程指南主键
     * @return 结果
     */
    @Override
    public int deleteHealthMedicalProcessByIds(Long[] ids)
    {
        return healthMedicalProcessMapper.deleteHealthMedicalProcessByIds(ids);
    }

    /**
     * 删除就医流程指南信息
     * 
     * @param id 就医流程指南主键
     * @return 结果
     */
    @Override
    public int deleteHealthMedicalProcessById(Long id)
    {
        return healthMedicalProcessMapper.deleteHealthMedicalProcessById(id);
    }
}
