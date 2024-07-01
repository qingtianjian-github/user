package com.heima.response.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 服务返回值
 *
 * @author cjw
 */
@AllArgsConstructor
@Data
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = -1552926693612326075L;

    private Boolean success;
    private Integer code;
    private String message;
    private Object data;
}
