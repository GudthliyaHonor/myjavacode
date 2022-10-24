package com.dotk.core.exception;

import com.dotk.core.domain.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

//
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 参数校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public AjaxResult handleDemoModeException(BindException e)
    {
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return AjaxResult.error(message);
    }


    @ExceptionHandler(ValidationException.class)
    public AjaxResult handleDemoModeException(ValidationException e)
    {
        String message = e.getMessage();
        return AjaxResult.error(message);
    }

    /**
     * Http请求消息序列化异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public AjaxResult messageExceptionHandler(HttpMessageNotReadableException e) {
        log.warn("http请求参数转换异常: "+ e.getMessage());
        return AjaxResult.error("请求参数转化异常");
    }


    @ExceptionHandler(ServiceException.class)
    public AjaxResult handleDemoModeException(ServiceException e)
    {
        String message = e.getMessage();
        return AjaxResult.error(e.getCode(),message);
    }

}
