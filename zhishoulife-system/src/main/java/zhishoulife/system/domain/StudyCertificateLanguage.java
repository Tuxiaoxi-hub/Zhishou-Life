package zhishoulife.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zhishoulife.common.annotation.Excel;
import zhishoulife.common.core.domain.BaseEntity;

/**
 * 语言类证书对象 study_certificate_language
 * 
 * @author admin
 * @date 2026-03-28
 */
public class StudyCertificateLanguage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** 证书名称 */
    @Excel(name = "证书名称")
    private String certName;

    /** 证书介绍 */
    private String content;

    /** 考试时间 */
    private String examTime;

    /** 备考技巧 */
    private String skill;

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

    public void setCertName(String certName) 
    {
        this.certName = certName;
    }

    public String getCertName() 
    {
        return certName;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public void setExamTime(String examTime) 
    {
        this.examTime = examTime;
    }

    public String getExamTime() 
    {
        return examTime;
    }

    public void setSkill(String skill) 
    {
        this.skill = skill;
    }

    public String getSkill() 
    {
        return skill;
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
            .append("certName", getCertName())
            .append("content", getContent())
            .append("examTime", getExamTime())
            .append("skill", getSkill())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
