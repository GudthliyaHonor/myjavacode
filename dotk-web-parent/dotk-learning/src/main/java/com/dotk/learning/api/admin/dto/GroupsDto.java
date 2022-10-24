package com.dotk.learning.api.admin.dto;

import com.dotk.core.enums.GroupsType;
import com.dotk.core.utils.valid.EnumClass;
import com.dotk.core.utils.valid.EnumValue;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GroupsDto {
    @NotNull
    private Integer id;

    @EnumClass(enumClass = GroupsType.class, message = "人员条件类型参数错误")
    private Integer type;

    private String name;

    @EnumValue(intValues = {0, 1}, message = "参数错误", allowNull = true)
    private Integer children_included = 0;
}
