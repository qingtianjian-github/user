package com.heima.config;

import com.heima.response.common.BaseResponse;
import com.heima.response.common.ResultEnum;
import com.heima.response.common.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 *
 * @author cjw
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 定义要捕获的异常 可以多个 @ExceptionHandler({})     *
     *
     * @param request  request
     * @param e        exception
     * @param response response
     * @return 响应结果
     */
    @ExceptionHandler(ServiceException.class)
    public BaseResponse customExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
        log.error("全局异常处理器捕获异常:", e);
        return new BaseResponse(ResultEnum.ERROR.getSuccess(), ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMessage(), null);
    }

    /**
     * 全局捕获异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public BaseResponse handler(Exception e) {
        log.error("全局异常处理器捕获异常:", e);
        return new BaseResponse(ResultEnum.ERROR.getSuccess(), ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMessage(), null);
    }

    /*@ExceptionHandler(NotLoginException.class)
    public BaseResponse tokenExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
        log.error("token exception", e);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        return new BaseResponse(ResultEnum.SUCCESS.getSuccess(), ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), new ArrayList<>());
    }*/
}
