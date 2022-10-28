package com.dotk.learning.api.admin.dto;

import com.dotk.core.domain.dto.EmployeeRangeDto;
import com.dotk.core.enums.LearningType;
import com.dotk.core.utils.valid.EnumClass;
import com.dotk.core.utils.valid.EnumValue;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class LearnerAddDto {

    @Valid
    @NotNull(message = "groups不能为空")
    private List<EmployeeRangeDto> groups;//人员条件

    @EnumValue(intValues = {0, 1}, message = "参数错误")
    private Integer is_elective;//是否选修 0否 1是

    @EnumClass(enumClass = LearningType.class, message = "type参数错误")
    private Integer type;//学习模块类型
}
