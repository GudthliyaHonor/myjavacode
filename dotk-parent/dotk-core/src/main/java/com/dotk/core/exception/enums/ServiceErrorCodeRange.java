package com.dotk.core.exception.enums;

/**
 * 业务异常的错误码区间，
 * 解决：解决各模块错误码定义，避免重复
 *
 * 一共 7 位，分成四段
 *
 * 第一段，1 位，类型
 *      1 - 业务级别异常
 *      x - 预留
 * 第二段，2 位，系统类型
 *      01 - IAM系统
 *      02 - OAUTH系统
 *      03 - 考试中心系统
 * 第三段，2 位，模块
 *      01 角色模块
 *      02 功能权限部分
 *      一般建议，每个系统里面，可能有多个模块，可以再去做分段。以用户系统为例子：
 * 第四段，2 位，错误码
 *       不限制规则。
 *       01 角色重复
 *       02 角色已删除
 *       一般建议，每个模块自增。
 *
 * @author hailanzhou
 */
public class ServiceErrorCodeRange {
    // iam系统 业务类型为 01

}
