package com.dotk.learning.domain.learning.bo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.dotk.core.domain.dto.PageDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClassNoticeBo {
    @TableField(fill = FieldFill.INSERT)
    private Long aid;

    private Integer status;

    private Long learningId;

    private String keyword;

    private Integer page;

    private Integer size;
}
