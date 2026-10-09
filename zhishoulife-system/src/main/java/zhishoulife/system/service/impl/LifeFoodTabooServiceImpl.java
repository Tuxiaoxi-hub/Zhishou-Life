package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.LifeFoodTabooMapper;
import zhishoulife.system.domain.LifeFoodTaboo;
import zhishoulife.system.service.ILifeFoodTabooService;

/**
 * 饮食禁忌与搭配Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class LifeFoodTabooServiceImpl implements ILifeFoodTabooService 
{
    @Autowired
    private LifeFoodTabooMapper lifeFoodTabooMapper;

    /**
     * 查询饮食禁忌与搭配
     * 
     * @param id 饮食禁忌与搭配主键
     * @return 饮食禁忌与搭配
     */
    @Override
    public LifeFoodTaboo selectLifeFoodTabooById(Long id)
    {
        return lifeFoodTabooMapper.selectLifeFoodTabooById(id);
    }

    /**
     * 查询饮食禁忌与搭配列表
     * 
     * @param lifeFoodTaboo 饮食禁忌与搭配
     * @return 饮食禁忌与搭配
     */
    @Override
    public List<LifeFoodTaboo> selectLifeFoodTabooList(LifeFoodTaboo lifeFoodTaboo)
    {
        return lifeFoodTabooMapper.selectLifeFoodTabooList(lifeFoodTaboo);
    }

    /**
     * 新增饮食禁忌与搭配
     * 
     * @param lifeFoodTaboo 饮食禁忌与搭配
     * @return 结果
     */
    @Override
    public int insertLifeFoodTaboo(LifeFoodTaboo lifeFoodTaboo)
    {
        lifeFoodTaboo.setCreateTime(DateUtils.getNowDate());
        return lifeFoodTabooMapper.insertLifeFoodTaboo(lifeFoodTaboo);
    }

    /**
     * 修改饮食禁忌与搭配
     * 
     * @param lifeFoodTaboo 饮食禁忌与搭配
     * @return 结果
     */
    @Override
    public int updateLifeFoodTaboo(LifeFoodTaboo lifeFoodTaboo)
    {
        return lifeFoodTabooMapper.updateLifeFoodTaboo(lifeFoodTaboo);
    }

    /**
     * 批量删除饮食禁忌与搭配
     * 
     * @param ids 需要删除的饮食禁忌与搭配主键
     * @return 结果
     */
    @Override
    public int deleteLifeFoodTabooByIds(Long[] ids)
    {
        return lifeFoodTabooMapper.deleteLifeFoodTabooByIds(ids);
    }

    /**
     * 删除饮食禁忌与搭配信息
     * 
     * @param id 饮食禁忌与搭配主键
     * @return 结果
     */
    @Override
    public int deleteLifeFoodTabooById(Long id)
    {
        return lifeFoodTabooMapper.deleteLifeFoodTabooById(id);
    }
}
