package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.HomeApplianceMaintainMapper;
import zhishoulife.system.domain.HomeApplianceMaintain;
import zhishoulife.system.service.IHomeApplianceMaintainService;

/**
 * 家电保养维护Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class HomeApplianceMaintainServiceImpl implements IHomeApplianceMaintainService 
{
    @Autowired
    private HomeApplianceMaintainMapper homeApplianceMaintainMapper;

    /**
     * 查询家电保养维护
     * 
     * @param id 家电保养维护主键
     * @return 家电保养维护
     */
    @Override
    public HomeApplianceMaintain selectHomeApplianceMaintainById(Long id)
    {
        return homeApplianceMaintainMapper.selectHomeApplianceMaintainById(id);
    }

    /**
     * 查询家电保养维护列表
     * 
     * @param homeApplianceMaintain 家电保养维护
     * @return 家电保养维护
     */
    @Override
    public List<HomeApplianceMaintain> selectHomeApplianceMaintainList(HomeApplianceMaintain homeApplianceMaintain)
    {
        return homeApplianceMaintainMapper.selectHomeApplianceMaintainList(homeApplianceMaintain);
    }

    /**
     * 新增家电保养维护
     * 
     * @param homeApplianceMaintain 家电保养维护
     * @return 结果
     */
    @Override
    public int insertHomeApplianceMaintain(HomeApplianceMaintain homeApplianceMaintain)
    {
        homeApplianceMaintain.setCreateTime(DateUtils.getNowDate());
        return homeApplianceMaintainMapper.insertHomeApplianceMaintain(homeApplianceMaintain);
    }

    /**
     * 修改家电保养维护
     * 
     * @param homeApplianceMaintain 家电保养维护
     * @return 结果
     */
    @Override
    public int updateHomeApplianceMaintain(HomeApplianceMaintain homeApplianceMaintain)
    {
        return homeApplianceMaintainMapper.updateHomeApplianceMaintain(homeApplianceMaintain);
    }

    /**
     * 批量删除家电保养维护
     * 
     * @param ids 需要删除的家电保养维护主键
     * @return 结果
     */
    @Override
    public int deleteHomeApplianceMaintainByIds(Long[] ids)
    {
        return homeApplianceMaintainMapper.deleteHomeApplianceMaintainByIds(ids);
    }

    /**
     * 删除家电保养维护信息
     * 
     * @param id 家电保养维护主键
     * @return 结果
     */
    @Override
    public int deleteHomeApplianceMaintainById(Long id)
    {
        return homeApplianceMaintainMapper.deleteHomeApplianceMaintainById(id);
    }
}
