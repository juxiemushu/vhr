package org.javaboy.vhr.controller.housekeeper;

import org.javaboy.vhr.model.housekeeper.request.HousekeeperQueryRequest;
import org.javaboy.vhr.model.housekeeper.request.HousekeeperRequest;
import org.javaboy.vhr.model.housekeeper.response.HousekeeperResponse;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.common.IdRequest;
import org.javaboy.vhr.service.IHousekeeperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/housekeeper")
public class HouseKeeperController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HouseKeeperController.class);
    @Autowired
    private IHousekeeperService iHousekeeperService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public RespBean create(@RequestBody HousekeeperRequest request) {
        try {
            boolean result = iHousekeeperService.create(request);
            if (result) {
                return RespBean.ok();
            }
            return RespBean.error("家政服务建立创建失败");
        } catch (Exception e) {
            LOGGER.error("家政服务场景失败", e);
            return RespBean.error(e.getMessage());
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RespBean modify(@RequestBody HousekeeperRequest request) {
        return RespBean.ok();
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public RespBean findById(@RequestBody IdRequest idRequest) {
        return RespBean.ok();
    }

    @RequestMapping(value = "/findWithPage", method = RequestMethod.GET)
    public HousekeeperResponse findWithPage(@RequestBody HousekeeperQueryRequest request) {
        return HousekeeperResponse.builder().build();
    }

}
