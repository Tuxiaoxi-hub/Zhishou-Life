package zhishoulife.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zhishoulife.common.annotation.Excel;
import zhishoulife.common.core.domain.BaseEntity;

/**
 * 衣物清洗保养对象 life_clothes_clean
 * 
 * @author admin
 * @date 2026-03-28
 */
public class LifeClothesClean extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** 衣物类型/清洗主题 */
    @Excel(name = "衣物类型/清洗主题")
    private String title;

    /** 配图链接 */
    private String cover;

    /** 清洗方法 */
    private String content;

    /** 保养技巧 */
    private String maintain;

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

    public void setCover(String cover) 
    {
        this.cover = cover;
    }

    public String getCover() 
    {
        return cover;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public void setMaintain(String maintain) 
    {
        this.maintain = maintain;
    }

    public String getMaintain() 
    {
        return maintain;
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
            .append("cover", getCover())
            .append("content", getContent())
            .append("maintain", getMaintain())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
