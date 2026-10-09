package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.LifeFoodSelectMapper;
import zhishoulife.system.domain.LifeFoodSelect;
import zhishoulife.system.service.ILifeFoodSelectService;

/**
 * 食材挑选与保存Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class LifeFoodSelectServiceImpl implements ILifeFoodSelectService 
{
    @Autowired
    private LifeFoodSelectMapper lifeFoodSelectMapper;

    /**
     * 查询食材挑选与保存
     * 
     * @param id 食材挑选与保存主键
     * @return 食材挑选与保存
     */
    @Override
    public LifeFoodSelect selectLifeFoodSelectById(Long id)
    {
        return lifeFoodSelectMapper.selectLifeFoodSelectById(id);
    }

    /**
     * 查询食材挑选与保存列表
     * 
     * @param lifeFoodSelect 食材挑选与保存
     * @return 食材挑选与保存
     */
    @Override
    public List<LifeFoodSelect> selectLifeFoodSelectList(LifeFoodSelect lifeFoodSelect)
    {
        return lifeFoodSelectMapper.selectLifeFoodSelectList(lifeFoodSelect);
    }

    /**
     * 新增食材挑选与保存
     * 
     * @param lifeFoodSelect 食材挑选与保存
     * @return 结果
     */
    @Override
    public int insertLifeFoodSelect(LifeFoodSelect lifeFoodSelect)
    {
        lifeFoodSelect.setCreateTime(DateUtils.getNowDate());
        return lifeFoodSelectMapper.insertLifeFoodSelect(lifeFoodSelect);
    }

    /**
     * 修改食材挑选与保存
     * 
     * @param lifeFoodSelect 食材挑选与保存
     * @return 结果
     */
    @Override
    public int updateLifeFoodSelect(LifeFoodSelect lifeFoodSelect)
    {
        return lifeFoodSelectMapper.updateLifeFoodSelect(lifeFoodSelect);
    }

    /**
     * 批量删除食材挑选与保存
     * 
     * @param ids 需要删除的食材挑选与保存主键
     * @return 结果
     */
    @Override
    public int deleteLifeFoodSelectByIds(Long[] ids)
    {
        return lifeFoodSelectMapper.deleteLifeFoodSelectByIds(ids);
    }

    /**
     * 删除食材挑选与保存信息
     * 
     * @param id 食材挑选与保存主键
     * @return 结果
     */
    @Override
    public int deleteLifeFoodSelectById(Long id)
    {
        return lifeFoodSelectMapper.deleteLifeFoodSelectById(id);
    }
}
