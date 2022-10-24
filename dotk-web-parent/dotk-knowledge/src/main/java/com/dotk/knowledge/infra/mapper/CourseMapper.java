package com.dotk.knowledge.infra.mapper;

import com.dotk.knowledge.domain.course.entity.CourseDO;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMapper {
    int create(CourseDO courseDO);
}
