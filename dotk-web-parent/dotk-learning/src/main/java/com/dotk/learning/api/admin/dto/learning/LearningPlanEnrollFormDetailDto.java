package com.dotk.learning.api.admin.dto.learning;

import com.dotk.core.utils.valid.EnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LearningPlanEnrollFormDetailDto {

    /**
     * 是否展示 0-否 1-是
     */
    @JsonProperty("is_show")
    @EnumValue(intValues = {0, 1}, message = "is_show参数错误")
    public Integer isShow = 0;

    /**
     * 是否必填 0-否 1-是
     */
    @JsonProperty("must_fill")
    @EnumValue(intValues = {0, 1}, message = "must_fill参数错误")
    public Integer mustFill = 0;

}
