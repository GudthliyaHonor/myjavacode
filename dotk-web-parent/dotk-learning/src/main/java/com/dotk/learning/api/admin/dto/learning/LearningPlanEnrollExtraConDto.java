package com.dotk.learning.api.admin.dto.learning;

import lombok.Data;

import java.util.List;

@Data
public class LearningPlanEnrollExtraConDto {

    /** 是否启用学分限定 0-否 1-是 */
    public Integer isCredit = 0;

    /** 学分限定值 */
    public float credit;

    /** 是否启用证书 0-否 1-是 */
    public Integer isCertificate = 0;

    /** 获得证书数量 */
    public Integer ownCertificateNum = 0;

    /** 证书 */
    public Integer certificates;

    /** 是否启用考试 0-否 1-是 */
    public Integer isExam = 0;

    /** 考试 */
    public List<LearningPlanExamDto> exam;

}
