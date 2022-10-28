package com.dotk.learning.api.admin.dto.learning;

import com.dotk.core.utils.valid.EnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Data
public class LearningPlanEnrollExtraConDto {

    /**
     * 是否启用学分限定 0-否 1-是
     */
    @JsonProperty("is_credit")
    @EnumValue(intValues = {0, 1}, message = "is_credit参数错误")
    public Integer isCredit = 0;

    /**
     * 学分限定值
     */
    @Min(value = 0)
    public Float credit = 0F;

    /**
     * 是否启用证书 0-否 1-是
     */
    @JsonProperty("is_certificate")
    @EnumValue(intValues = {0, 1}, message = "is_certificate参数错误")
    public Integer isCertificate = 0;

    /**
     * 获得证书数量
     */
    @JsonProperty("own_certificate_num")
    public Integer ownCertificateNum = 0;

    /**
     * 证书
     */
    @Valid
    public List<LearningPlanCertDetailDto> certificates;

    /**
     * 是否启用考试 0-否 1-是
     */
    @JsonProperty("is_exam")
    @EnumValue(intValues = {0, 1}, message = "is_exam参数错误")
    public Integer isExam = 0;

    /**
     * 考试
     */
    @Valid
    public LearningPlanExamDto exam;

}
