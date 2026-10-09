package zhishoulife.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zhishoulife.common.annotation.Excel;
import zhishoulife.common.core.domain.BaseEntity;

/**
 * 运动健身常识对象 health_sport_fitness
 * 
 * @author admin
 * @date 2026-03-27
 */
public class HealthSportFitness extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** 运动健身主题 */
    @Excel(name = "运动健身主题")
    private String title;

    /** 健身方法 */
    private String content;

    /** 运动注意事项 */
    private String attention;

    /** 适用人群 */
    private String crowd;

    /** 状态 */
    @Excel(name = "状态")
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

    public void setCrowd(String crowd) 
    {
        this.crowd = crowd;
    }

    public String getCrowd() 
    {
        return crowd;
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
            .append("crowd", getCrowd())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
