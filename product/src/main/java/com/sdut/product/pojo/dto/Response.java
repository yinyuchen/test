package com.sdut.product.pojo.dto;

import com.sdut.product.exception.ErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 *
 * @author ZHangYJ
 */
@AllArgsConstructor
@Data
public class Response<T> {

    private Integer code;

    private String msg;

    private T data;

    public Response(int value, String s, T data) {
    }

    public static <T> Response<T> success(T data){
        return new Response<>(HttpStatus.OK.value(), "", data);
    }

    public static <T> Response<T> success(Integer code, String msg){
        return new Response<>(code, msg, null);
    }

    public static <T> Response<T> error(T data){
        return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "", data);
    }

    public static <T> Response<T> error(ErrorCodeEnum errorCodeEnum){
        return new Response<>(errorCodeEnum.getErrorCode(), errorCodeEnum.getErrorMsg(), null);
    }

    public static <T> Response<T> error(Integer code, String msg){
        return new Response<>(code, msg, null);
    }

}
