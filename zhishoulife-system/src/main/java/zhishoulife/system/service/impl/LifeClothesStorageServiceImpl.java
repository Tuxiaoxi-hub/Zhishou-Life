package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.LifeClothesStorageMapper;
import zhishoulife.system.domain.LifeClothesStorage;
import zhishoulife.system.service.ILifeClothesStorageService;

/**
 * 衣物收纳整理Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class LifeClothesStorageServiceImpl implements ILifeClothesStorageService 
{
    @Autowired
    private LifeClothesStorageMapper lifeClothesStorageMapper;

    /**
     * 查询衣物收纳整理
     * 
     * @param id 衣物收纳整理主键
     * @return 衣物收纳整理
     */
    @Override
    public LifeClothesStorage selectLifeClothesStorageById(Long id)
    {
        return lifeClothesStorageMapper.selectLifeClothesStorageById(id);
    }

    /**
     * 查询衣物收纳整理列表
     * 
     * @param lifeClothesStorage 衣物收纳整理
     * @return 衣物收纳整理
     */
    @Override
    public List<LifeClothesStorage> selectLifeClothesStorageList(LifeClothesStorage lifeClothesStorage)
    {
        return lifeClothesStorageMapper.selectLifeClothesStorageList(lifeClothesStorage);
    }

    /**
     * 新增衣物收纳整理
     * 
     * @param lifeClothesStorage 衣物收纳整理
     * @return 结果
     */
    @Override
    public int insertLifeClothesStorage(LifeClothesStorage lifeClothesStorage)
    {
        lifeClothesStorage.setCreateTime(DateUtils.getNowDate());
        return lifeClothesStorageMapper.insertLifeClothesStorage(lifeClothesStorage);
    }

    /**
     * 修改衣物收纳整理
     * 
     * @param lifeClothesStorage 衣物收纳整理
     * @return 结果
     */
    @Override
    public int updateLifeClothesStorage(LifeClothesStorage lifeClothesStorage)
    {
        return lifeClothesStorageMapper.updateLifeClothesStorage(lifeClothesStorage);
    }

    /**
     * 批量删除衣物收纳整理
     * 
     * @param ids 需要删除的衣物收纳整理主键
     * @return 结果
     */
    @Override
    public int deleteLifeClothesStorageByIds(Long[] ids)
    {
        return lifeClothesStorageMapper.deleteLifeClothesStorageByIds(ids);
    }

    /**
     * 删除衣物收纳整理信息
     * 
     * @param id 衣物收纳整理主键
     * @return 结果
     */
    @Override
    public int deleteLifeClothesStorageById(Long id)
    {
        return lifeClothesStorageMapper.deleteLifeClothesStorageById(id);
    }
}
