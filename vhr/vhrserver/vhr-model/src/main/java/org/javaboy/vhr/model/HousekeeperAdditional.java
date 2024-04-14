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
public class HousekeeperAdditional extends Model<HousekeeperAdditional> {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联的家长服务人员ID
     */
    private Long relateId;

    /**
     * 状态
     */
    private String status;

    /**
     * 附加信息类型
     */
    private String additionalKey;

    /**
     * 附加信息值
     */
    @TableField("additionalVal")
    private String additionalVal;

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
      @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
      @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifiedTime;

    /**
     * 版本号
     */
    private Integer version;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
