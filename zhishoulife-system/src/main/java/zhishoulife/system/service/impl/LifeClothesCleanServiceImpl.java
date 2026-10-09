package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.LifeClothesCleanMapper;
import zhishoulife.system.domain.LifeClothesClean;
import zhishoulife.system.service.ILifeClothesCleanService;

/**
 * 衣物清洗保养Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class LifeClothesCleanServiceImpl implements ILifeClothesCleanService 
{
    @Autowired
    private LifeClothesCleanMapper lifeClothesCleanMapper;

    /**
     * 查询衣物清洗保养
     * 
     * @param id 衣物清洗保养主键
     * @return 衣物清洗保养
     */
    @Override
    public LifeClothesClean selectLifeClothesCleanById(Long id)
    {
        return lifeClothesCleanMapper.selectLifeClothesCleanById(id);
    }

    /**
     * 查询衣物清洗保养列表
     * 
     * @param lifeClothesClean 衣物清洗保养
     * @return 衣物清洗保养
     */
    @Override
    public List<LifeClothesClean> selectLifeClothesCleanList(LifeClothesClean lifeClothesClean)
    {
        return lifeClothesCleanMapper.selectLifeClothesCleanList(lifeClothesClean);
    }

    /**
     * 新增衣物清洗保养
     * 
     * @param lifeClothesClean 衣物清洗保养
     * @return 结果
     */
    @Override
    public int insertLifeClothesClean(LifeClothesClean lifeClothesClean)
    {
        lifeClothesClean.setCreateTime(DateUtils.getNowDate());
        return lifeClothesCleanMapper.insertLifeClothesClean(lifeClothesClean);
    }

    /**
     * 修改衣物清洗保养
     * 
     * @param lifeClothesClean 衣物清洗保养
     * @return 结果
     */
    @Override
    public int updateLifeClothesClean(LifeClothesClean lifeClothesClean)
    {
        return lifeClothesCleanMapper.updateLifeClothesClean(lifeClothesClean);
    }

    /**
     * 批量删除衣物清洗保养
     * 
     * @param ids 需要删除的衣物清洗保养主键
     * @return 结果
     */
    @Override
    public int deleteLifeClothesCleanByIds(Long[] ids)
    {
        return lifeClothesCleanMapper.deleteLifeClothesCleanByIds(ids);
    }

    /**
     * 删除衣物清洗保养信息
     * 
     * @param id 衣物清洗保养主键
     * @return 结果
     */
    @Override
    public int deleteLifeClothesCleanById(Long id)
    {
        return lifeClothesCleanMapper.deleteLifeClothesCleanById(id);
    }
}
