package com.heima.response.common;

import org.springframework.security.core.AuthenticationException;

import java.io.Serializable;

/**
 * 自定义验证码异常
 *
 * @author cjw
 */
public class CaptchaException extends AuthenticationException implements Serializable {
    private static final long serialVersionUID = -3512779871152414573L;

    public CaptchaException(String msg) {
        super(msg);
    }
}
