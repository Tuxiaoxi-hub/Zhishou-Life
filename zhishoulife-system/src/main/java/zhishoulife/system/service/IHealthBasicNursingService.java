package zhishoulife.system.service;

import java.util.List;
import zhishoulife.system.domain.HealthBasicNursing;

/**
 * 常见病症护理Service接口
 * 
 * @author admin
 * @date 2026-03-27
 */
public interface IHealthBasicNursingService 
{
    /**
     * 查询常见病症护理
     * 
     * @param id 常见病症护理主键
     * @return 常见病症护理
     */
    public HealthBasicNursing selectHealthBasicNursingById(Long id);

    /**
     * 查询常见病症护理列表
     * 
     * @param healthBasicNursing 常见病症护理
     * @return 常见病症护理集合
     */
    public List<HealthBasicNursing> selectHealthBasicNursingList(HealthBasicNursing healthBasicNursing);

    /**
     * 新增常见病症护理
     * 
     * @param healthBasicNursing 常见病症护理
     * @return 结果
     */
    public int insertHealthBasicNursing(HealthBasicNursing healthBasicNursing);

    /**
     * 修改常见病症护理
     * 
     * @param healthBasicNursing 常见病症护理
     * @return 结果
     */
    public int updateHealthBasicNursing(HealthBasicNursing healthBasicNursing);

    /**
     * 批量删除常见病症护理
     * 
     * @param ids 需要删除的常见病症护理主键集合
     * @return 结果
     */
    public int deleteHealthBasicNursingByIds(Long[] ids);

    /**
     * 删除常见病症护理信息
     * 
     * @param id 常见病症护理主键
     * @return 结果
     */
    public int deleteHealthBasicNursingById(Long id);
}
