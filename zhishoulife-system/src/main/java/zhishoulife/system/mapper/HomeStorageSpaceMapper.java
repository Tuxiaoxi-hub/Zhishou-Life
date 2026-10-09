package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.HomeStorageSpace;

/**
 * 空间收纳技巧Mapper接口
 * 
 * @author admin
 * @date 2026-04-13
 */
public interface HomeStorageSpaceMapper 
{
    /**
     * 查询空间收纳技巧
     * 
     * @param id 空间收纳技巧主键
     * @return 空间收纳技巧
     */
    public HomeStorageSpace selectHomeStorageSpaceById(Long id);

    /**
     * 查询空间收纳技巧列表
     * 
     * @param homeStorageSpace 空间收纳技巧
     * @return 空间收纳技巧集合
     */
    public List<HomeStorageSpace> selectHomeStorageSpaceList(HomeStorageSpace homeStorageSpace);

    /**
     * 新增空间收纳技巧
     * 
     * @param homeStorageSpace 空间收纳技巧
     * @return 结果
     */
    public int insertHomeStorageSpace(HomeStorageSpace homeStorageSpace);

    /**
     * 修改空间收纳技巧
     * 
     * @param homeStorageSpace 空间收纳技巧
     * @return 结果
     */
    public int updateHomeStorageSpace(HomeStorageSpace homeStorageSpace);

    /**
     * 删除空间收纳技巧
     * 
     * @param id 空间收纳技巧主键
     * @return 结果
     */
    public int deleteHomeStorageSpaceById(Long id);

    /**
     * 批量删除空间收纳技巧
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHomeStorageSpaceByIds(Long[] ids);
}
