package com.braisedpanda.model;

/**
 * @program: course-selection-system
 * @description: 公共枚举类
 * @author: chenzhen
 * @create: 2020-12-09 17:19
 **/

public enum ResponseEnum {
    SUCCESS(200, "操作成功"),
    FAIL(500, "服务器内部错误");


    private Integer code;
    private String message;

    public Integer getCode() {
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

    ResponseEnum(int code, String message){
        this.code = code;
        this.message = message;
    }


}
