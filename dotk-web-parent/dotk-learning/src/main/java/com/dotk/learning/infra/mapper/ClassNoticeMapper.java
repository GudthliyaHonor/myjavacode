package com.dotk.learning.infra.mapper;

import com.dotk.learning.api.admin.dto.query.ClassNoticeListQuery;
import com.dotk.learning.domain.notice.entity.ClassNoticeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassNoticeMapper {
    public List<ClassNoticeEntity> classNoticeList(ClassNoticeListQuery classNoticeListQuery);

    public Integer classNoticeCreate(ClassNoticeEntity classNoticeEntity);

    public Boolean classNoticeEdit(ClassNoticeEntity classNoticeEntity);

    public Boolean classNoticeDelete(ClassNoticeEntity classNoticeEntity);
}
