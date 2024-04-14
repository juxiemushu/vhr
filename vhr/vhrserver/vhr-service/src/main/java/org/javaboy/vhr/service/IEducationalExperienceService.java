package org.javaboy.vhr.service;

import org.javaboy.vhr.model.EducationalExperience;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wsp
 * @since 2024-04-14
 */
public interface IEducationalExperienceService extends IService<EducationalExperience> {

    boolean saveEducationalExperiences(List<EducationalExperience> educationalExperiences);

}
