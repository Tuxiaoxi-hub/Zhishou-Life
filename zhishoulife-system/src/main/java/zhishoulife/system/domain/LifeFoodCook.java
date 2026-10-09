package zhishoulife.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zhishoulife.common.annotation.Excel;
import zhishoulife.common.core.domain.BaseEntity;

/**
 * 家常菜烹饪对象 life_food_cook
 * 
 * @author admin
 * @date 2026-03-28
 */
public class LifeFoodCook extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long id;

    /** 菜品名称 */
    @Excel(name = "菜品名称")
    private String dishName;

    /** 菜品配图 */
    private String cover;

    /** 食材配料 */
    private String ingredient;

    /** 烹饪步骤 */
    private String step;

    /** 烹饪技巧 */
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

    public void setDishName(String dishName) 
    {
        this.dishName = dishName;
    }

    public String getDishName() 
    {
        return dishName;
    }

    public void setCover(String cover) 
    {
        this.cover = cover;
    }

    public String getCover() 
    {
        return cover;
    }

    public void setIngredient(String ingredient) 
    {
        this.ingredient = ingredient;
    }

    public String getIngredient() 
    {
        return ingredient;
    }

    public void setStep(String step) 
    {
        this.step = step;
    }

    public String getStep() 
    {
        return step;
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
            .append("dishName", getDishName())
            .append("cover", getCover())
            .append("ingredient", getIngredient())
            .append("step", getStep())
            .append("skill", getSkill())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
