package org.javaboy.vhr.service.impl;

import org.javaboy.vhr.model.EducationalExperience;
import org.javaboy.vhr.mapper.EducationalExperienceMapper;
import org.javaboy.vhr.service.IEducationalExperienceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wsp
 * @since 2024-04-14
 */
@Service
public class EducationalExperienceServiceImpl extends ServiceImpl<EducationalExperienceMapper, EducationalExperience> implements IEducationalExperienceService {

    @Override
    public boolean saveEducationalExperiences(List<EducationalExperience> educationalExperiences) {
        if(CollectionUtils.isEmpty(educationalExperiences)) {
            return true;
        }

        return this.saveBatch(educationalExperiences);
    }
}
