package zhishoulife.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zhishoulife.common.annotation.Excel;
import zhishoulife.common.core.domain.BaseEntity;

/**
 * 家电保养维护对象 home_appliance_maintain
 * 
 * @author admin
 * @date 2026-03-28
 */
public class HomeApplianceMaintain extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** 家电名称 */
    @Excel(name = "家电名称")
    private String appName;

    /** 保养方法 */
    private String content;

    /** 保养周期 */
    private String cycle;

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

    public void setAppName(String appName) 
    {
        this.appName = appName;
    }

    public String getAppName() 
    {
        return appName;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public void setCycle(String cycle) 
    {
        this.cycle = cycle;
    }

    public String getCycle() 
    {
        return cycle;
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
            .append("appName", getAppName())
            .append("content", getContent())
            .append("cycle", getCycle())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
