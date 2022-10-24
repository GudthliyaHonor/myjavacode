package com.dotk.learning.domain.learning.bo;

import lombok.Data;

@Data
public class LearningPlanUnlockDetailBo {

    /** 解锁周期 0-立即 1-第二天 2-下一周 */
    public Integer period = 0;

    /** 0-全部 1-周一/1号 2-周二/2号 */
    public Integer date = 0;

}
