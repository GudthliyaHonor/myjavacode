package com.dotk.learning.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dotk.learning.domain.learning.bo.ClassNoticeBo;
import com.dotk.learning.domain.learning.entity.ClassNoticeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassNoticeMapper extends BaseMapper<ClassNoticeEntity> {
    List<ClassNoticeEntity> list(ClassNoticeBo classNoticeBo);

//    ClassNoticeEntity detail(Long noticeId);
//
//    Long create(ClassNoticeEntity classNoticeEntity);
//
//    Boolean edit(ClassNoticeEntity classNoticeEntity);
//
//    Boolean delete(ClassNoticeEntity classNoticeEntity);
}
