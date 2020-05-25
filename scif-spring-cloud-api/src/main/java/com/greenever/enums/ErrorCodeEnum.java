package com.greenever.enums;

import com.greenever.base.common.base.ErrorCode;
import com.greenever.base.common.base.IErrorCode;
import lombok.ToString;

/**
 *
 */
@ToString
public enum ErrorCodeEnum implements IErrorCode {

    SERVICE_ERROR("1005000", "系统繁忙，请稍后再试"),
    PARAM_ERROR("1005001", "参数错误");

    private final IErrorCode errorCode;

    ErrorCodeEnum(String code, String desc) {
        this.errorCode = new ErrorCode(code, desc);
    }

    @Override
    public String getCode() {
        return errorCode.getCode();
    }

    @Override
    public String getMsg(Object... params) {
        return errorCode.getMsg(params);
    }


}