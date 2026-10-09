package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.HealthTraumaTreatMapper;
import zhishoulife.system.domain.HealthTraumaTreat;
import zhishoulife.system.service.IHealthTraumaTreatService;

/**
 * 外伤应急处理Service业务层处理
 * 
 * @author admin
 * @date 2026-03-27
 */
@Service
public class HealthTraumaTreatServiceImpl implements IHealthTraumaTreatService 
{
    @Autowired
    private HealthTraumaTreatMapper healthTraumaTreatMapper;

    /**
     * 查询外伤应急处理
     * 
     * @param id 外伤应急处理主键
     * @return 外伤应急处理
     */
    @Override
    public HealthTraumaTreat selectHealthTraumaTreatById(Long id)
    {
        return healthTraumaTreatMapper.selectHealthTraumaTreatById(id);
    }

    /**
     * 查询外伤应急处理列表
     * 
     * @param healthTraumaTreat 外伤应急处理
     * @return 外伤应急处理
     */
    @Override
    public List<HealthTraumaTreat> selectHealthTraumaTreatList(HealthTraumaTreat healthTraumaTreat)
    {
        return healthTraumaTreatMapper.selectHealthTraumaTreatList(healthTraumaTreat);
    }

    /**
     * 新增外伤应急处理
     * 
     * @param healthTraumaTreat 外伤应急处理
     * @return 结果
     */
    @Override
    public int insertHealthTraumaTreat(HealthTraumaTreat healthTraumaTreat)
    {
        healthTraumaTreat.setCreateTime(DateUtils.getNowDate());
        return healthTraumaTreatMapper.insertHealthTraumaTreat(healthTraumaTreat);
    }

    /**
     * 修改外伤应急处理
     * 
     * @param healthTraumaTreat 外伤应急处理
     * @return 结果
     */
    @Override
    public int updateHealthTraumaTreat(HealthTraumaTreat healthTraumaTreat)
    {
        return healthTraumaTreatMapper.updateHealthTraumaTreat(healthTraumaTreat);
    }

    /**
     * 批量删除外伤应急处理
     * 
     * @param ids 需要删除的外伤应急处理主键
     * @return 结果
     */
    @Override
    public int deleteHealthTraumaTreatByIds(Long[] ids)
    {
        return healthTraumaTreatMapper.deleteHealthTraumaTreatByIds(ids);
    }

    /**
     * 删除外伤应急处理信息
     * 
     * @param id 外伤应急处理主键
     * @return 结果
     */
    @Override
    public int deleteHealthTraumaTreatById(Long id)
    {
        return healthTraumaTreatMapper.deleteHealthTraumaTreatById(id);
    }
}
