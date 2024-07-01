package com.heima.response.common;

public class ServiceException extends RuntimeException {

    private final ResultEnum code;

    public ServiceException() {
        super(String.format("%s", ResultEnum.ERROR.getMessage()));
        this.code = ResultEnum.ERROR;
    }

    public ServiceException(Throwable e) {
        super(e);
        this.code = ResultEnum.ERROR;
    }

    public ServiceException(String msg) {
        this(ResultEnum.ERROR, msg);
    }

    public ServiceException(ResultEnum code) {
        super(String.format("%s", code.getMessage()));
        this.code = code;
    }

    public ServiceException(ResultEnum code, String msg) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code.getCode();
    }
}
