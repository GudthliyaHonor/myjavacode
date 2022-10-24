package com.dotk.learning.api.student;

import com.dotk.learning.domain.learning.service.LearningPlanService;
import com.dotk.learning.domain.learning.entity.LearningPlanEntity;

//import com.dotk.web.api.dto.LearningPlanDTO;
//import com.dotk.web.domain.entity.LearningPlan;
//import com.dotk.web.domain.service.LearningPlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stu/learning")
public class StuLearningPlanController {

  @Autowired
  private LearningPlanService learningPlanService;

  /**
   * 使用form-data传递数据
   * @param values
   * @return
   * @deprecated
   */
  @PostMapping("/create1")
  public String create(@RequestBody MultiValueMap<String, String> values)
  {
    String name = values != null && !values.isEmpty() ? values.get("name").get(0) : null;
    if (name == null) {
      return "Empty name...";
    }

    LearningPlanEntity learningPlanEntity = new LearningPlanEntity();
//    LearningPlanEntity.setName(name);
//    int result = LearningPlanService.insertLearningPlan(LearningPlanEntity);
//    System.out.println("Result: " + result);
    return "OK";
  }

  /**
   * 使用json传递数据
   * @param LearningPlanDTO
   * @return
   */
//  @PostMapping("/create")
//  public AjaxResult create(@RequestBody LearningPlanDTO LearningPlanDTO) {
//    LearningPlan LearningPlan = new LearningPlan();
//    LearningPlan.setName(LearningPlanDTO.getName());
//    int result = LearningPlanService.insertLearningPlan(LearningPlan);
//    System.out.println("Result: " + result);
//    AjaxResult ajax = AjaxResult.success();
//    ajax.put("result", result);
//    return ajax;
//  }
//
//  @PostMapping("/update")
//  public AjaxResult update(@RequestBody LearningPlanDTO LearningPlanDTO)
//  {
//    return AjaxResult.success();
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
