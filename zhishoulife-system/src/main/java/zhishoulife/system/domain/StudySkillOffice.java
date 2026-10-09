package zhishoulife.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zhishoulife.common.annotation.Excel;
import zhishoulife.common.core.domain.BaseEntity;

/**
 * 办公软件技能对象 study_skill_office
 * 
 * @author admin
 * @date 2026-03-28
 */
public class StudySkillOffice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** 技能主题 */
    @Excel(name = "技能主题")
    private String title;

    /** 操作技巧 */
    private String content;

    /** 适用场景 */
    private String suitable;

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

    public void setSuitable(String suitable) 
    {
        this.suitable = suitable;
    }

    public String getSuitable() 
    {
        return suitable;
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
            .append("suitable", getSuitable())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
