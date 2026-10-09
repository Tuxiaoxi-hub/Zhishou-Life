package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.LifeFoodCookMapper;
import zhishoulife.system.domain.LifeFoodCook;
import zhishoulife.system.service.ILifeFoodCookService;

/**
 * 家常菜烹饪Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class LifeFoodCookServiceImpl implements ILifeFoodCookService 
{
    @Autowired
    private LifeFoodCookMapper lifeFoodCookMapper;

    /**
     * 查询家常菜烹饪
     * 
     * @param id 家常菜烹饪主键
     * @return 家常菜烹饪
     */
    @Override
    public LifeFoodCook selectLifeFoodCookById(Long id)
    {
        return lifeFoodCookMapper.selectLifeFoodCookById(id);
    }

    /**
     * 查询家常菜烹饪列表
     * 
     * @param lifeFoodCook 家常菜烹饪
     * @return 家常菜烹饪
     */
    @Override
    public List<LifeFoodCook> selectLifeFoodCookList(LifeFoodCook lifeFoodCook)
    {
        return lifeFoodCookMapper.selectLifeFoodCookList(lifeFoodCook);
    }

    /**
     * 新增家常菜烹饪
     * 
     * @param lifeFoodCook 家常菜烹饪
     * @return 结果
     */
    @Override
    public int insertLifeFoodCook(LifeFoodCook lifeFoodCook)
    {
        lifeFoodCook.setCreateTime(DateUtils.getNowDate());
        return lifeFoodCookMapper.insertLifeFoodCook(lifeFoodCook);
    }

    /**
     * 修改家常菜烹饪
     * 
     * @param lifeFoodCook 家常菜烹饪
     * @return 结果
     */
    @Override
    public int updateLifeFoodCook(LifeFoodCook lifeFoodCook)
    {
        return lifeFoodCookMapper.updateLifeFoodCook(lifeFoodCook);
    }

    /**
     * 批量删除家常菜烹饪
     * 
     * @param ids 需要删除的家常菜烹饪主键
     * @return 结果
     */
    @Override
    public int deleteLifeFoodCookByIds(Long[] ids)
    {
        return lifeFoodCookMapper.deleteLifeFoodCookByIds(ids);
    }

    /**
     * 删除家常菜烹饪信息
     * 
     * @param id 家常菜烹饪主键
     * @return 结果
     */
    @Override
    public int deleteLifeFoodCookById(Long id)
    {
        return lifeFoodCookMapper.deleteLifeFoodCookById(id);
    }
}
