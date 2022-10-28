package com.dotk.learning.domain.learning.vo;

import com.alibaba.fastjson2.JSONArray;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClassNoticeVo {
    private Integer id;

    private Integer aid;

    @JsonProperty("learning_id")
    private Integer learningId;

    private Integer type;

    private String name;

    private JSONArray content;

    @JsonProperty("is_top")
    private Integer isTop;

    private Integer operator;

    @JsonProperty("operator_name")
    private String operatorName;

    private Integer creator;

    private Integer updator;

    @JsonProperty("updator_name")
    private String updatorName;

    private Integer status;

    @JsonProperty("publish_time")
    private Long publishTime;

    private Long created;

    private Long updated;
}
