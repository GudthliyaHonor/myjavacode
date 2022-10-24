package com.dotk.learning.domain.learning.bo;

import com.dotk.core.utils.valid.EnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class LearningPlanBo {

    /** 班级id */
    public Integer type;

    /** 公司id */
    public Integer projectId = 0;

    public LearningPlanRecordBo record;

}
