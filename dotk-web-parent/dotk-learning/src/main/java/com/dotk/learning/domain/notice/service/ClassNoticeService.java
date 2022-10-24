package com.dotk.learning.domain.notice.service;


import com.dotk.learning.api.admin.dto.ClassNoticeDto;
import com.dotk.learning.api.admin.dto.query.ClassNoticeListQuery;
import com.dotk.learning.api.admin.vo.ClassNoticeListVo;
import com.dotk.learning.domain.notice.entity.ClassNoticeEntity;

import java.util.List;

public interface ClassNoticeService {
    public List<ClassNoticeListVo> classNoticeList(ClassNoticeListQuery classNoticeListQuery);

    public Integer classNoticeCreate(ClassNoticeDto classNoticeCreateDto);

    public Boolean classNoticeEdit(ClassNoticeDto classNoticeCreateDto);

    public Boolean classNoticeDelete(ClassNoticeEntity classNoticeEntity);
}
