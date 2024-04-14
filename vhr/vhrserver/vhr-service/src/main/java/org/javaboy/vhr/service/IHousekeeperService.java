package org.javaboy.vhr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.javaboy.vhr.model.Housekeeper;
import org.javaboy.vhr.model.common.IdRequest;
import org.javaboy.vhr.model.housekeeper.request.HousekeeperQueryRequest;
import org.javaboy.vhr.model.housekeeper.request.HousekeeperRequest;
import org.javaboy.vhr.model.housekeeper.response.HousekeeperResponse;

import java.util.List;

/**
 * <p>
 * 主键 服务类
 * </p>
 *
 * @author wsp
 * @since 2024-04-14
 */
public interface IHousekeeperService extends IService<Housekeeper> {

    boolean create(HousekeeperRequest request);

    boolean modify(HousekeeperRequest request);

    HousekeeperResponse findById(IdRequest idRequest);

    List<HousekeeperResponse> findWithPage(HousekeeperQueryRequest queryRequest);

}
