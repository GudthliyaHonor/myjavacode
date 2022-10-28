package com.dotk.learning.api.admin;

import com.dotk.core.annotation.ApiRestController;
import com.dotk.core.controller.BaseController;
import com.dotk.core.domain.AjaxResult;
import com.dotk.learning.api.admin.dto.learning.LearningEnrollSettingDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * 班级报名相关
 */
@ApiRestController
@Validated
public class LearningEnrollController extends BaseController {

    @PostMapping("/learning/plan/{learning_id}/enroll")
    public AjaxResult updateEnrollInfo(
            @PathVariable("learning_id") Long learningId,
            @Valid @RequestBody LearningEnrollSettingDto enrollSettingDto
    ) {
        // 转为bo
        System.out.println(learningId);
        System.out.println(enrollSettingDto);
        System.out.println(enrollSettingDto.getRecord());
        return success(enrollSettingDto);
    }
}
