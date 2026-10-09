package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.HomeStorageGoods;

/**
 * 物品收纳整理Mapper接口
 * 
 * @author admin
 * @date 2026-03-28
 */
public interface HomeStorageGoodsMapper 
{
    /**
     * 查询物品收纳整理
     * 
     * @param id 物品收纳整理主键
     * @return 物品收纳整理
     */
    public HomeStorageGoods selectHomeStorageGoodsById(Long id);

    /**
     * 查询物品收纳整理列表
     * 
     * @param homeStorageGoods 物品收纳整理
     * @return 物品收纳整理集合
     */
    public List<HomeStorageGoods> selectHomeStorageGoodsList(HomeStorageGoods homeStorageGoods);

    /**
     * 新增物品收纳整理
     * 
     * @param homeStorageGoods 物品收纳整理
     * @return 结果
     */
    public int insertHomeStorageGoods(HomeStorageGoods homeStorageGoods);

    /**
     * 修改物品收纳整理
     * 
     * @param homeStorageGoods 物品收纳整理
     * @return 结果
     */
    public int updateHomeStorageGoods(HomeStorageGoods homeStorageGoods);

    /**
     * 删除物品收纳整理
     * 
     * @param id 物品收纳整理主键
     * @return 结果
     */
    public int deleteHomeStorageGoodsById(Long id);

    /**
     * 批量删除物品收纳整理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHomeStorageGoodsByIds(Long[] ids);
}
