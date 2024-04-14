package org.javaboy.vhr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.javaboy.vhr.constants.HousekeeperConstant;
import org.javaboy.vhr.converter.HousekeeperConverter;
import org.javaboy.vhr.mapper.HousekeeperMapper;
import org.javaboy.vhr.model.EducationalExperience;
import org.javaboy.vhr.model.Housekeeper;
import org.javaboy.vhr.model.HousekeeperAdditional;
import org.javaboy.vhr.model.common.IdRequest;
import org.javaboy.vhr.model.housekeeper.request.HousekeeperQueryRequest;
import org.javaboy.vhr.model.housekeeper.request.HousekeeperRequest;
import org.javaboy.vhr.model.housekeeper.response.HousekeeperResponse;
import org.javaboy.vhr.service.IEducationalExperienceService;
import org.javaboy.vhr.service.IHousekeeperAdditionalService;
import org.javaboy.vhr.service.IHousekeeperService;
import org.javaboy.vhr.service.IServiceExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 主键 服务实现类
 * </p>
 *
 * @author wsp
 * @since 2024-04-14
 */
@Service
public class HousekeeperServiceImpl extends ServiceImpl<HousekeeperMapper, Housekeeper> implements IHousekeeperService {

    @Autowired
    private IHousekeeperAdditionalService iHousekeeperAdditionalService;

    @Autowired
    private IEducationalExperienceService iEducationalExperienceService;

    @Autowired
    private IServiceExperienceService iServiceExperienceService;

    @Autowired
    private HousekeeperMapper housekeeperMapper;
    @Override
    public boolean create(HousekeeperRequest request) {
        Housekeeper housekeeper = HousekeeperConverter.convert(request);
        if(Objects.isNull(housekeeper)) {
            throw new RuntimeException("简历信息为空");
        }
        housekeeper = housekeeperMapper.findById(1L);
        housekeeperMapper.insert(housekeeper);
        Long housekeeperId = housekeeper.getId();
        // 保存附加信息
        List<HousekeeperAdditional> housekeeperAdditions = HousekeeperConverter.convertAdditions(request);
        iHousekeeperAdditionalService.saveAdditions(housekeeperAdditions);
        // 保存教育经历信息
        List<EducationalExperience> educationalExperiences = HousekeeperConverter.convertEducationalExperiences(request);
        iEducationalExperienceService.saveEducationalExperiences(educationalExperiences);
        return true;
    }

    @Override
    public boolean modify(HousekeeperRequest request) {
        return false;
    }

    @Override
    public HousekeeperResponse findById(IdRequest idRequest) {
        return null;
    }

    @Override
    public List<HousekeeperResponse> findWithPage(HousekeeperQueryRequest queryRequest) {
        return null;
    }

}
