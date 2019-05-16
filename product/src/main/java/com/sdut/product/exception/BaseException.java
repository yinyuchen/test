package com.sdut.product.exception;

public class BaseException extends RuntimeException{

    protected Integer errorCode;

    public BaseException(Integer errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public BaseException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getErrorMsg());
        this.errorCode = errorCodeEnum.getErrorCode();
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
