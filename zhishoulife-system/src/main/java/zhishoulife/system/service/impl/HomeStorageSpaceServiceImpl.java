package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.HomeStorageSpaceMapper;
import zhishoulife.system.domain.HomeStorageSpace;
import zhishoulife.system.service.IHomeStorageSpaceService;

/**
 * 空间收纳技巧Service业务层处理
 * 
 * @author admin
 * @date 2026-04-13
 */
@Service
public class HomeStorageSpaceServiceImpl implements IHomeStorageSpaceService 
{
    @Autowired
    private HomeStorageSpaceMapper homeStorageSpaceMapper;

    /**
     * 查询空间收纳技巧
     * 
     * @param id 空间收纳技巧主键
     * @return 空间收纳技巧
     */
    @Override
    public HomeStorageSpace selectHomeStorageSpaceById(Long id)
    {
        return homeStorageSpaceMapper.selectHomeStorageSpaceById(id);
    }

    /**
     * 查询空间收纳技巧列表
     * 
     * @param homeStorageSpace 空间收纳技巧
     * @return 空间收纳技巧
     */
    @Override
    public List<HomeStorageSpace> selectHomeStorageSpaceList(HomeStorageSpace homeStorageSpace)
    {
        return homeStorageSpaceMapper.selectHomeStorageSpaceList(homeStorageSpace);
    }

    /**
     * 新增空间收纳技巧
     * 
     * @param homeStorageSpace 空间收纳技巧
     * @return 结果
     */
    @Override
    public int insertHomeStorageSpace(HomeStorageSpace homeStorageSpace)
    {
        homeStorageSpace.setCreateTime(DateUtils.getNowDate());
        return homeStorageSpaceMapper.insertHomeStorageSpace(homeStorageSpace);
    }

    /**
     * 修改空间收纳技巧
     * 
     * @param homeStorageSpace 空间收纳技巧
     * @return 结果
     */
    @Override
    public int updateHomeStorageSpace(HomeStorageSpace homeStorageSpace)
    {
        return homeStorageSpaceMapper.updateHomeStorageSpace(homeStorageSpace);
    }

    /**
     * 批量删除空间收纳技巧
     * 
     * @param ids 需要删除的空间收纳技巧主键
     * @return 结果
     */
    @Override
    public int deleteHomeStorageSpaceByIds(Long[] ids)
    {
        return homeStorageSpaceMapper.deleteHomeStorageSpaceByIds(ids);
    }

    /**
     * 删除空间收纳技巧信息
     * 
     * @param id 空间收纳技巧主键
     * @return 结果
     */
    @Override
    public int deleteHomeStorageSpaceById(Long id)
    {
        return homeStorageSpaceMapper.deleteHomeStorageSpaceById(id);
    }
}
