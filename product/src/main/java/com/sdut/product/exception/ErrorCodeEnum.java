package com.sdut.product.exception;

/**
 * 错误码
 * @author ZHangYJ
 */
public enum ErrorCodeEnum {

    /**
     * 无用户
     */
    UsernameOrPasswordERROR(100000, "用户名或密码错误");



    /**
     * 错误码
     */
    private final Integer errorCode;

    /**
     * 错误描述
     */
    private final String errorMsg;

    ErrorCodeEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
