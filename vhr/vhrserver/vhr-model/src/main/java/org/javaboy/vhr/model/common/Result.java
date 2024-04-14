package org.javaboy.vhr.model.common;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Result<T> {

    private T data;

    private int code;

    private String msg;

    private Result() {

    }

    public static Result success() {
        return new Result<>();
    }

    public Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setData(data);
        return result;
    }

}
