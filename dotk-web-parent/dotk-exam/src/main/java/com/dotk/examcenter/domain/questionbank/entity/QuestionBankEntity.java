package com.dotk.examcenter.domain.questionbank.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@TableName(value = "question_bank",autoResultMap=true)
public class QuestionBankEntity {

    @TableId( type = IdType.AUTO)
    private Long id;


    private Integer type;

    private Integer dirId;


    private String title;



    private Integer isPractice;

    private Integer isShared;

    private Integer isPrivate;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<Integer> departmentId;


    @TableField(fill = FieldFill.INSERT)
    private Integer aid;

    @TableField(fill = FieldFill.INSERT)
    private Date created;
    @TableField(fill = FieldFill.INSERT)
    private Integer createdBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updated;
    @TableField(fill = FieldFill.UPDATE)
    private Integer updatedBy;
    @TableLogic
    private Integer status;
}
