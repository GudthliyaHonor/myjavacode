package com.dotk.learning.domain.learning.bo;

import lombok.Data;

@Data
public class LearningPlanTouristSettingBo {

    /** 是否允许学员扫码自主加入班级 0-否 1-是 */
    public Integer joinFree = 1;

}
