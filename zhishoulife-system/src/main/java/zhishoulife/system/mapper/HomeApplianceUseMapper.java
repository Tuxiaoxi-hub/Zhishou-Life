package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.HomeApplianceUse;

/**
 * 家电操作技巧Mapper接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface HomeApplianceUseMapper 
{
    /**
     * 查询家电操作技巧
     * 
     * @param id 家电操作技巧主键
     * @return 家电操作技巧
     */
    public HomeApplianceUse selectHomeApplianceUseById(Long id);

    /**
     * 查询家电操作技巧列表
     * 
     * @param homeApplianceUse 家电操作技巧
     * @return 家电操作技巧集合
     */
    public List<HomeApplianceUse> selectHomeApplianceUseList(HomeApplianceUse homeApplianceUse);

    /**
     * 新增家电操作技巧
     * 
     * @param homeApplianceUse 家电操作技巧
     * @return 结果
     */
    public int insertHomeApplianceUse(HomeApplianceUse homeApplianceUse);

    /**
     * 修改家电操作技巧
     * 
     * @param homeApplianceUse 家电操作技巧
     * @return 结果
     */
    public int updateHomeApplianceUse(HomeApplianceUse homeApplianceUse);

    /**
     * 删除家电操作技巧
     * 
     * @param id 家电操作技巧主键
     * @return 结果
     */
    public int deleteHomeApplianceUseById(Long id);

    /**
     * 批量删除家电操作技巧
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHomeApplianceUseByIds(Long[] ids);
}
