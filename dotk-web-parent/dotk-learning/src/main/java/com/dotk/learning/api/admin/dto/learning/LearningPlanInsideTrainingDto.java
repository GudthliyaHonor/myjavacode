package com.dotk.learning.api.admin.dto.learning;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LearningPlanInsideTrainingDto {

    /** 任务计划关联表ID */
    @JsonProperty("relation_id")
    public Integer relationId = 0;

    /** 项目延期说明 */
    @JsonProperty("delay_reason")
    public String delayReason;

}
