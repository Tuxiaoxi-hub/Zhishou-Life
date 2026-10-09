package zhishoulife.system.service;

import java.util.List;
import zhishoulife.system.domain.HealthCheckup;

/**
 * 体检知识科普Service接口
 * 
 * @author admin
 * @date 2026-03-27
 */
public interface IHealthCheckupService 
{
    /**
     * 查询体检知识科普
     * 
     * @param id 体检知识科普主键
     * @return 体检知识科普
     */
    public HealthCheckup selectHealthCheckupById(Long id);

    /**
     * 查询体检知识科普列表
     * 
     * @param healthCheckup 体检知识科普
     * @return 体检知识科普集合
     */
    public List<HealthCheckup> selectHealthCheckupList(HealthCheckup healthCheckup);

    /**
     * 新增体检知识科普
     * 
     * @param healthCheckup 体检知识科普
     * @return 结果
     */
    public int insertHealthCheckup(HealthCheckup healthCheckup);

    /**
     * 修改体检知识科普
     * 
     * @param healthCheckup 体检知识科普
     * @return 结果
     */
    public int updateHealthCheckup(HealthCheckup healthCheckup);

    /**
     * 批量删除体检知识科普
     * 
     * @param ids 需要删除的体检知识科普主键集合
     * @return 结果
     */
    public int deleteHealthCheckupByIds(Long[] ids);

    /**
     * 删除体检知识科普信息
     * 
     * @param id 体检知识科普主键
     * @return 结果
     */
    public int deleteHealthCheckupById(Long id);
}
