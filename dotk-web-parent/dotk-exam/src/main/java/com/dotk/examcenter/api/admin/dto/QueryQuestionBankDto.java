package com.dotk.examcenter.api.admin.dto;

import com.dotk.core.domain.dto.PageDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;

/**
 *
 */
@Data
public class QueryQuestionBankDto {

    @JsonProperty(value = "pg")
    @Valid
    private PageDTO page;

    @JsonProperty(value = "filters")
    private FiltersDto filters;

    private SortDto sort;

}
