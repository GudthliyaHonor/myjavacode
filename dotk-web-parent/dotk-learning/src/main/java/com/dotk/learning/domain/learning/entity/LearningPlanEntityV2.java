//package com.dotk.learning.domain.learning.entityV2;
//
//import com.dotk.core.domain.BaseEntity;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.Data;
//import java.util.Date;
//
//@Data
//public class LearningPlanEntityV2 extends BaseEntity {
//
//  /** 班级id */
//  public Long id;
//
//  /** 公司id */
//  public int aid;
//
//  /** relation_id */
//  public int relation_id;
//
//  /** delay_reason */
//  public String delay_reason;
//
//  /** 项目类型 */
//  public int type;
//
//  /** 条目状态 0删除 1正常 */
//  public Integer status;
//
//  /** 班级编号 */
//  public String no;
//
//  /** 班级名称 */
//  public String name;
//
//  /** 开始时间 */
//  public String startTime;
//
//  /** 结束时间 */
//  public String endTime;
//
//  /** 发布状态 1草稿 2发布 */
//  @JsonProperty("publish_status")
//  public Integer publishStatus = 1;
//
//  /** 多班次ID 对标 project_id*/
//  public Integer projectId = 0;
//
//  /** 多班次名称 对标 project_name*/
//  public String projectName;
//
//  /** 来源 0默认 1培训计划*/
//  public Integer source = 0;
//
//  /** 培训计划ID 对标 project_id*/
//  public Integer trainingProgram_id = 0;
//
//  /** 培训计划名称 对标 project_name*/
//  public String trainingProgramName;
//
//  /** 项目目标 */
//  public String desc;
//
//  /** 签呈编码 */
//  public String petitionCode;
//
//  /** 任务顺序 0无序 1有序 */
//  public Integer isOrder = 0;
//
//  /** 智能班级是否开启报名 0否 1是 */
//  public Integer isApplicant = 0;
//
//  /** 智能班级-报名权限 0所有人 1指定人 */
//  public Integer applicantAuth = 0;
//
//  /** 智能班级-人数限制 */
//  public Integer limit_learner = 0;
//
//  /** 智能班级-是否开启报名审核 0不审核 1审核 2部门经理审核 3直属上级审核 */
//  public Integer is_examine = 0;
//
//  /** 解锁条件
//   0-不限定
//   1-按阶段，阶段内任务不按顺序  (完成上一任务，下一任务立即解锁)
//   2-按阶段，阶段内任务按顺序
//   3-按阶段时间，阶段内任务不按顺序,
//   4-按阶段时间，阶段内任务按顺序,
//   5-按阶段打卡，
//   6-按任务打卡'
//   */
//  public Integer unlock_con = 0;
//
//  /** 解锁周期 */
//  public String unlock_detail;
//
//  /** 选修范围 */
//  public String elective_range;
//
//  /** 指定的报名范围 EmployeeRange */
//  public String applied_range;
//
//  /** 管理员 */
//  public String monitor;
//
//  /** 费用预算 */
//  public Integer costings = 0;
//
//  /** 培训大纲 */
//  public String training_outlines;
//
//  /** 项目类型 0-线上培训 1-线下培训 2-O2O混合培训 */
//  public Integer class_type = 0;
//
//  /** 上课地址 */
//  public String class_address;
//
//  /** 供应商 */
//  public String vendors;
//
//  /** 学分 */
//  public Integer credit = 0;
//
//  /** 培训时长 */
//  public float training_hours = 0;
//
//  /** 是否添加人群标签 0-否 1-是 */
//  public Integer is_add_group = 0;
//
//  /** 是否减人群标签 0-否 1-是 */
//  public Integer is_del_group = 0;
//
//  /** 加人群标签的ids */
//  public String add_groups;
//
//  /** 减人群标签的ids */
//  public String del_groups;
//
//  /** 是否同步课程学习进度 0-否 1-是 */
//  public Integer course_rate = 1;
//
//  /** 是否置顶 0-否 1-是 */
//  public Integer is_set_top = 0;
//
//  /** 调班范围 */
//  public String shift_range;
//
//  /** 报名提示 */
//  public String application_hints;
//
//  /** 智能班级-报名附加条件 */
//  public String enroll_extra_con;
//
//  /** 报名设置 */
//  public String enroll_setting;
//
//  /** 是否启用报名表单 */
//  public Integer is_enroll_form = 0;
//
//  /** 报名表单 */
//  public String enroll_form;
//
//  /** h5按钮控制 */
//  public String app_setting;
//
//  /** 颁发证书/结业条件 */
//  public String certificate_condition;
//
//  /** 开启自动结业 0-否 1-是 */
//  public Integer auto_graduation = 0;
//
//  /** 是否自动颁发证书 0-否 1-是 */
//  public Integer auto_certificate = 0;
//
//  /** 证书信息 */
//  public String certificate;
//
//  /** 开启学员考评 0-否 1-是 */
//  public Integer evaluate_enabled = 0;
//
//  /** 正式名额 */
//  public Integer official_num = 0;
//
//  /** 允许报名名额 */
//  public Integer allow_enroll_num = 0;
//
//  /** 1-默认样式 2-寻宝地图 */
//  public Integer map = 1;
//
//  /** 班级学员类型 0-普通班级 1-游客班级 */
//  public Integer learner_type = 0;
//
//  /** 游客班级密码 */
//  public String learner_password;
//
//  /** 游客班级设置 */
//  public String tourist_setting;
//
//  /** 设置 */
//  public String settings;
//
//  /** 所属组织 */
//  public String organization;
//
//  /** 是否开启学员确认 0-否 1-开启 */
//  public Integer learner_confirm = 0;
//
//  /** 学员确认人 EmployeeRange */
//  public String learner_confirm_group;
//
//  /** 学员确认截止时间 */
//  public String learner_confirm_deadline;
//
//  /** 模板分类 */
//  public String category;
//
//  /** 是否是默认封面 0-否 1-是 */
//  public Integer is_default_cover = 1;
//
//  /** 封面 */
//  public String cover;
//
//  /** 班级样式 0默认样式 */
//  public Integer display_style = 0;
//
//  /** 内训额外参数 */
//  public String inside_training;
//
//  public Date created;
//
//  public Date updated;
//
//}
