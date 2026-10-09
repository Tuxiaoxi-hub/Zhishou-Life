package zhishoulife.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zhishoulife.common.annotation.Excel;
import zhishoulife.common.core.domain.BaseEntity;

/**
 * 交通标志识别对象 traffic_sign_identify
 * 
 * @author admin
 * @date 2026-03-28
 */
public class TrafficSignIdentify extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** 标志名称 */
    @Excel(name = "标志名称")
    private String signName;

    /** 标志图片 */
    private String signImg;

    /** 标志含义 */
    private String content;

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

    public void setSignName(String signName) 
    {
        this.signName = signName;
    }

    public String getSignName() 
    {
        return signName;
    }

    public void setSignImg(String signImg) 
    {
        this.signImg = signImg;
    }

    public String getSignImg() 
    {
        return signImg;
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
            .append("signName", getSignName())
            .append("signImg", getSignImg())
            .append("content", getContent())
            .append("attention", getAttention())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
