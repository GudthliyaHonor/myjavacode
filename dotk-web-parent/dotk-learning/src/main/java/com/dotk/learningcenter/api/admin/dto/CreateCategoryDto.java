package com.dotk.learningcenter.api.admin.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class CreateCategoryDto {

    /**
     * 分类编号
     */
    private String no;

    /**
     * 分类名称
     */
    @NotBlank(message = "分类名称不能为空")
    private String title;

    /**
     * 上级分类id
     */
    @NotBlank(message = "上级分类必选")
    private Integer parent_id;
}
