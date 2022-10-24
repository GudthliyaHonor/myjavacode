package com.dotk.learning.api.admin.dto.learning;

import lombok.Data;

import java.util.List;

@Data
public class LearningPlanEnrollFormDto {

    /** 姓名 */
    public List<LearningPlanDisplayDto> display;

    /** 手机号 */
    public List<LearningPlanMobileDto> mobile;

    /** 职位 */
    public List<LearningPlanPositionDto> position;

    /** 业务单位 */
    public List<LearningPlanBusinessUnitDto> businessUnit;

    /** 是否可以安排交通 0-否 1-是 */
    public Integer isTransport = 0;

    /** 是否可以安排住宿 0-否 1-是 */
    public Integer isHotel = 0;

}
