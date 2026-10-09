package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.LifeClothesStainMapper;
import zhishoulife.system.domain.LifeClothesStain;
import zhishoulife.system.service.ILifeClothesStainService;

/**
 * 污渍去除技巧Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class LifeClothesStainServiceImpl implements ILifeClothesStainService 
{
    @Autowired
    private LifeClothesStainMapper lifeClothesStainMapper;

    /**
     * 查询污渍去除技巧
     * 
     * @param id 污渍去除技巧主键
     * @return 污渍去除技巧
     */
    @Override
    public LifeClothesStain selectLifeClothesStainById(Long id)
    {
        return lifeClothesStainMapper.selectLifeClothesStainById(id);
    }

    /**
     * 查询污渍去除技巧列表
     * 
     * @param lifeClothesStain 污渍去除技巧
     * @return 污渍去除技巧
     */
    @Override
    public List<LifeClothesStain> selectLifeClothesStainList(LifeClothesStain lifeClothesStain)
    {
        return lifeClothesStainMapper.selectLifeClothesStainList(lifeClothesStain);
    }

    /**
     * 新增污渍去除技巧
     * 
     * @param lifeClothesStain 污渍去除技巧
     * @return 结果
     */
    @Override
    public int insertLifeClothesStain(LifeClothesStain lifeClothesStain)
    {
        lifeClothesStain.setCreateTime(DateUtils.getNowDate());
        return lifeClothesStainMapper.insertLifeClothesStain(lifeClothesStain);
    }

    /**
     * 修改污渍去除技巧
     * 
     * @param lifeClothesStain 污渍去除技巧
     * @return 结果
     */
    @Override
    public int updateLifeClothesStain(LifeClothesStain lifeClothesStain)
    {
        return lifeClothesStainMapper.updateLifeClothesStain(lifeClothesStain);
    }

    /**
     * 批量删除污渍去除技巧
     * 
     * @param ids 需要删除的污渍去除技巧主键
     * @return 结果
     */
    @Override
    public int deleteLifeClothesStainByIds(Long[] ids)
    {
        return lifeClothesStainMapper.deleteLifeClothesStainByIds(ids);
    }

    /**
     * 删除污渍去除技巧信息
     * 
     * @param id 污渍去除技巧主键
     * @return 结果
     */
    @Override
    public int deleteLifeClothesStainById(Long id)
    {
        return lifeClothesStainMapper.deleteLifeClothesStainById(id);
    }
}
