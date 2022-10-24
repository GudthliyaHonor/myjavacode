package com.dotk.learning.domain.notice.transfer;

import com.dotk.learning.api.admin.dto.ClassNoticeDto;
import com.dotk.learning.api.admin.vo.ClassNoticeListVo;
import com.dotk.learning.domain.notice.entity.ClassNoticeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.alibaba.fastjson2.JSONObject;

import java.util.List;

@Mapper(componentModel = "spring", imports = {JSONObject.class})
public interface ClassNoticeTransfer {
    @Mapping(target = "content", expression = "java(JSONObject.toJSONString(source.getContent()))")
    ClassNoticeEntity toEntity(ClassNoticeDto.RecordDto source);

    @Mapping(target = "content", expression = "java(JSONObject.parseObject(source.getContent()))")
    List<ClassNoticeListVo> toVo(List<ClassNoticeEntity> source);
}
