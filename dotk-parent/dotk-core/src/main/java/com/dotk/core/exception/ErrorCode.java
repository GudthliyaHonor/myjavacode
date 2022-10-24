package com.dotk.core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorCode {
    /**
     * 错误码
     */
    private  Integer code;
    /**
     * 错误提示
     */
    private  String msg;

}
