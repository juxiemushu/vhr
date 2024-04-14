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
public class ServiceExperience extends Model<ServiceExperience> {

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
     * 工作岗位
     */
    private String jobTitle;

    /**
     * 工作内容
     */
    private String jobContent;

    /**
     * 工作评价
     */
    private String jobEvaluation;

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
