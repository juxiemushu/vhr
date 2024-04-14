package org.javaboy.vhr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.javaboy.vhr.mapper.HousekeeperMapper;
import org.javaboy.vhr.model.Housekeeper;
import org.javaboy.vhr.service.IHousekeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private HousekeeperMapper housekeeperMapper;

}
