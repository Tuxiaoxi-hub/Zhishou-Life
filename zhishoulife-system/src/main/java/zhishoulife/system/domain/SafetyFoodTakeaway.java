package zhishoulife.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zhishoulife.common.annotation.Excel;
import zhishoulife.common.core.domain.BaseEntity;

/**
 * 外卖安全常识对象 safety_food_takeaway
 * 
 * @author admin
 * @date 2026-03-28
 */
public class SafetyFoodTakeaway extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识ID */
    @Excel(name = "唯一标识ID")
    private Long id;

    /** 外卖安全标题 */
    @Excel(name = "外卖安全标题")
    private String title;

    /** 安全常识详情（300-500字） */
    private String content;

    /** 注意事项说明 */
    private String attention;

    /** 状态（1=启用，0=禁用） */
    @Excel(name = "状态", readConverterExp = "1==启用，0=禁用")
    private Integer status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public void setAttention(String attention) 
    {
        this.attention = attention;
    }

    public String getAttention() 
    {
        return attention;
    }

    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("attention", getAttention())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
