package com.dotk.web.api.dto;



import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ValidDTo {
    private String id;

    @Length(min = 6,max = 12,message = "appId长度必须位于6到12之间")
    @NotNull(message = "appId参数不能为空")
    private String appId;

    @NotBlank(message = "名字为必填项")
    private String name;

    @Email(message = "请填写正确的邮箱地址")
    private String email;

    @NotEmpty(message = "级别不能为空")
    private String level;
}
