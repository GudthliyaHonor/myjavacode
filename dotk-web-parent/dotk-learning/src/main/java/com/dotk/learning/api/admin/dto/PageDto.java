package com.dotk.learning.api.admin.dto;

import com.dotk.core.enums.GroupsType;
import com.dotk.core.utils.valid.EnumClass;
import com.dotk.core.utils.valid.EnumValue;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class PageDto {
    @Min(value = 0, message = "page参数错误")
    private Integer page;

    @Min(value = 0, message = "itemsPerPage参数错误")
    private Integer itemsPerPage;

    public Integer calcOffset() {
        return page > 0 ? (page - 1) * itemsPerPage : 0;
    }
}
