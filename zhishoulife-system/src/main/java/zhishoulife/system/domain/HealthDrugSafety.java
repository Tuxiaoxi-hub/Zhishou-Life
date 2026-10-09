package zhishoulife.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zhishoulife.common.annotation.Excel;
import zhishoulife.common.core.domain.BaseEntity;

/**
 * 药物安全对象 health_drug_safety
 * 
 * @author admin
 * @date 2026-04-13
 */
public class HealthDrugSafety extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** 药品名称 */
    @Excel(name = "药品名称")
    private String drugName;

    /** 药品图片 */
    private String drugImg;

    /** 药品类型 */
    private String drugType;

    /** 适应症 */
    private String indication;

    /** 用法用量 */
    private String usageMethod;

    /** 注意事项 */
    private String attention;

    /** 禁忌人群 */
    private String taboo;

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

    public void setDrugName(String drugName) 
    {
        this.drugName = drugName;
    }

    public String getDrugName() 
    {
        return drugName;
    }

    public void setDrugImg(String drugImg) 
    {
        this.drugImg = drugImg;
    }

    public String getDrugImg() 
    {
        return drugImg;
    }

    public void setDrugType(String drugType) 
    {
        this.drugType = drugType;
    }

    public String getDrugType() 
    {
        return drugType;
    }

    public void setIndication(String indication) 
    {
        this.indication = indication;
    }

    public String getIndication() 
    {
        return indication;
    }

    public void setUsageMethod(String usageMethod) 
    {
        this.usageMethod = usageMethod;
    }

    public String getUsageMethod() 
    {
        return usageMethod;
    }

    public void setAttention(String attention) 
    {
        this.attention = attention;
    }

    public String getAttention() 
    {
        return attention;
    }

    public void setTaboo(String taboo) 
    {
        this.taboo = taboo;
    }

    public String getTaboo() 
    {
        return taboo;
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
            .append("drugName", getDrugName())
            .append("drugImg", getDrugImg())
            .append("drugType", getDrugType())
            .append("indication", getIndication())
            .append("usageMethod", getUsageMethod())
            .append("attention", getAttention())
            .append("taboo", getTaboo())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
