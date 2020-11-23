package com.commons.status;

import lombok.Getter;

@Getter
public enum ExceptionEnum {

    SUCCESS(200, "success"),
    BAD_REQUEST(400, "Bad Request"),
    MISS_TRACE_ID_ILLEGAL(401, "Missing request header x-transaction-id"),
    SIGN_FAILED(402, "sign failed"),
    SERVER_ERROR(500, "Internal system error .");



    private Integer code;
    private String message;

    ExceptionEnum(Integer code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public Integer value() {
        return code;
    }

    public int getCode() {
        return code;
    }


    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
