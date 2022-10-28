package com.dotk.learning.api.admin.dto.learning;

import com.dotk.core.utils.valid.EnumValue;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ClassNoticeSetTopDto {
    @NotNull
    private Long id;

    @NotNull
    @EnumValue(intValues = {0, 1})
    private Integer type;
}
