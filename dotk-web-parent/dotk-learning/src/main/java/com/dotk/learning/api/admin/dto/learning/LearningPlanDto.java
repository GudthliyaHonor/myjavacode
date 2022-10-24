package com.dotk.learning.api.admin.dto.learning;


import com.dotk.learning.api.admin.dto.learning.LearningPlanRecordDto;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class LearningPlanDto {

    /** 班级id */
    public Integer type;

    /** 公司id */
    public Integer projectId = 0;

    @Valid
    @NotNull(message = "必填项")
    public LearningPlanRecordDto record;

}
