package org.javaboy.vhr.service.impl;

import org.javaboy.vhr.model.HousekeeperAdditional;
import org.javaboy.vhr.mapper.HousekeeperAdditionalMapper;
import org.javaboy.vhr.service.IHousekeeperAdditionalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wsp
 * @since 2024-04-14
 */
@Service
public class HousekeeperAdditionalServiceImpl extends ServiceImpl<HousekeeperAdditionalMapper, HousekeeperAdditional> implements IHousekeeperAdditionalService {
    @Override
    public boolean saveAdditions(List<HousekeeperAdditional> housekeeperAdditions) {
        if (CollectionUtils.isEmpty(housekeeperAdditions)) {
            return true;
        }

        return this.saveBatch(housekeeperAdditions);
    }

}
