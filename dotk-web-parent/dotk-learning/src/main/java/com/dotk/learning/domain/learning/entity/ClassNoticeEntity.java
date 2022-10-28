package com.dotk.learning.domain.learning.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.dotk.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
@TableName(value = "class_notice", autoResultMap = true)
public class ClassNoticeEntity extends BaseEntity {
    @TableField(exist = false)
    private Map<String, Object> params;

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(fill = FieldFill.INSERT)
    private Long aid;

    private Long learningId;

    private Integer type;

    private String name;

    private String content;

    private Integer isTop;

    private Long operator;

    private String operatorName;

    @TableField(fill = FieldFill.INSERT)
    private Long creator;

    private Long updator;

    private String updatorName;

    private Integer status;

    private Date publishTime;

    @TableField(fill = FieldFill.INSERT)
    private Date created;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updated;

    private Date deletedTime;
}
