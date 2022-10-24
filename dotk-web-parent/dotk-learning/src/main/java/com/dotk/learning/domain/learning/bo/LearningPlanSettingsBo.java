package com.dotk.learning.domain.learning.bo;

import lombok.Data;

@Data
public class LearningPlanSettingsBo {

    /** 最先完成学习计划占比多少 */
    public float finishedFirst = 0;

    /** 最先完成学习计划奖励学分 */
    public float finishedFirstCredit = 0;

    /** 是否允许超时学习 0-否 1-是 */
    public Integer overtimeLearn = 1;

}
