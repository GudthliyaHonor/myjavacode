package com.dotk.learningcenter.domain.category.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@TableName(value = "learning_category",autoResultMap=true)
public class CategoryEntity {

    @TableId( type = IdType.AUTO)
    private Long id;

    private String no;

    private String title;

    private Integer parent_id;

    private String parent_name;

    private String path;

    private String path_name;

    private Integer creator_eid;

    private String creator_no;

    private String creator_display;

    private Integer last_eid;

    private Integer enabled;

    private Integer level;

    private Integer order;

//    @TableField(typeHandler = JacksonTypeHandler.class)
//    private List<Integer> departmentId;
//
//
//    @TableField(fill = FieldFill.INSERT)
//    private Integer aid;
//
//    @TableLogic
//    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private Date created;
    @TableField(fill = FieldFill.INSERT)
    private Integer createdBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updated;
    @TableField(fill = FieldFill.UPDATE)
    private Integer updatedBy;
}
