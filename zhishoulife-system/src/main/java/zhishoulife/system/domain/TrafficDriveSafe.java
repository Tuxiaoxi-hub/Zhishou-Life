package zhishoulife.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zhishoulife.common.annotation.Excel;
import zhishoulife.common.core.domain.BaseEntity;

/**
 * 自驾出行安全对象 traffic_drive_safe
 * 
 * @author admin
 * @date 2026-03-28
 */
public class TrafficDriveSafe extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** 自驾场景 */
    @Excel(name = "自驾场景")
    private String title;

    /** 安全技巧 */
    private String content;

    /** 车辆检查 */
    private String carCheck;

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

    public void setCarCheck(String carCheck) 
    {
        this.carCheck = carCheck;
    }

    public String getCarCheck() 
    {
        return carCheck;
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
            .append("carCheck", getCarCheck())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
