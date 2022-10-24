package com.dotk.learning.domain.learning.bo;

import lombok.Data;

import java.util.List;

@Data
public class LearningPlanEnrollFormBo {

    /** 姓名 */
    public List<LearningPlanDisplayBo> display;

    /** 手机号 */
    public List<LearningPlanMobileBo> mobile;

    /** 职位 */
    public List<LearningPlanPositionBo> position;

    /** 业务单位 */
    public List<LearningPlanBusinessUnitBo> businessUnit;

    /** 是否可以安排交通 0-否 1-是 */
    public Integer isTransport = 0;

    /** 是否可以安排住宿 0-否 1-是 */
    public Integer isHotel = 0;

}
