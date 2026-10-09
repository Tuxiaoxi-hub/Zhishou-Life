package zhishoulife.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zhishoulife.common.annotation.Excel;
import zhishoulife.common.core.domain.BaseEntity;

/**
 * 常见消费纠纷处理对象 life_consumption_dispute
 * 
 * @author admin
 * @date 2026-03-28
 */
public class LifeConsumptionDispute extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** 纠纷类型 */
    @Excel(name = "纠纷类型")
    private String title;

    /** 处理方法 */
    private String content;

    /** 所需证据 */
    private String evidence;

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

    public void setEvidence(String evidence) 
    {
        this.evidence = evidence;
    }

    public String getEvidence() 
    {
        return evidence;
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
            .append("evidence", getEvidence())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
