package com.dotk.learning.api.admin;

import com.dotk.learning.api.admin.dto.learning.LearningPlanDto;
import com.dotk.learning.domain.learning.bo.LearningPlanBo;
import com.dotk.learning.domain.learning.service.LearningPlanService;

import com.dotk.core.annotation.ApiRestController;
import com.dotk.core.controller.BaseController;
import com.dotk.core.domain.AjaxResult;
import com.dotk.learning.domain.learning.transfer.LearningPlanDtoToBoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;
@Slf4j
@Validated
@ApiRestController
public class LearningPlanController extends BaseController{

  @Autowired
  private LearningPlanService learningPlanService;

  /**
   * 使用json传递数据
   * @param learningPlanDto
   * @return
   */
  @PutMapping("/learning/plan")
  public AjaxResult create(@Validated @RequestBody LearningPlanDto learningPlanDto) {
    log.info("Controller LearningPlanDto Create is {}", learningPlanDto);
    LearningPlanDtoToBoService instance = LearningPlanDtoToBoService.INSTANCE;
    LearningPlanBo learningPlanBo = instance.coverQueryCheckDto2Bo(learningPlanDto);

    int id = learningPlanService.create(learningPlanBo);
    Map<String,Integer> res=new HashMap<>();
    res.put("id",id);
    return AjaxResult.success(res);
//
//
//    LearningPlan LearningPlan = new LearningPlan();
//    LearningPlan.setName(LearningPlanDto.getName());
//    int result = LearningPlanService.insertLearningPlan(LearningPlan);
//    System.out.println("Result: " + result);
//    AjaxResult ajax = AjaxResult.success();
//    ajax.put("result", result);
//    return ajax;
  }


  @PostMapping("/learning/update")
  public AjaxResult update(@Validated @RequestBody LearningPlanDto learningPlanDto)
  {
    LearningPlanDtoToBoService instance = LearningPlanDtoToBoService.INSTANCE;
    LearningPlanBo learningPlanBo = instance.coverQueryCheckDto2Bo(learningPlanDto);

    log.info("Controller LearningPlanDto Update is {}", learningPlanDto);
    int id = learningPlanService.update(learningPlanBo);

    return AjaxResult.success(id);
  }

//
//  /**
//   * 使用form-data传递数据
//   * @param values
//   * @return
//   * @deprecated
//   */
//  @PostMapping("/create1")
//  public String create(@RequestBody MultiValueMap<String, String> values)
//  {
//    String name = values != null && !values.isEmpty() ? values.get("name").get(0) : null;
//    if (name == null) {
//      return "Empty name...";
//    }
//
//    LearningPlan LearningPlan = new LearningPlan();
//    LearningPlan.setName(name);
//    int result = LearningPlanService.insertLearningPlan(LearningPlan);
//    System.out.println("Result: " + result);
//    return "OK";
//  }
//


//  @GetMapping("/list")
//  public AjaxResult list()
//  {
//    LearningPlan LearningPlan = new LearningPlan();
//    List<LearningPlan> list = LearningPlanService.selectLearningPlanList(LearningPlan);
//    System.out.println(list);
//
//    AjaxResult result = AjaxResult.success();
//    result.put("data", list);
//    return result;
//  }
//
//  @PostMapping("/delete")
//  public AjaxResult delete(@RequestBody MultiValueMap<String, String> values)
//  {
//    return AjaxResult.success();
//  }
}
