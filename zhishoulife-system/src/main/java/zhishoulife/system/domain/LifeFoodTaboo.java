package zhishoulife.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zhishoulife.common.annotation.Excel;
import zhishoulife.common.core.domain.BaseEntity;

/**
 * 饮食禁忌与搭配对象 life_food_taboo
 * 
 * @author admin
 * @date 2026-03-28
 */
public class LifeFoodTaboo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** 搭配/禁忌主题 */
    @Excel(name = "搭配/禁忌主题")
    private String title;

    /** 详细说明 */
    private String content;

    /** 不良影响 */
    private String harm;

    /** 合理建议 */
    private String suggest;

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

    public void setHarm(String harm) 
    {
        this.harm = harm;
    }

    public String getHarm() 
    {
        return harm;
    }

    public void setSuggest(String suggest) 
    {
        this.suggest = suggest;
    }

    public String getSuggest() 
    {
        return suggest;
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
            .append("harm", getHarm())
            .append("suggest", getSuggest())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
