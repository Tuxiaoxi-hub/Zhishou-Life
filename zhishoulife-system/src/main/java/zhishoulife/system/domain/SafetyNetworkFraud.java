package zhishoulife.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zhishoulife.common.annotation.Excel;
import zhishoulife.common.core.domain.BaseEntity;

/**
 * 网络诈骗防范对象 safety_network_fraud
 * 
 * @author admin
 * @date 2026-03-28
 */
public class SafetyNetworkFraud extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** 诈骗类型 */
    @Excel(name = "诈骗类型")
    private String title;

    /** 诈骗手段 */
    private String content;

    /** 防范技巧 */
    private String prevent;

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

    public void setPrevent(String prevent) 
    {
        this.prevent = prevent;
    }

    public String getPrevent() 
    {
        return prevent;
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
            .append("prevent", getPrevent())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
