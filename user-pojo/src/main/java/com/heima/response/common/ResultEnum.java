package com.heima.response.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {

    SUCCESS(true, 0, "操作成功"),
    BAD_REQUEST(false, 400, "参数错误"),
    UNAUTHORIZED(false, 401, "未授权，请登录"),
    NOT_FOUND(false, 404, "找不到请求的资源"),
    ERROR(false, 5002, "业务处理失败");

    private Boolean success;
    private Integer code;
    private String message;
}
