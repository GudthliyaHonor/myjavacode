package com.dotk.learning.domain.notice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ClassNoticeEntity {

    private Integer id;

    private Integer aid = 1018;

    @JsonProperty("learning_id")
    private Integer learningId;

    private Integer type = 1;

    private String name;

    private String content;

    @JsonProperty("is_top")
    private Integer isTop;

    private Integer operator = 0;

    @JsonProperty("operator_name")
    private String operatorName = "";

    private Integer creator = 0;

    private Integer updator = 0;

    @JsonProperty("updator_name")
    private String updatorName = "";

    private Integer status;

    @JsonProperty("publish_time")
    private Date publishTime = new Date();

    private Date created = new Date();

    private Date updated = new Date();
}
