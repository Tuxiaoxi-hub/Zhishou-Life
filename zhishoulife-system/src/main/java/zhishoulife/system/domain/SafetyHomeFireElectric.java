package zhishoulife.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zhishoulife.common.annotation.Excel;
import zhishoulife.common.core.domain.BaseEntity;

/**
 * 用火用电安全对象 safety_home_fire_electric
 * 
 * @author admin
 * @date 2026-03-28
 */
public class SafetyHomeFireElectric extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** 安全场景 */
    @Excel(name = "安全场景")
    private String title;

    /** 安全规范 */
    private String content;

    /** 安全隐患 */
    private String danger;

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

    public void setDanger(String danger) 
    {
        this.danger = danger;
    }

    public String getDanger() 
    {
        return danger;
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
            .append("danger", getDanger())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
