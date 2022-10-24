package com.dotk.knowledge.domain.course.service.impl;

import com.dotk.knowledge.domain.course.entity.CourseDO;
import com.dotk.knowledge.domain.course.service.CourseService;
import com.dotk.knowledge.infra.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public int create(CourseDO courseDO){
        courseDO.setAid(1018);
        courseDO.setLiveStyle(12);
        return courseMapper.create(courseDO);
    }
}
