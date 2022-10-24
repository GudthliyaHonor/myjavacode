package com.dotk.iam.api.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author hailanzhou
 * @create 2022-10-18 14:31
 * @desc
 **/
@Data
public class DeleteRoleClassifyDTO {

    @NotNull(message = "角色分类ID不能为空")
    private Long id;
}
