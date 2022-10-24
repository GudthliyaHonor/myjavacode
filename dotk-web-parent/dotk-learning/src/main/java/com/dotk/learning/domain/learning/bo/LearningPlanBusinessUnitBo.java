package com.dotk.learning.domain.learning.bo;

import lombok.Data;

@Data
public class LearningPlanBusinessUnitBo {

    /** 是否展示 0-否 1-是 */
    public Integer isShow = 0;

    /** 是否必填 0-否 1-是 */
    public Integer mustFill = 0;

}
