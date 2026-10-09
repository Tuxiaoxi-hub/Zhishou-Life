package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.HealthCheckupMapper;
import zhishoulife.system.domain.HealthCheckup;
import zhishoulife.system.service.IHealthCheckupService;

/**
 * 体检知识科普Service业务层处理
 * 
 * @author admin
 * @date 2026-03-27
 */
@Service
public class HealthCheckupServiceImpl implements IHealthCheckupService 
{
    @Autowired
    private HealthCheckupMapper healthCheckupMapper;

    /**
     * 查询体检知识科普
     * 
     * @param id 体检知识科普主键
     * @return 体检知识科普
     */
    @Override
    public HealthCheckup selectHealthCheckupById(Long id)
    {
        return healthCheckupMapper.selectHealthCheckupById(id);
    }

    /**
     * 查询体检知识科普列表
     * 
     * @param healthCheckup 体检知识科普
     * @return 体检知识科普
     */
    @Override
    public List<HealthCheckup> selectHealthCheckupList(HealthCheckup healthCheckup)
    {
        return healthCheckupMapper.selectHealthCheckupList(healthCheckup);
    }

    /**
     * 新增体检知识科普
     * 
     * @param healthCheckup 体检知识科普
     * @return 结果
     */
    @Override
    public int insertHealthCheckup(HealthCheckup healthCheckup)
    {
        healthCheckup.setCreateTime(DateUtils.getNowDate());
        return healthCheckupMapper.insertHealthCheckup(healthCheckup);
    }

    /**
     * 修改体检知识科普
     * 
     * @param healthCheckup 体检知识科普
     * @return 结果
     */
    @Override
    public int updateHealthCheckup(HealthCheckup healthCheckup)
    {
        return healthCheckupMapper.updateHealthCheckup(healthCheckup);
    }

    /**
     * 批量删除体检知识科普
     * 
     * @param ids 需要删除的体检知识科普主键
     * @return 结果
     */
    @Override
    public int deleteHealthCheckupByIds(Long[] ids)
    {
        return healthCheckupMapper.deleteHealthCheckupByIds(ids);
    }

    /**
     * 删除体检知识科普信息
     * 
     * @param id 体检知识科普主键
     * @return 结果
     */
    @Override
    public int deleteHealthCheckupById(Long id)
    {
        return healthCheckupMapper.deleteHealthCheckupById(id);
    }
}
