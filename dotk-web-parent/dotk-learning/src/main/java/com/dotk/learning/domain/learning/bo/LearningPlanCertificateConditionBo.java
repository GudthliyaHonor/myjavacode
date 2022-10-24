package com.dotk.learning.domain.learning.bo;

import lombok.Data;

@Data
public class LearningPlanCertificateConditionBo {

    /** 学习完成率 0-禁用 1-启用 */
    public Integer learningRate = 0;

    /** 大于等于 */
    public float learningCondition = 0;

    /** 结业考试成绩 0-禁用 1-启用 */
    public Integer examResult = 0;

    /** 大于等于 */
    public float examCondition = 0;

}
