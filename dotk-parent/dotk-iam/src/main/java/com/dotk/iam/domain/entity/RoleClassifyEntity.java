package com.dotk.iam.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @author hailanzhou
 * @create 2022-10-18 14:03
 * @desc
 **/
@Data
@TableName(value = "iam_role_classify",autoResultMap=true)
public class RoleClassifyEntity {

    private String name;
    private Integer count;
    private String creatorDisplay;

    @TableId( type = IdType.AUTO)
    private Long id;

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
    @TableLogic(value = "1",delval = "0")
    private Integer status;
}
