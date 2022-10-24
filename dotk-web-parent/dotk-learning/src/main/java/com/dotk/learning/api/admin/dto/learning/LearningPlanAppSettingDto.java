package com.dotk.learning.api.admin.dto.learning;

import lombok.Data;

@Data
public class LearningPlanAppSettingDto {

    /** 是否启用互动任务 0-否 1-是 */
    public Integer interactionEnabled = 0;

    /** 是否启用学习广场 0-否 1-是 */
    public Integer learnSquareEnabled = 0;

    /** 是否启用排行榜 0-否 1-是 */
    public Integer rankingEnabled = 0;

    /** 是否启用学习群 0-否 1-是 */
    public Integer learningGroupEnabled = 0;

    /** 是否启用公告 0-否 1-是 */
    public Integer noticeEnabled = 0;

    /** 是否开启自主报名 0-否 1-是 */
    public Integer isEnroll = 0;

    /** 是否开启结业考试 0-否 1-是 */
    public Integer isExam = 0;

    /** 是否开启班级评估 0-否 1-是 */
    public Integer isAssess = 0;

    /** 是否开启班级评分 0-否 1-是 */
    public Integer isPointScore = 0;

}
