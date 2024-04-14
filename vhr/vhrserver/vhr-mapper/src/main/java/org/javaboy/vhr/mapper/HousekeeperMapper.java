package org.javaboy.vhr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.javaboy.vhr.model.Housekeeper;

/**
 * <p>
 * 主键 Mapper 接口
 * </p>
 *
 * @author wsp
 * @since 2024-04-14
 */

@Mapper
public interface HousekeeperMapper extends BaseMapper<Housekeeper> {

    Housekeeper findById(Long id);

}
