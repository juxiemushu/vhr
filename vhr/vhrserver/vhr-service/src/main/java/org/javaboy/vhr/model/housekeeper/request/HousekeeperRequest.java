package org.javaboy.vhr.model.housekeeper.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.javaboy.vhr.model.EducationalExperience;
import org.javaboy.vhr.model.HousekeeperAdditional;
import org.javaboy.vhr.model.ServiceExperience;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HousekeeperRequest implements Serializable {

    private static final long serialVersionUID = 1752825341699844436L;

    private Long id;

    /**
     * 家政人员类型
     */
    private String type;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别
     */
    private String gender;

    /**
     * 民族
     */
    private String nation;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 状态
     */
    private String status;

    /**
     * 学历
     */
    private String education;

    /**
     * 毕业院校
     */
    private String graduateSchool;

    /**
     * 专业
     */
    private String specializedSubject;

    /**
     * 婚姻状态
     */
    private String marriage;

    /**
     * 户籍省份
     */
    private String drProvince;

    /**
     * 户籍城市
     */
    private String drCity;

    /**
     * 户籍区县
     */
    private String drArea;

    /**
     * 户籍详细地址
     */
    private String drDetails;

    /**
     * 现居地省份
     */
    private String crProvince;

    /**
     * 现居地城市
     */
    private String crCity;

    /**
     * 现居地区县
     */
    private String crArea;

    /**
     * 现居地详细地址
     */
    private String crDetails;

    /**
     * 目标城市
     */
    private String targetCity;

    /**
     * 自我介绍
     */
    private String introduction;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date modifiedTime;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 附加信息
     */
    private List<HousekeeperAdditional> housekeeperAdditions;

    /**
     * 教育经验
     */
    private List<EducationalExperience> educationalExperiences;

    /**
     * 服务经验
     */
    private List<ServiceExperience> serviceExperiences;

}
