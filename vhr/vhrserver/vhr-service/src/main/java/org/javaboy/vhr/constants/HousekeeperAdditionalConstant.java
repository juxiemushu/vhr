package org.javaboy.vhr.constants;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public interface HousekeeperAdditionalConstant {

    enum Status {

        /**
         * 有效的
         */
        VALID,

        /**
         * 失效
         */
        INVALID;

        public static HousekeeperConstant.Status match(String name) {
            if (StringUtils.isBlank(name)) {
                return null;
            }

            return Arrays.stream(HousekeeperConstant.Status.values()).filter(item -> item.name().equals(name)).findAny().orElse(null);
        }
    }

}
