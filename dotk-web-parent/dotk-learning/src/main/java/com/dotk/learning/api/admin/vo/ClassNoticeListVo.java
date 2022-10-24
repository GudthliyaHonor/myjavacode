package com.dotk.learning.api.admin.vo;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.mapstruct.Mapper;

import java.util.Date;

@Data
public class ClassNoticeListVo {
    private Integer id;

    private Integer aid;

    @JsonProperty("learning_id")
    private Integer learningId;

    private Integer type;

    private String name;

    private String content;

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
    private Date publishTime;

    private Date created;

    private Date updated;
}
