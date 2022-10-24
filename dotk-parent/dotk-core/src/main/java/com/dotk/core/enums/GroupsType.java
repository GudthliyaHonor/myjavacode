package com.dotk.core.enums;

/**
 * 人员条件类型
 */
public enum GroupsType {
    GROUPS_TYPE_ALL(1, "全公司"),
    GROUPS_TYPE_DEPT(2, "指定部门"),
    GROUPS_TYPE_GROUP(3, "指定人群"),
    GROUPS_TYPE_EMP(4, "指定人员"),
    GROUPS_TYPE_POSITION(5, "指定岗位"),
    GROUPS_TYPE_JOB_LEVEL(6, "指定职级"),
    ;

    private final Integer code;
    private final String info;

    GroupsType(Integer code, String info) {
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
