package com.meituan.catering.management.shop.api.http.model.HttpResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 邓紫棋的小跟班-YU.
 * @version 1.0
 * @date 2022/4/22 17:49
 */
@Data
@AllArgsConstructor
public class CommonResponse<T> {
    private Integer code;
    private String msg;
    private T data;

    public boolean isSuccess() {
        return code == 200;
    }

    public static CommonResponse ok() {
        return new CommonResponse(200, "操作成功!", null);
    }

    public static <R> CommonResponse<R> ok(R data) {
        return new CommonResponse(200, "操作成功!", data);
    }

    public static CommonResponse fail() {
        return new CommonResponse(500, "系统错误!", null);
    }

    public static CommonResponse fail(Integer code, String msg) {
        return new CommonResponse(code, msg, null);
    }

    public static <T> CommonResponse<T> fail(Integer code, String msg, T data) {
        return new CommonResponse(code, msg, data);
    }
}
