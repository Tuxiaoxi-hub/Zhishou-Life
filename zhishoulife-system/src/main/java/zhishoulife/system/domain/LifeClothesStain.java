package zhishoulife.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zhishoulife.common.annotation.Excel;
import zhishoulife.common.core.domain.BaseEntity;

/**
 * 污渍去除技巧对象 life_clothes_stain
 * 
 * @author admin
 * @date 2026-03-28
 */
public class LifeClothesStain extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** 污渍类型 */
    @Excel(name = "污渍类型")
    private String stainType;

    /** 去除步骤 */
    private String content;

    /** 适用面料 */
    private String suitable;

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

    public void setStainType(String stainType) 
    {
        this.stainType = stainType;
    }

    public String getStainType() 
    {
        return stainType;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public void setSuitable(String suitable) 
    {
        this.suitable = suitable;
    }

    public String getSuitable() 
    {
        return suitable;
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
            .append("stainType", getStainType())
            .append("content", getContent())
            .append("suitable", getSuitable())
            .append("attention", getAttention())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
