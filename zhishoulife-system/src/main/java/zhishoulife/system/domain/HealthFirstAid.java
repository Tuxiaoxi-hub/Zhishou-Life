package zhishoulife.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zhishoulife.common.annotation.Excel;
import zhishoulife.common.core.domain.BaseEntity;

/**
 * 常见急救方法对象 health_first_aid
 * 
 * @author ruoyi
 * @date 2026-03-27
 */
public class HealthFirstAid extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** 急救场景 */
    @Excel(name = "急救场景")
    private String title;

    /** 急救步骤 */
    private String step;

    /** 禁忌操作 */
    private String forbidden;

    /** 注意事项 */
    private String attention;

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

    public void setStep(String step) 
    {
        this.step = step;
    }

    public String getStep() 
    {
        return step;
    }

    public void setForbidden(String forbidden) 
    {
        this.forbidden = forbidden;
    }

    public String getForbidden() 
    {
        return forbidden;
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
            .append("step", getStep())
            .append("forbidden", getForbidden())
            .append("attention", getAttention())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
