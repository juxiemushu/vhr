package org.javaboy.vhr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.javaboy.vhr.model.EducationalExperience;
import org.javaboy.vhr.mapper.EducationalExperienceMapper;
import org.javaboy.vhr.service.IEducationalExperienceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wsp
 * @since 2024-04-14
 */
@Service
public class EducationalExperienceServiceImpl extends ServiceImpl<EducationalExperienceMapper, EducationalExperience> implements IEducationalExperienceService {

    @Autowired
    private EducationalExperienceMapper mapper;

    @Override
    public boolean saveEducationalExperiences(List<EducationalExperience> educationalExperiences) {
        if (CollectionUtils.isEmpty(educationalExperiences)) {
            return true;
        }

        // 查询已存在的数据
        EducationalExperience experience = educationalExperiences.iterator().next();
        QueryWrapper<EducationalExperience> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("relate_type", experience.getRelateType());
        queryWrapper.eq("relate_id", experience.getRelateId());
        List<EducationalExperience> experienceList = mapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(experienceList)) {
            educationalExperiences.forEach(item -> mapper.insert(item));
            return true;
        }

        // 已存在的数据更新，不存在的数据新增
        Map<String, Long> existedExperienceMap = new HashMap<>(experienceList.size());
        experienceList.forEach(item -> existedExperienceMap.put(item.getType(), item.getId()));
        for (EducationalExperience educationalExperience : educationalExperiences) {
            String experienceType = educationalExperience.getType();
            if (existedExperienceMap.containsKey(experienceType)) {
                educationalExperience.setId(existedExperienceMap.get(experienceType));
                mapper.updateById(educationalExperience);
            } else {
                mapper.insert(educationalExperience);
            }
        }
        return true;
    }
}
