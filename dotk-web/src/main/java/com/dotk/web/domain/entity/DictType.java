package com.dotk.web.domain.entity;

import com.dotk.core.domain.BaseEntity;
import lombok.Data;

@Data
public class DictType extends BaseEntity {

    private Long dictId;

    /** 字典名称 */
    private String dictName;

    /** 字典类型 */
    private String dictType;

}
