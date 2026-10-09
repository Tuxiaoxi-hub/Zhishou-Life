package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.HealthMedicalProcess;

/**
 * 就医流程指南Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
public interface HealthMedicalProcessMapper 
{
    /**
     * 查询就医流程指南
     * 
     * @param id 就医流程指南主键
     * @return 就医流程指南
     */
    public HealthMedicalProcess selectHealthMedicalProcessById(Long id);

    /**
     * 查询就医流程指南列表
     * 
     * @param healthMedicalProcess 就医流程指南
     * @return 就医流程指南集合
     */
    public List<HealthMedicalProcess> selectHealthMedicalProcessList(HealthMedicalProcess healthMedicalProcess);

    /**
     * 新增就医流程指南
     * 
     * @param healthMedicalProcess 就医流程指南
     * @return 结果
     */
    public int insertHealthMedicalProcess(HealthMedicalProcess healthMedicalProcess);

    /**
     * 修改就医流程指南
     * 
     * @param healthMedicalProcess 就医流程指南
     * @return 结果
     */
    public int updateHealthMedicalProcess(HealthMedicalProcess healthMedicalProcess);

    /**
     * 删除就医流程指南
     * 
     * @param id 就医流程指南主键
     * @return 结果
     */
    public int deleteHealthMedicalProcessById(Long id);

    /**
     * 批量删除就医流程指南
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHealthMedicalProcessByIds(Long[] ids);
}
