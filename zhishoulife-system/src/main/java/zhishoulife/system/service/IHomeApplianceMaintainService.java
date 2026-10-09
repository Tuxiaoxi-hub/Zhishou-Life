package zhishoulife.system.service;

import java.util.List;
import zhishoulife.system.domain.HomeApplianceMaintain;

/**
 * 家电保养维护Service接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface IHomeApplianceMaintainService 
{
    /**
     * 查询家电保养维护
     * 
     * @param id 家电保养维护主键
     * @return 家电保养维护
     */
    public HomeApplianceMaintain selectHomeApplianceMaintainById(Long id);

    /**
     * 查询家电保养维护列表
     * 
     * @param homeApplianceMaintain 家电保养维护
     * @return 家电保养维护集合
     */
    public List<HomeApplianceMaintain> selectHomeApplianceMaintainList(HomeApplianceMaintain homeApplianceMaintain);

    /**
     * 新增家电保养维护
     * 
     * @param homeApplianceMaintain 家电保养维护
     * @return 结果
     */
    public int insertHomeApplianceMaintain(HomeApplianceMaintain homeApplianceMaintain);

    /**
     * 修改家电保养维护
     * 
     * @param homeApplianceMaintain 家电保养维护
     * @return 结果
     */
    public int updateHomeApplianceMaintain(HomeApplianceMaintain homeApplianceMaintain);

    /**
     * 批量删除家电保养维护
     * 
     * @param ids 需要删除的家电保养维护主键集合
     * @return 结果
     */
    public int deleteHomeApplianceMaintainByIds(Long[] ids);

    /**
     * 删除家电保养维护信息
     * 
     * @param id 家电保养维护主键
     * @return 结果
     */
    public int deleteHomeApplianceMaintainById(Long id);
}
