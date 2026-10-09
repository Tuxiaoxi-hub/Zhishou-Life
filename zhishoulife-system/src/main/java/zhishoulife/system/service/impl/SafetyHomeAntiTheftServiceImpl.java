package zhishoulife.system.service.impl;

import java.util.List;
import zhishoulife.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhishoulife.system.mapper.SafetyHomeAntiTheftMapper;
import zhishoulife.system.domain.SafetyHomeAntiTheft;
import zhishoulife.system.service.ISafetyHomeAntiTheftService;

/**
 * 防盗防入侵Service业务层处理
 * 
 * @author admin
 * @date 2026-03-28
 */
@Service
public class SafetyHomeAntiTheftServiceImpl implements ISafetyHomeAntiTheftService 
{
    @Autowired
    private SafetyHomeAntiTheftMapper safetyHomeAntiTheftMapper;

    /**
     * 查询防盗防入侵
     * 
     * @param id 防盗防入侵主键
     * @return 防盗防入侵
     */
    @Override
    public SafetyHomeAntiTheft selectSafetyHomeAntiTheftById(Long id)
    {
        return safetyHomeAntiTheftMapper.selectSafetyHomeAntiTheftById(id);
    }

    /**
     * 查询防盗防入侵列表
     * 
     * @param safetyHomeAntiTheft 防盗防入侵
     * @return 防盗防入侵
     */
    @Override
    public List<SafetyHomeAntiTheft> selectSafetyHomeAntiTheftList(SafetyHomeAntiTheft safetyHomeAntiTheft)
    {
        return safetyHomeAntiTheftMapper.selectSafetyHomeAntiTheftList(safetyHomeAntiTheft);
    }

    /**
     * 新增防盗防入侵
     * 
     * @param safetyHomeAntiTheft 防盗防入侵
     * @return 结果
     */
    @Override
    public int insertSafetyHomeAntiTheft(SafetyHomeAntiTheft safetyHomeAntiTheft)
    {
        safetyHomeAntiTheft.setCreateTime(DateUtils.getNowDate());
        return safetyHomeAntiTheftMapper.insertSafetyHomeAntiTheft(safetyHomeAntiTheft);
    }

    /**
     * 修改防盗防入侵
     * 
     * @param safetyHomeAntiTheft 防盗防入侵
     * @return 结果
     */
    @Override
    public int updateSafetyHomeAntiTheft(SafetyHomeAntiTheft safetyHomeAntiTheft)
    {
        return safetyHomeAntiTheftMapper.updateSafetyHomeAntiTheft(safetyHomeAntiTheft);
    }

    /**
     * 批量删除防盗防入侵
     * 
     * @param ids 需要删除的防盗防入侵主键
     * @return 结果
     */
    @Override
    public int deleteSafetyHomeAntiTheftByIds(Long[] ids)
    {
        return safetyHomeAntiTheftMapper.deleteSafetyHomeAntiTheftByIds(ids);
    }

    /**
     * 删除防盗防入侵信息
     * 
     * @param id 防盗防入侵主键
     * @return 结果
     */
    @Override
    public int deleteSafetyHomeAntiTheftById(Long id)
    {
        return safetyHomeAntiTheftMapper.deleteSafetyHomeAntiTheftById(id);
    }
}
