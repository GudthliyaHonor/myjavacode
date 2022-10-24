package com.dotk.learning.api.admin.dto.learning;

import lombok.Data;

@Data
public class LearningPlanEnrollSettingDto {

    /** 是否允许取消报名 0-否 1-是 */
    public Integer cancleEnroll = 0;

    /** 取消报名截止时间 */
    public String cancelDeadline;

    /** 是否开启候补 0-否 1-是 */
    public Integer alternateSetting = 0;

    /** 是否自定义时间 0-否 1-是 */
    public Integer customEnrollTime = 1;

    /** 报名开始时间 */
    public String enrollStarted;

    /** 报名结束时间 */
    public String enrollEnded;

}
