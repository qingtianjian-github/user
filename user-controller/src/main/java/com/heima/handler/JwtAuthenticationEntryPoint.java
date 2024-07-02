package com.heima.handler;

import cn.hutool.json.JSONUtil;
import com.heima.response.common.BaseResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * JWT认证失败处理器
 *
 * @author cjw
 */
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    //认证失败处理
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();

        //设置返回值
        BaseResponse baseResponse = new BaseResponse(false, 5002, "请先登录", null);
        outputStream.write(JSONUtil.toJsonStr(baseResponse).getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}
