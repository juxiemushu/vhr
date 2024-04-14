package org.javaboy.vhr.constants;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public interface HousekeeperConstant {

    enum Type {

        /**
         * 家庭教师
         */
        HOME_TUTOR,

        /**
         * 陪伴师
         */
        COMPANION;

        public static Type match(String name) {
            if (StringUtils.isBlank(name)) {
                return null;
            }

            return Arrays.stream(Type.values()).filter(item -> item.name().equals(name)).findAny().orElse(null);
        }
    }

    enum Gender {

        /**
         * 男性
         */
        MEN,

        /**
         * 女性
         */
        WOMEN,

        /**
         * 未知
         */
        UNKNOWN;

        public static Gender match(String name) {
            if (StringUtils.isBlank(name)) {
                return null;
            }

            return Arrays.stream(Gender.values()).filter(item -> item.name().equals(name)).findAny().orElse(null);
        }
    }

    enum Status {

        /**
         * 有效的
         */
        VALID,

        /**
         * 失效
         */
        INVALID;

        public static Status match(String name) {
            if (StringUtils.isBlank(name)) {
                return null;
            }

            return Arrays.stream(Status.values()).filter(item -> item.name().equals(name)).findAny().orElse(null);
        }
    }

    enum Education {

        /**
         * 博士
         */
        DOCTOR,

        /**
         * 硕士
         */
        MASTER,

        /**
         * 学士
         */
        BACHELOR,

        /**
         * 高中生
         */
        HIGH_SCHOOL_STUDENT,

        /**
         * 初中
         */
        MID_SCHOOL_STUDENT;

        public static Education match(String name) {
            if (StringUtils.isBlank(name)) {
                return null;
            }

            return Arrays.stream(Education.values()).filter(item -> item.name().equals(name)).findAny().orElse(null);
        }
    }

    enum Marriage {

        /**
         * 未婚
         */
        UNMARRIED,

        /**
         * 已婚
         */
        MARRIED,

        /**
         * 离异
         */
        DIVORCE,

        /**
         * 未知
         */
        UNKNOWN;

        public static Marriage match(String name) {
            if (StringUtils.isBlank(name)) {
                return null;
            }

            return Arrays.stream(Marriage.values()).filter(item -> item.name().equals(name)).findAny().orElse(null);
        }
    }

}
