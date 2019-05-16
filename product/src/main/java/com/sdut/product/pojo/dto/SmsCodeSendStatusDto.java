package com.sdut.product.pojo.dto;

import com.sdut.product.exception.ErrorCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("短信验证码发送状态")
@Data
public class SmsCodeSendStatusDto {

    @ApiModelProperty("短信发送状态:<br>" +
            "100002-验证码发送成功，<br>" +
            "100004-访问太多受到限制，<br>" +
            "100003-验证码已发送，请超过60秒后重试,<br>" +
            "100005-短信发送失败，请重试，<br>" +
            "100006-访问频繁需要通过滑动验证码验证<br>")
    private int sendStatus;
    @ApiModelProperty("短信发送提示:100002,100003,100004,100005相应描述")
    private String message;

    public SmsCodeSendStatusDto(ErrorCodeEnum errorCodeEnum) {
        this.sendStatus = errorCodeEnum.getErrorCode();
        this.message = errorCodeEnum.getErrorMsg();
    }
}
