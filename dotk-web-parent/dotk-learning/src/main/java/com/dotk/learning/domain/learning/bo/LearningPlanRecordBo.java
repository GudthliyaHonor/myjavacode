package com.dotk.learning.domain.learning.bo;

import com.dotk.core.utils.valid.EnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class LearningPlanRecordBo {

    /** 班级编号 */
    public String no;

    /** 班级名称 */
    @NotEmpty(message = "班级名称不能为空")
    public String name;

    /** 内训额外参数 */
    @Valid
    public List<LearningPlanInsideTrainingBo> insideTraining;

//
//    /** 开始时间 */
//    @JsonProperty("start_time")
//    public long startTime;
//
//    /** 结束时间 */
//    @JsonProperty("end_time")
//    public long endTime;
//
//    /** 发布状态 1草稿 2发布 */
//    @JsonProperty("publish_status")
//    @EnumValue(message = "发布状态 1-草稿 2-发布", intValues = {1,2})
//    public Integer publishStatus = 1;
//
//    /** 多班次ID 对标 project_id */
//    @JsonProperty("project_id")
//    public Integer projectId = 0;
//
//    /** 多班次名称 对标 project_name */
//    @JsonProperty("project_name")
//    public String projectName;
//
//    /** 来源 0默认 1培训计划 */
//    @EnumValue(message = "来源 0-默认 1-培训计划 ",intValues ={0,1})
//    public Integer source = 0;
//
//    /** 培训计划ID 对标 project_id */
//    @JsonProperty("training_program_id")
//    public Integer trainingProgramId = 0;
//
//    /** 培训计划名称 对标 project_name */
//    @JsonProperty("training_program_name")
//    public String trainingProgramName;
//
//    /** 项目目标 */
//    public String desc;
//
//    /** 签呈编码 */
//    @JsonProperty("petition_code")
//    public String petitionCode;
//
//    /** 任务顺序 0无序 1有序 */
//    @JsonProperty("is_order")
//    public Integer isOrder = 0;
//
//    /** 智能班级是否开启报名 0否 1是 */
//    @JsonProperty("is_applicant")
//    public Integer isApplicant = 0;
//
//    /** 智能班级-报名权限 0所有人 1指定人 */
//    @JsonProperty("applicant_auth")
//    public Integer applicantAuth = 0;
//
//    /** 智能班级-人数限制 */
//    @JsonProperty("limit_learner")
//    public Integer limitLearner = 0;
//
//    /** 智能班级-是否开启报名审核 0不审核 1审核 2部门经理审核 3直属上级审核 */
//    @JsonProperty("is_examine")
//    public Integer isExamine = 0;
//
//    /** 解锁条件
//     0-不限定
//     1-按阶段，阶段内任务不按顺序  (完成上一任务，下一任务立即解锁)
//     2-按阶段，阶段内任务按顺序
//     3-按阶段时间，阶段内任务不按顺序,
//     4-按阶段时间，阶段内任务按顺序,
//     5-按阶段打卡，
//     6-按任务打卡'
//     */
//    @JsonProperty("unlock_con")
//    public Integer unlockCon = 0;
//
//    /** 解锁周期 */
//    @JsonProperty("unlock_detail")
//    public List<LearningPlanUnlockDetailBo> unlockDetail;
//
////        /** 选修范围 */
////        @JsonProperty("elective_range")
////        public List<EmployeeRangeDto> electiveRange;
////
////        /** 指定的报名范围 EmployeeRange */
////        @JsonProperty("applied_range")
////        public List<EmployeeRangeDto> appliedRange;
////
////        /** 管理员 */
////        public List<EmployeeRangeDto> monitor;
//
//    /** 费用预算 */
//    public Integer costings = 0;
//
//    /** 培训大纲 */
//    @JsonProperty("training_outlines")
//    public String trainingOutlines;
//
//    /** 项目类型 0-线上培训 1-线下培训 2-O2O混合培训 */
//    @JsonProperty("class_type")
//    public Integer classType = 0;
//
//    /** 上课地址 */
//    @JsonProperty("class_address")
//    public String classAddress;
//
//    /** 供应商 */
//    public String vendors;
//
//    /** 学分 */
//    public Integer credit = 0;
//
//    /** 培训时长 */
//    @JsonProperty("training_hours")
//    public float trainingHours = 0;
//
//    /** 是否添加人群标签 0-否 1-是 */
//    @JsonProperty("is_add_group")
//    public Integer isAddGroup = 0;
//
//    /** 是否减人群标签 0-否 1-是 */
//    @JsonProperty("is_del_group")
//    public Integer isDelGroup = 0;
//
//    /** 加人群标签的ids */
//    @JsonProperty("add_groups")
//    public List<Integer> addGroups;
//
//    /** 减人群标签的ids */
//    @JsonProperty("del_groups")
//    public List<Integer> delGroups;
//
//    /** 是否同步课程学习进度 0-否 1-是 */
//    @JsonProperty("course_rate")
//    public Integer courseRate = 1;
//
//    /** 是否置顶 0-否 1-是 */
//    @JsonProperty("is_set_top")
//    public Integer isSetTop = 0;
//
//    /** 调班范围 */
//    @JsonProperty("shift_range")
//    public List<LearningPlanShiftRangeBo> shiftRange;
//
//    /** 报名提示 */
//    @JsonProperty("application_hints")
//    public String applicationHints;
//
//    /** 智能班级-报名附加条件 */
//    @JsonProperty("enroll_extra_con")
//    public List<LearningPlanEnrollExtraConBo> enrollExtraCon;
//
//    /** 报名设置 */
//    @JsonProperty("enroll_setting")
//    public List<LearningPlanEnrollSettingBo> enrollSetting;
//
//    /** 是否启用报名表单 */
//    @JsonProperty("is_enroll_form")
//    public Integer isEnrollForm = 0;
//
//    /** 报名表单 */
//    @JsonProperty("enroll_form")
//    public List<LearningPlanEnrollFormBo> enrollForm;
//
//    /** h5按钮控制 */
//    @JsonProperty("app_setting")
//    public List<LearningPlanAppSettingBo> appSetting;
//
//    /** 颁发证书/结业条件 */
//    @JsonProperty("certificate_condition")
//    public List<LearningPlanCertificateConditionBo> certificateCondition;
//
//    /** 开启自动结业 0-否 1-是 */
//    @JsonProperty("auto_graduation")
//    public Integer autoGraduation = 0;
//
//    /** 是否自动颁发证书 0-否 1-是 */
//    @JsonProperty("auto_certificate")
//    public Integer autoCertificate = 0;
//
//    /** 证书信息 */
//    public List<CertificateBo> certificate;
//
//    /** 开启学员考评 0-否 1-是 */
//    @JsonProperty("evaluate_enabled")
//    public Integer evaluateEnabled = 0;
//
//    /** 正式名额 */
//    @JsonProperty("official_num")
//    public Integer officialNum = 0;
//
//    /** 允许报名名额 */
//    @JsonProperty("allow_enroll_num")
//    public Integer allowEnrollNum = 0;
//
//    /** 1-默认样式 2-寻宝地图 */
//    public Integer map = 1;
//
//    /** 班级学员类型 0-普通班级 1-游客班级 */
//    @JsonProperty("learner_type")
//    public Integer learnerType = 0;
//
//    /** 游客班级密码 */
//    @JsonProperty("learner_password")
//    public String learnerPassword;
//
//    /** 游客班级设置 */
//    @JsonProperty("tourist_setting")
//    public List<LearningPlanTouristSettingBo> touristSetting;
//
//    /** 设置 */
//    public List<LearningPlanSettingsBo> settings;
//
////        /** 所属组织 */
////        public List<> organization;
//
//    /** 是否开启学员确认 0-否 1-开启 */
//    @JsonProperty("learner_confirm")
//    public Integer learnerConfirm = 0;
//
////        /** 学员确认人 EmployeeRange */
////        @JsonProperty("learner_confirm_group")
////        public List<EmployeeRangeDto> learnerConfirmGroup;
//
//    /** 学员确认截止时间 */
//    @JsonProperty("learner_confirm_deadline")
//    public String learnerConfirmDeadline;
//
//    /** 模板分类 */
//    public List<LearningCategoryBo> category;
//
//    /** 是否是默认封面 0-否 1-是 */
//    @JsonProperty("is_default_cover")
//    public Integer isDefaultCover = 1;
//
//    /** 封面 */
//    public String cover;
//
//    /** 班级样式 0默认样式 */
//    @JsonProperty("display_style")
//    public Integer displayStyle = 0;

//    /** 内训额外参数 */
//    @Valid
//    public List<LearningPlanInsideTrainingBo> insideTraining;

}
