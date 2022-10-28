package com.dotk.learning.api.admin.dto.learning;

import com.dotk.core.domain.dto.EmployeeRangeDto;
import com.dotk.core.utils.valid.EnumValue;
import com.dotk.learning.api.admin.dto.learning.LearningPlanEnrollExtraConDto;
import com.dotk.learning.api.admin.dto.learning.LearningPlanEnrollFormDto;
import com.dotk.learning.api.admin.dto.learning.LearningPlanEnrollFormHotelDto;
import com.dotk.learning.api.admin.dto.learning.LearningPlanEnrollSettingDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class LearningEnrollSettingDto {

    @Valid
    @NotNull(message = "参数错误")
    private RecordDto record;

    @Data
    public static class RecordDto {
        /**
         * 正式名额
         */
        @JsonProperty("official_num")
        @Min(value = 0)
        private Integer officialNum = 0;

        /**
         * 允许报名名额
         */
        @JsonProperty("allow_enroll_num")
        @Min(value = 0)
        private Integer allowEnrollNum = 0;

        /**
         * 智能班级-报名权限 0-所有人 1-指定人
         */
        @JsonProperty("applicant_auth")
        @EnumValue(intValues = {0, 1}, message = "applicant_auth参数错误")
        private Integer applicantAuth = 0;

        /**
         * 报名范围
         */
        @JsonProperty("applied_range")
        @Valid
        private List<EmployeeRangeDto> appliedRange;

        /**
         * 选修范围
         */
        @JsonProperty("elective_range")
        @Valid
        private List<EmployeeRangeDto> electiveRange;

        /**
         * 智能班级-是否开启报名审核 0-不审核 1-班级管理员审核 2-部门经理审核 3-直属上级审核 4指定人员审核
         */
        @JsonProperty("is_examine")
        @EnumValue(intValues = {0, 1, 2, 3, 4}, message = "is_examine参数错误")
        private Integer isExamine = 0;

        /**
         * 指定的审核范围
         */
        @JsonProperty("examine_range")
        @Valid
        private List<EmployeeRangeDto> examineRange;

        /**
         * 报名设置
         */
        @JsonProperty("enroll_setting")
        @Valid
        private LearningPlanEnrollSettingDto enrollSetting;

        /**
         * 是否启用报名表单
         */
        @JsonProperty("is_enroll_form")
        @EnumValue(intValues = {0, 1}, message = "is_enroll_form参数错误")
        private Integer isEnrollForm = 0;

        /**
         * 报名表单
         */
        @JsonProperty("enroll_form")
        private LearningPlanEnrollFormDto enrollForm;

        /**
         * 安排住宿的酒店名称和地址
         */
        @JsonProperty("hotel_address")
        @Valid
        private List<LearningPlanEnrollFormHotelDto> hotelAddress;

        /**
         * 智能班级-报名附加条件
         */
        @JsonProperty("enroll_extra_con")
        @Valid
        private LearningPlanEnrollExtraConDto enrollExtraCon;

        /**
         * 报名提示
         */
        @JsonProperty("application_hints")
        private String applicationHints = "";

        /**
         * 自主报名 1选择 0取消选择
         */
        @JsonProperty("is_self_registration")
        @EnumValue(intValues = {0, 1}, message = "is_self_registration参数错误")
        private Integer isSelfRegistration = 1;

        /**
         * 负责人代报名  1选择 0取消选择
         */
        @JsonProperty("is_delegate_enroll")
        @EnumValue(intValues = {0, 1}, message = "is_delegate_enroll参数错误")
        private Integer isDelegateEnroll = 0;

        /**
         * 代报名类型 2-部门经理 3-直属上级 4指定人员
         */
        @JsonProperty("is_delegate_type")
        @EnumValue(intValues = {0, 2, 3, 4}, message = "is_delegate_type参数错误")
        private Integer isDelegateType = 0;

        /**
         * 代报名人信息
         */
        @JsonProperty("is_delegate_emp")
        @Valid
        private List<EmployeeRangeDto> isDelegateEmp;
    }

}
