package com.dotk.learning.api.admin.dto.learning;

import lombok.Data;

@Data
public class LearningPlanPositionDto {

    /** 是否展示 0-否 1-是 */
    public Integer isShow = 0;

    /** 是否必填 0-否 1-是 */
    public Integer mustFill = 0;

}
