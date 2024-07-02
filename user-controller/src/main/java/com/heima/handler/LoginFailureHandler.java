package com.heima.handler;

import cn.hutool.json.JSONUtil;
import com.heima.response.common.BaseResponse;
import com.heima.response.common.CaptchaException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 登录失败处理器
 *
 * @author cjw
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    /**
     * 在线处理验证失败
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();

        BaseResponse baseResponse;
        if (e instanceof CaptchaException) {
            baseResponse = new BaseResponse(false, 5002, "验证码错误", null);
        } else {
            baseResponse = new BaseResponse(false, 5002, "用户名或密码错误", null);
        }
        outputStream.write(JSONUtil.toJsonStr(baseResponse).getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}
