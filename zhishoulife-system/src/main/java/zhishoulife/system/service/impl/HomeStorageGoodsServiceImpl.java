package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.HomeStorageGoodsMapper;
import zhishoulife.system.domain.HomeStorageGoods;
import zhishoulife.system.service.IHomeStorageGoodsService;

/**
 * 物品收纳整理Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class HomeStorageGoodsServiceImpl implements IHomeStorageGoodsService 
{
    @Autowired
    private HomeStorageGoodsMapper homeStorageGoodsMapper;

    /**
     * 查询物品收纳整理
     * 
     * @param id 物品收纳整理主键
     * @return 物品收纳整理
     */
    @Override
    public HomeStorageGoods selectHomeStorageGoodsById(Long id)
    {
        return homeStorageGoodsMapper.selectHomeStorageGoodsById(id);
    }

    /**
     * 查询物品收纳整理列表
     * 
     * @param homeStorageGoods 物品收纳整理
     * @return 物品收纳整理
     */
    @Override
    public List<HomeStorageGoods> selectHomeStorageGoodsList(HomeStorageGoods homeStorageGoods)
    {
        return homeStorageGoodsMapper.selectHomeStorageGoodsList(homeStorageGoods);
    }

    /**
     * 新增物品收纳整理
     * 
     * @param homeStorageGoods 物品收纳整理
     * @return 结果
     */
    @Override
    public int insertHomeStorageGoods(HomeStorageGoods homeStorageGoods)
    {
        homeStorageGoods.setCreateTime(DateUtils.getNowDate());
        return homeStorageGoodsMapper.insertHomeStorageGoods(homeStorageGoods);
    }

    /**
     * 修改物品收纳整理
     * 
     * @param homeStorageGoods 物品收纳整理
     * @return 结果
     */
    @Override
    public int updateHomeStorageGoods(HomeStorageGoods homeStorageGoods)
    {
        return homeStorageGoodsMapper.updateHomeStorageGoods(homeStorageGoods);
    }

    /**
     * 批量删除物品收纳整理
     * 
     * @param ids 需要删除的物品收纳整理主键
     * @return 结果
     */
    @Override
    public int deleteHomeStorageGoodsByIds(Long[] ids)
    {
        return homeStorageGoodsMapper.deleteHomeStorageGoodsByIds(ids);
    }

    /**
     * 删除物品收纳整理信息
     * 
     * @param id 物品收纳整理主键
     * @return 结果
     */
    @Override
    public int deleteHomeStorageGoodsById(Long id)
    {
        return homeStorageGoodsMapper.deleteHomeStorageGoodsById(id);
    }
}
