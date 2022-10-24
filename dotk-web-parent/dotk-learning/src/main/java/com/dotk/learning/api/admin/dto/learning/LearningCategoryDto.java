package com.dotk.learning.api.admin.dto.learning;

import lombok.Data;

@Data
public class LearningCategoryDto {

    /** 分类ID */
    public Integer id;

    /** 分类编号 */
    public String no;

    /** 分类名称*/
    public String name;
}
