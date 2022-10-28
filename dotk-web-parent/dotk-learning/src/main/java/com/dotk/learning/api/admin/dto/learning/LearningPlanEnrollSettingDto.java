package com.dotk.learning.api.admin.dto.learning;

import com.dotk.core.utils.valid.EnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LearningPlanEnrollSettingDto {

    /**
     * 是否允许取消报名 0-否 1-是
     */
    @JsonProperty("cancle_enroll")
    @EnumValue(intValues = {0, 1})
    public Integer cancleEnroll = 0;

    /**
     * 取消报名截止时间
     */
    @JsonProperty("cancel_deadline")
    public String cancelDeadline = "";

    /**
     * 是否开启候补 0-否 1-是
     */
    @JsonProperty("alternate_setting")
    @EnumValue(intValues = {0, 1})
    public Integer alternateSetting = 0;

    /**
     * 是否自定义时间 0-开班前均可报名 1-自定义时间
     */
    @JsonProperty("custom_enroll_time")
    @EnumValue(intValues = {0, 1})
    public Integer customEnrollTime = 0;

    /**
     * 报名开始时间
     */
    @JsonProperty("enroll_started")
    public String enrollStarted = "";

    /**
     * 报名结束时间
     */
    @JsonProperty("enroll_ended")
    public String enrollEnded = "";

}
