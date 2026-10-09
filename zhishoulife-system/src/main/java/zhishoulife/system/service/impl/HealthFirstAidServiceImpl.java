package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.HealthFirstAidMapper;
import zhishoulife.system.domain.HealthFirstAid;
import zhishoulife.system.service.IHealthFirstAidService;

/**
 * 常见急救方法Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
@Service
public class HealthFirstAidServiceImpl implements IHealthFirstAidService 
{
    @Autowired
    private HealthFirstAidMapper healthFirstAidMapper;

    /**
     * 查询常见急救方法
     * 
     * @param id 常见急救方法主键
     * @return 常见急救方法
     */
    @Override
    public HealthFirstAid selectHealthFirstAidById(Long id)
    {
        return healthFirstAidMapper.selectHealthFirstAidById(id);
    }

    /**
     * 查询常见急救方法列表
     * 
     * @param healthFirstAid 常见急救方法
     * @return 常见急救方法
     */
    @Override
    public List<HealthFirstAid> selectHealthFirstAidList(HealthFirstAid healthFirstAid)
    {
        return healthFirstAidMapper.selectHealthFirstAidList(healthFirstAid);
    }

    /**
     * 新增常见急救方法
     * 
     * @param healthFirstAid 常见急救方法
     * @return 结果
     */
    @Override
    public int insertHealthFirstAid(HealthFirstAid healthFirstAid)
    {
        healthFirstAid.setCreateTime(DateUtils.getNowDate());
        return healthFirstAidMapper.insertHealthFirstAid(healthFirstAid);
    }

    /**
     * 修改常见急救方法
     * 
     * @param healthFirstAid 常见急救方法
     * @return 结果
     */
    @Override
    public int updateHealthFirstAid(HealthFirstAid healthFirstAid)
    {
        return healthFirstAidMapper.updateHealthFirstAid(healthFirstAid);
    }

    /**
     * 批量删除常见急救方法
     * 
     * @param ids 需要删除的常见急救方法主键
     * @return 结果
     */
    @Override
    public int deleteHealthFirstAidByIds(Long[] ids)
    {
        return healthFirstAidMapper.deleteHealthFirstAidByIds(ids);
    }

    /**
     * 删除常见急救方法信息
     * 
     * @param id 常见急救方法主键
     * @return 结果
     */
    @Override
    public int deleteHealthFirstAidById(Long id)
    {
        return healthFirstAidMapper.deleteHealthFirstAidById(id);
    }
}
