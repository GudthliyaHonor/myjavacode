package com.dotk.iam.api.controller.dto;

import com.dotk.core.domain.dto.PageDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;

/**
 * @author hailanzhou
 * @create 2022-10-18 14:31
 * @desc
 **/
@Data
public class QueryRoleClassifyDTO {

    @JsonProperty(value = "pg")
    @Valid
    private PageDTO pageDTO;
}
