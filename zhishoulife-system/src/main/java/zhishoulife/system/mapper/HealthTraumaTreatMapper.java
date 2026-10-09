package zhishoulife.system.mapper;

import java.util.List;
import zhishoulife.system.domain.HealthTraumaTreat;

/**
 * 外伤应急处理Mapper接口
 * 
 * @author admin
 * @date 2026-03-27
 */
public interface HealthTraumaTreatMapper 
{
    /**
     * 查询外伤应急处理
     * 
     * @param id 外伤应急处理主键
     * @return 外伤应急处理
     */
    public HealthTraumaTreat selectHealthTraumaTreatById(Long id);

    /**
     * 查询外伤应急处理列表
     * 
     * @param healthTraumaTreat 外伤应急处理
     * @return 外伤应急处理集合
     */
    public List<HealthTraumaTreat> selectHealthTraumaTreatList(HealthTraumaTreat healthTraumaTreat);

    /**
     * 新增外伤应急处理
     * 
     * @param healthTraumaTreat 外伤应急处理
     * @return 结果
     */
    public int insertHealthTraumaTreat(HealthTraumaTreat healthTraumaTreat);

    /**
     * 修改外伤应急处理
     * 
     * @param healthTraumaTreat 外伤应急处理
     * @return 结果
     */
    public int updateHealthTraumaTreat(HealthTraumaTreat healthTraumaTreat);

    /**
     * 删除外伤应急处理
     * 
     * @param id 外伤应急处理主键
     * @return 结果
     */
    public int deleteHealthTraumaTreatById(Long id);

    /**
     * 批量删除外伤应急处理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHealthTraumaTreatByIds(Long[] ids);
}
