package com.dotk.learning.domain.learning.transfer;

import com.alibaba.fastjson2.JSON;
import com.dotk.learning.api.admin.dto.learning.ClassNoticeDto;
import com.dotk.learning.domain.learning.entity.ClassNoticeEntity;
import com.dotk.learning.domain.learning.vo.ClassNoticeVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring", imports = {JSON.class})
public interface ClassNoticeTransfer {
    ClassNoticeTransfer INSTANCE = Mappers.getMapper(ClassNoticeTransfer.class);

    @Mapping(target = "content", expression = "java(JSON.toJSONString(source.getContent()))")
    ClassNoticeEntity dtoToEntity(ClassNoticeDto.RecordDto source);

    List<ClassNoticeVo> listEntityToVo(List<ClassNoticeEntity> source);

    @Mapping(target = "content", expression = "java(JSON.parseArray(source.getContent()))")
    @Mapping(target = "created", expression = "java(source.getCreated().getTime())")
    @Mapping(target = "updated", expression = "java(source.getUpdated().getTime())")
    @Mapping(target = "publishTime", expression = "java(source.getPublishTime().getTime())")
    ClassNoticeVo detailEntityToVo(ClassNoticeEntity source);
}
