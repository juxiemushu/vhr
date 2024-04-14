package org.javaboy.vhr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.javaboy.vhr.model.HousekeeperAdditional;
import org.javaboy.vhr.mapper.HousekeeperAdditionalMapper;
import org.javaboy.vhr.service.IHousekeeperAdditionalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.javaboy.vhr.service.IHousekeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Wrapper;
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
public class HousekeeperAdditionalServiceImpl extends ServiceImpl<HousekeeperAdditionalMapper, HousekeeperAdditional> implements IHousekeeperAdditionalService {

    @Autowired
    private HousekeeperAdditionalMapper mapper;

    @Override
    public boolean saveAdditions(List<HousekeeperAdditional> housekeeperAdditions) {
        if (CollectionUtils.isEmpty(housekeeperAdditions)) {
            return true;
        }

        HousekeeperAdditional additional = housekeeperAdditions.iterator().next();
        QueryWrapper<HousekeeperAdditional> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("relate_id", additional.getRelateId());
        List<HousekeeperAdditional> additionalList = mapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(additionalList)) {
            housekeeperAdditions.forEach(item -> mapper.insert(item));
            return true;
        }

        // 已存在的数据更新，不存在的数据新增
        Map<String, Long> existedAdditionMap = new HashMap<>(additionalList.size());
        additionalList.forEach(item -> existedAdditionMap.put(item.getAdditionalKey(), item.getId()));
        for (HousekeeperAdditional housekeeperAddition : housekeeperAdditions) {
            String additionalKey = housekeeperAddition.getAdditionalKey();
            if (existedAdditionMap.containsKey(additionalKey)) {
                housekeeperAddition.setId(existedAdditionMap.get(additionalKey));
                mapper.updateById(housekeeperAddition);
            } else {
                mapper.insert(housekeeperAddition);
            }
        }
        return true;
    }

}
