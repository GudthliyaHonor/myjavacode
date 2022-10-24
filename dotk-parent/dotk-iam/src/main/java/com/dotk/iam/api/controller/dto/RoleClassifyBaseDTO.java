package com.dotk.iam.api.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author hailanzhou
 * @create 2022-10-18 14:31
 * @desc
 **/
@Data
public class RoleClassifyBaseDTO {

    @NotBlank(message = "分类名称不能为空")
    @Size(max = 50, message = "角色分类名称长度不能超过50个字符")
    private String name;
}
