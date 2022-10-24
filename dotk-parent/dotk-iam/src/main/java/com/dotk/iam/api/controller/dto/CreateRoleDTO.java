package com.dotk.iam.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;

/**
 * @author hailanzhou
 * @create 2022-10-19 13:48
 * @desc
 **/
@Data
public class CreateRoleDTO {

    @JsonProperty(value = "record")
    @Valid
    private RoleBaseDTO roleBaseDTO;

}
