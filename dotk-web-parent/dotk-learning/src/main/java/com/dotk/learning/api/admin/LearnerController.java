package com.dotk.learning.api.admin;

import com.dotk.core.annotation.ApiRestController;
import com.dotk.core.controller.BaseController;
import com.dotk.core.domain.AjaxResult;
import com.dotk.learning.api.admin.dto.LearnerAddDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@ApiRestController
@Validated
public class LearnerController extends BaseController {

    /**
     * 通过人群等新增学习计划成员
     */
    @PutMapping("/learning/plan/{learning_id}/learner/group")
    public AjaxResult addLearnerByGroup(@PathVariable("learning_id") Integer learning_id, @Validated @RequestBody LearnerAddDto learnerAddDto) {
        return AjaxResult.success("learning id is " + learning_id, learnerAddDto);
    }

}
