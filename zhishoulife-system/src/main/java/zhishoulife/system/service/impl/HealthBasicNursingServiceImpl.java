package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.HealthBasicNursingMapper;
import zhishoulife.system.domain.HealthBasicNursing;
import zhishoulife.system.service.IHealthBasicNursingService;

/**
 * 常见病症护理Service业务层处理
 * 
 * @author admin
 * @date 2026-03-27
 */
@Service
public class HealthBasicNursingServiceImpl implements IHealthBasicNursingService 
{
    @Autowired
    private HealthBasicNursingMapper healthBasicNursingMapper;

    /**
     * 查询常见病症护理
     * 
     * @param id 常见病症护理主键
     * @return 常见病症护理
     */
    @Override
    public HealthBasicNursing selectHealthBasicNursingById(Long id)
    {
        return healthBasicNursingMapper.selectHealthBasicNursingById(id);
    }

    /**
     * 查询常见病症护理列表
     * 
     * @param healthBasicNursing 常见病症护理
     * @return 常见病症护理
     */
    @Override
    public List<HealthBasicNursing> selectHealthBasicNursingList(HealthBasicNursing healthBasicNursing)
    {
        return healthBasicNursingMapper.selectHealthBasicNursingList(healthBasicNursing);
    }

    /**
     * 新增常见病症护理
     * 
     * @param healthBasicNursing 常见病症护理
     * @return 结果
     */
    @Override
    public int insertHealthBasicNursing(HealthBasicNursing healthBasicNursing)
    {
        healthBasicNursing.setCreateTime(DateUtils.getNowDate());
        return healthBasicNursingMapper.insertHealthBasicNursing(healthBasicNursing);
    }

    /**
     * 修改常见病症护理
     * 
     * @param healthBasicNursing 常见病症护理
     * @return 结果
     */
    @Override
    public int updateHealthBasicNursing(HealthBasicNursing healthBasicNursing)
    {
        return healthBasicNursingMapper.updateHealthBasicNursing(healthBasicNursing);
    }

    /**
     * 批量删除常见病症护理
     * 
     * @param ids 需要删除的常见病症护理主键
     * @return 结果
     */
    @Override
    public int deleteHealthBasicNursingByIds(Long[] ids)
    {
        return healthBasicNursingMapper.deleteHealthBasicNursingByIds(ids);
    }

    /**
     * 删除常见病症护理信息
     * 
     * @param id 常见病症护理主键
     * @return 结果
     */
    @Override
    public int deleteHealthBasicNursingById(Long id)
    {
        return healthBasicNursingMapper.deleteHealthBasicNursingById(id);
    }
}
