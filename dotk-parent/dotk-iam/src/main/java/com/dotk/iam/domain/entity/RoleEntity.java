package com.dotk.iam.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@TableName(value = "iam_role",autoResultMap=true)
public class RoleEntity {

    private String name;
    private String description;

    private Integer classifyId;
    private Integer dataPermissionType;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<Integer> attributeDepartment;



    @TableId( type = IdType.AUTO)
    private Long id;
    @TableField(fill = FieldFill.INSERT)
    private Date created;
    @TableField(fill = FieldFill.INSERT)
    private Integer createdBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updated;
    @TableField(fill = FieldFill.UPDATE)
    private Integer updatedBy;
    @TableLogic(value = "1",delval = "0")
    private Integer status;


}
