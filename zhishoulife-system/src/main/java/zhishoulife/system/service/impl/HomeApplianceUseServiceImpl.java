package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.HomeApplianceUseMapper;
import zhishoulife.system.domain.HomeApplianceUse;
import zhishoulife.system.service.IHomeApplianceUseService;

/**
 * 家电操作技巧Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class HomeApplianceUseServiceImpl implements IHomeApplianceUseService 
{
    @Autowired
    private HomeApplianceUseMapper homeApplianceUseMapper;

    /**
     * 查询家电操作技巧
     * 
     * @param id 家电操作技巧主键
     * @return 家电操作技巧
     */
    @Override
    public HomeApplianceUse selectHomeApplianceUseById(Long id)
    {
        return homeApplianceUseMapper.selectHomeApplianceUseById(id);
    }

    /**
     * 查询家电操作技巧列表
     * 
     * @param homeApplianceUse 家电操作技巧
     * @return 家电操作技巧
     */
    @Override
    public List<HomeApplianceUse> selectHomeApplianceUseList(HomeApplianceUse homeApplianceUse)
    {
        return homeApplianceUseMapper.selectHomeApplianceUseList(homeApplianceUse);
    }

    /**
     * 新增家电操作技巧
     * 
     * @param homeApplianceUse 家电操作技巧
     * @return 结果
     */
    @Override
    public int insertHomeApplianceUse(HomeApplianceUse homeApplianceUse)
    {
        homeApplianceUse.setCreateTime(DateUtils.getNowDate());
        return homeApplianceUseMapper.insertHomeApplianceUse(homeApplianceUse);
    }

    /**
     * 修改家电操作技巧
     * 
     * @param homeApplianceUse 家电操作技巧
     * @return 结果
     */
    @Override
    public int updateHomeApplianceUse(HomeApplianceUse homeApplianceUse)
    {
        return homeApplianceUseMapper.updateHomeApplianceUse(homeApplianceUse);
    }

    /**
     * 批量删除家电操作技巧
     * 
     * @param ids 需要删除的家电操作技巧主键
     * @return 结果
     */
    @Override
    public int deleteHomeApplianceUseByIds(Long[] ids)
    {
        return homeApplianceUseMapper.deleteHomeApplianceUseByIds(ids);
    }

    /**
     * 删除家电操作技巧信息
     * 
     * @param id 家电操作技巧主键
     * @return 结果
     */
    @Override
    public int deleteHomeApplianceUseById(Long id)
    {
        return homeApplianceUseMapper.deleteHomeApplianceUseById(id);
    }
}
