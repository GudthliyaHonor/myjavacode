package com.dotk.knowledge.domain.course.service.impl;

import com.dotk.knowledge.domain.course.entity.OfflineTeachingDo;
import com.dotk.knowledge.domain.course.service.OfflineTeachingService;
import com.dotk.knowledge.infra.mapper.OfflineTeachingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfflineTeachingServiceImpl implements OfflineTeachingService {

    @Autowired
    OfflineTeachingMapper offlineTeachingMapper;

    @Override
    public int create(OfflineTeachingDo offlineTeachingDo){
        return offlineTeachingMapper.create(offlineTeachingDo);
    }
}
