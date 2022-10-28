package com.dotk.learning.api.admin.dto.learning;

import com.dotk.core.utils.valid.EnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LearningPlanEnrollFormHotelDto {

    /**
     * 酒店名称
     */
    public String name = "";

    /**
     * 酒店地址
     */
    public String address = "";

}
