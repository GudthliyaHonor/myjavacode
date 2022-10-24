package com.dotk.learning.domain.notice.service.impl;

import com.dotk.learning.api.admin.dto.ClassNoticeDto;
import com.dotk.learning.api.admin.dto.query.ClassNoticeListQuery;
import com.dotk.learning.api.admin.vo.ClassNoticeListVo;
import com.dotk.learning.domain.notice.entity.ClassNoticeEntity;
import com.dotk.learning.domain.notice.service.ClassNoticeService;
import com.dotk.learning.domain.notice.transfer.ClassNoticeTransfer;
import com.dotk.learning.infra.mapper.ClassNoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassNoticeServiceImpl implements ClassNoticeService {
    @Autowired
    private ClassNoticeMapper classNoticeMapper;

    @Autowired
    private ClassNoticeTransfer classNoticeTransfer;

    @Override
    public List<ClassNoticeListVo> classNoticeList(ClassNoticeListQuery classNoticeListQuery) {
        List<ClassNoticeEntity> classNoticeEntity = classNoticeMapper.classNoticeList(classNoticeListQuery);

        return classNoticeTransfer.toVo(classNoticeEntity);
    }

    @Override
    public Integer classNoticeCreate(ClassNoticeDto classNoticeCreateDto) {
        // 转换为实体类
        ClassNoticeEntity classNoticeEntity = classNoticeTransfer.toEntity(classNoticeCreateDto.getRecord());

        // TODO 设置创建人等信息


        // 创建
        classNoticeMapper.classNoticeCreate(classNoticeEntity);

        return classNoticeEntity.getId();
    }

    @Override
    public Boolean classNoticeEdit(ClassNoticeDto classNoticeCreateDto) {
        // 转换为实体类
        ClassNoticeEntity classNoticeEntity = classNoticeTransfer.toEntity(classNoticeCreateDto.getRecord());

        // TODO 设置更新人等信息
        classNoticeEntity.setId(classNoticeCreateDto.getId());

        // 更新
        return classNoticeMapper.classNoticeEdit(classNoticeEntity);
    }

    @Override
    public Boolean classNoticeDelete(ClassNoticeEntity classNoticeEntity) {
        return classNoticeMapper.classNoticeDelete(classNoticeEntity);
    }
}
