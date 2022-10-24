package com.dotk.examcenter.domain.questionbank.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class QuestionBankInfoVo {

    private Long id;

    private String title;

    @JsonProperty(value = "is_practice")
    private Integer isPractice;

    @JsonProperty(value = "dir_id")
    private Integer dirId;

    private Integer type;

    @JsonProperty(value = "is_shared")
    private Integer isShared;

    @JsonProperty(value = "department_id")
    private List<Integer> departmentId;

    @JsonProperty(value = "is_private")
    private Integer isPrivate=0;


}
