package com.dotk.examcenter.api.admin.dto;


import com.dotk.core.utils.valid.EnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class UpdateQuestionBankDto {

    /**
     * 编号
     */
    private String no;

    /**
     * 题库名称
     */
    @NotBlank(message = "试题名称不能为空")
    private String title;



    /**
     * 试题类型
     * 1.试题库  2.练习库 3.PK库
     */
    @EnumValue(message = "试题类型 1.试题库  2.练习库 3.PK库 ",intValues ={1,2,3})
    private Integer type=1;


    /**
     * 题库是否允许被练习,1-允许 2-不允许 默认为1
     */
    @EnumValue(message = "题库是否允许被练习 1-允许 2-不允许 默认为1 ",intValues ={1,2})
    @JsonProperty(value = "is_practice")
    private Integer isPractice=1;


    /**
     * 共享给其他组织使用 1.是 0.否 默认为0
     */
    @EnumValue(message = "共享给其他组织使用 1 是 0 否",intValues ={0,1})
    @JsonProperty(value = "is_shared")
    private Integer isShared=0;


    /**
     * 是否为私密题库 1.是 0.不是
     */
    @EnumValue(message = "是否为私密题库 1 是 0 否",intValues ={0,1})
    @JsonProperty(value = "is_private")
    private Integer isPrivate=0;



    /**
     * 分类id
     */
    @JsonProperty(value = "dir_id")
    private Integer dirId;

    /**
     * 部门数组
     */
    @NotEmpty(message = "部门不能为空")
    @JsonProperty(value = "department_id")
    private List<Integer> departmentId;




}
