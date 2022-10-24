package com.dotk.examcenter.api.admin.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class FiltersDto {

    private Integer type;
    @JsonProperty("list_type")
    private Integer listType;
    @JsonProperty("excludedIds")
    private List<Integer> excludedIds;
    @JsonProperty("is_effective_time")
    private Integer isEffectiveTime;
    @JsonProperty("dirId")
    private Integer dir_id;
    @JsonProperty("questionType")
    private Integer question_type;
}
