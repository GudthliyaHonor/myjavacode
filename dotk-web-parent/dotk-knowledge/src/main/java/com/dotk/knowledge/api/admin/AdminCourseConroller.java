package com.dotk.knowledge.api.admin;

import com.dotk.core.annotation.ApiRestController;
import com.dotk.core.domain.AjaxResult;
import com.dotk.knowledge.domain.course.entity.CourseDO;
import com.dotk.knowledge.domain.course.service.CourseService;
import com.dotk.knowledge.domain.directory.entity.DirectoryDO;
import com.dotk.knowledge.domain.directory.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@ApiRestController
public class AdminCourseConroller {
    @Autowired
    CourseService courseService;

    /**
     * oldApi:/course
     * @param  courseDO
     * @return
     */
    @PostMapping("/course")
    public AjaxResult createDirectory(@RequestBody CourseDO courseDO){
        int id =   courseService.create(courseDO);
        Map<String,Integer> resp=new HashMap<>();
        resp.put("id",id);
        return AjaxResult.success(resp);
    }
}
