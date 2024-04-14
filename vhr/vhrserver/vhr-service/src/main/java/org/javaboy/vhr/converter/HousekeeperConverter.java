package org.javaboy.vhr.converter;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.javaboy.vhr.constants.EducationalExperienceConstant;
import org.javaboy.vhr.constants.HousekeeperAdditionalConstant;
import org.javaboy.vhr.model.EducationalExperience;
import org.javaboy.vhr.model.Housekeeper;
import org.javaboy.vhr.model.HousekeeperAdditional;
import org.javaboy.vhr.model.ServiceExperience;
import org.javaboy.vhr.model.housekeeper.request.HousekeeperRequest;
import org.javaboy.vhr.utils.DateUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class HousekeeperConverter {

    public static Housekeeper convert(HousekeeperRequest source) {
        if (Objects.isNull(source)) {
            return null;
        }
        return Housekeeper.builder()
                .id(source.getId())
                .type(source.getType())
                .name(source.getName())
                .avatar(source.getAvatar())
                .gender(source.getGender())
                .nation(source.getNation())
                .age(source.getAge())
                .mobile(source.getMobile())
                .phone(source.getPhone())
                .status(source.getStatus())
                .education(source.getEducation())
                .graduateSchool(source.getGraduateSchool())
                .specializedSubject(source.getSpecializedSubject())
                .marriage(source.getMarriage())
                .drProvince(source.getDrProvince())
                .drCity(source.getDrCity())
                .drArea(source.getDrArea())
                .drDetails(source.getDrDetails())
                .crProvince(source.getCrProvince())
                .crCity(source.getCrCity())
                .crArea(source.getCrArea())
                .crDetails(source.getCrDetails())
                .targetCity(source.getTargetCity())
                .introduction(source.getIntroduction())
                .creator(source.getCreator())
                .createTime(DateUtils.now())
                .modifier(source.getModifier())
                .modifiedTime(DateUtils.now())
                .version(source.getVersion())
                .build();
    }

    public static List<HousekeeperAdditional> convertAdditions(HousekeeperRequest source) {
        if (Objects.isNull(source)) {
            return Collections.emptyList();
        }

        if (CollectionUtils.isNotEmpty(source.getHousekeeperAdditions())) {
            return Collections.emptyList();
        }
        source.getHousekeeperAdditions().forEach(item -> {
            if (StringUtils.isBlank(item.getStatus())) {
                item.setStatus(HousekeeperAdditionalConstant.Status.VALID.name());
            }
            item.setCreateTime(DateUtils.now());
            item.setModifiedTime(DateUtils.now());
        });
        return source.getHousekeeperAdditions();
    }

    public static List<EducationalExperience> convertEducationalExperiences(HousekeeperRequest source) {
        if (Objects.isNull(source)) {
            return Collections.emptyList();
        }

        if (CollectionUtils.isNotEmpty(source.getEducationalExperiences())) {
            return Collections.emptyList();
        }
        source.getEducationalExperiences().forEach(item -> {
            if (StringUtils.isBlank(item.getStatus())) {
                item.setStatus(EducationalExperienceConstant.Status.VALID.name());
            }
            item.setCreateTime(DateUtils.now());
            item.setModifiedTime(DateUtils.now());
        });
        return source.getEducationalExperiences();
    }

    public static List<ServiceExperience> convertServiceExperiences(HousekeeperRequest source) {
        if (Objects.isNull(source)) {
            return Collections.emptyList();
        }

        if (CollectionUtils.isNotEmpty(source.getServiceExperiences())) {
            return Collections.emptyList();
        }
        return source.getServiceExperiences();
    }

}
