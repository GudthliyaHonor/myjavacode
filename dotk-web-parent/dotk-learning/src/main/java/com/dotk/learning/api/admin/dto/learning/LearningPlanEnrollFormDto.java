package com.dotk.learning.api.admin.dto.learning;

import com.dotk.core.utils.valid.EnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class LearningPlanEnrollFormDto {

    /**
     * 姓名
     */
    @Valid
    public LearningPlanEnrollFormDetailDto display;

    /**
     * 手机号
     */
    @Valid
    public LearningPlanEnrollFormDetailDto mobile;

    /**
     * 职位
     */
    @Valid
    public LearningPlanEnrollFormDetailDto position;

    /**
     * 业务单位
     */
    @JsonProperty("business_unit")
    @Valid
    public LearningPlanEnrollFormDetailDto businessUnit;

    /**
     * 是否可以安排交通 0-否 1-是
     */
    @JsonProperty("is_transport")
    @EnumValue(intValues = {0, 1}, message = "is_transport参数错误")
    public Integer isTransport = 0;

    /**
     * 是否可以安排住宿 0-否 1-是
     */
    @JsonProperty("is_hotel")
    @EnumValue(intValues = {0, 1}, message = "is_hotel参数错误")
    public Integer isHotel = 0;

    /**
     * 是否合住 0-否 1-是
     */
    @JsonProperty("is_share")
    @EnumValue(intValues = {0, 1}, message = "is_share参数错误")
    public Integer isShare = 0;

}
