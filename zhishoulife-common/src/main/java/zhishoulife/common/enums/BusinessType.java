package zhishoulife.common.enums;

/**
 * 业务操作类型
 * 
 * @author ruoyi
 */
public enum BusinessType
{
    // 其他已有枚举值不变，新增QUERY
    SELECT,

    LOGIN,
    // 新增QUERY枚举值
    QUERY,
    /**
     * 其它
     */
    OTHER,

    /**
     * 新增
     */
    INSERT,

    /**
     * 修改
     */
    UPDATE,

    /**
     * 删除
     */
    DELETE,

    /**
     * 授权
     */
    GRANT,

    /**
     * 导出
     */
    EXPORT,

    /**
     * 导入
     */
    IMPORT,

    /**
     * 强退
     */
    FORCE,

    /**
     * 生成代码
     */
    GENCODE,
    
    /**
     * 清空数据
     */
    CLEAN,
}
