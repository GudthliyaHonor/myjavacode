package com.dotk.core.enums;

/**
 * 学习模块类型
 */
public enum LearningType {
    LEARNING_CLASS(0, "智能班级"),
    LEARNING_PACK(1, "学习包"),
    LEARNING_BREAKTHROUGH(2, "闯关"),
    LEARNING_PLAN(3, "学习任务"),
    LEARNING_TRAINING(4, "外派培训"),
    LEARNING_TEACHING(5, "带教"),
    LEARNING_MAP(6, "知识学习地图"),
    LEARNING_MAP_BUSINESS(7, "业务学习地图"),
    LEARNING_APPRAISAL(8, "鉴定"),
    LEARNING_AUTONOMY(9, "自主学习计划"),
    LEARNING_INSPECTION(10, "巡店"),
    RETRAINING(11, "认证与再培训"),
    LEARNING_POSITION(12, "岗位学习地图"),
    LEARNING_MARKETING(13, "营销一体化"),
    LEARNING_TEACHING_TEACHER(14, "带教导师"),
    LEARNING_TEACHING_LEARNER(15, "带教员工"),
    LEARNING_TEACHING_CC(16, "带教抄送人"),
    LEARNING_POSITION_AUTHENTICATION(17, "岗位认证学习计划"),
    LEARNING_REPEAT(18, "重复学习"),
    SYMBOL_STATEMENT(19, "勋章报表"),
    ;

    private final Integer code;
    private final String info;

    LearningType(Integer code, String info) {
        this.code = code;
        this.info = info;
    }

    public Integer getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
