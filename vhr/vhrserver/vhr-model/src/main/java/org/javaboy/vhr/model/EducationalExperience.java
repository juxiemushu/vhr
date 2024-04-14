package org.javaboy.vhr.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wsp
 * @since 2024-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class EducationalExperience extends Model<EducationalExperience> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联人员类型
     */
    private String relateType;

    /**
     * 关联人员ID
     */
    private Long relateId;

    /**
     * 状态
     */
    private String status;

    /**
     * 起始日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date endDate;

    /**
     * 教育经历类型
     */
    private String type;

    /**
     * 学校名称
     */
    private String school;

    /**
     * 所在院系
     */
    private String department;

    /**
     * 所在专业
     */
    private String subject;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 创建人
     */
      @TableField(fill = FieldFill.INSERT)
    private String creator;

    /**
     * 修改人
     */
      @TableField(fill = FieldFill.INSERT_UPDATE)
    private String modifier;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("modifiedTime")
    private Date modifiedTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
