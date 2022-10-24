package com.dotk.iam.common.enums;

import com.dotk.core.exception.ErrorCode;

public interface ErrorCodeConstants {
    // ========== 角色相关  10101XX ============

    // ========== 角色分类  10102XX ============
    ErrorCode ROLE_CLASSIFY_EXISTS = new ErrorCode(1010201, "角色分类已存在");
    ErrorCode ROLE_CLASSIFY_NO_EXISTS = new ErrorCode(1010202, "当前角色分类不存在");
    ErrorCode ROLE_CLASSIFY_EXISTS_ROLE = new ErrorCode(1010203, "当前角色分类存在角色");
    ErrorCode ROLE_CLASSIFY_LIMIT= new ErrorCode(1010204, "角色分类至少存在一个");

}
