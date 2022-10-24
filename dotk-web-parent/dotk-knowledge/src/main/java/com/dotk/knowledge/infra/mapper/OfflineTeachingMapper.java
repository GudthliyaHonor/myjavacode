package com.dotk.knowledge.infra.mapper;

import com.dotk.knowledge.domain.course.entity.OfflineTeachingDo;
import org.springframework.stereotype.Repository;

@Repository
public interface OfflineTeachingMapper {
    int create(OfflineTeachingDo offlineTeachingDo);
}
