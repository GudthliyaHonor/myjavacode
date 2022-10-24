package com.dotk.knowledge.api.admin.dto;

public class BaseResult {
    /**
     * 状态码：0成功，其他为失败
     */
    public int code;

    /**
     * 成功为ok，其他为失败原因
     */
    public String message;

    /**
     * 数据结果集
     */
    public Object data;

    public BaseResult ok() {
        this.code = 0;
        this.message = "ok";
        return this;
    }

    public BaseResult error() {
        this.code = -1;
        this.message = "error";
        return this;
    }

    public BaseResult invalidParameter() {
        this.code = -1;
        this.message = "INVALID_PARAMETER";
        return this;
    }

    public BaseResult data(Object data) {
        this.data = data;
        return this;
    }
}
