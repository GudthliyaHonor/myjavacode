package com.dotk.web.api.controller;

import com.dotk.core.annotation.ApiRestController;
import com.dotk.core.controller.BaseController;
import com.dotk.core.domain.AjaxResult;
import com.dotk.web.api.dto.SampleDTO;
import com.dotk.web.domain.entity.Sample;
import com.dotk.web.domain.service.SampleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@ApiRestController("/sample")
public class SampleController extends BaseController {

  @Autowired
  private SampleService sampleService;

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

    Sample sample = new Sample();
    sample.setName(name);
    int result = sampleService.insertSample(sample);
    System.out.println("Result: " + result);
    return "OK";
  }

  /**
   * 使用json传递数据
   * @param sampleDTO
   * @return
   */
  @PostMapping("/create")
  public AjaxResult create(@RequestBody SampleDTO sampleDTO) {
    Sample sample = new Sample();
    sample.setName(sampleDTO.getName());
    int result = sampleService.insertSample(sample);
    System.out.println("Result: " + result);
    AjaxResult ajax = AjaxResult.success();
    ajax.put("result", result);
    return ajax;
  }

  @PostMapping("/update")
  public AjaxResult update(@RequestBody SampleDTO sampleDTO)
  {
    return AjaxResult.success();
  }

  @GetMapping("/list")
  public AjaxResult list()
  {
    Sample sample = new Sample();
    List<Sample> list = sampleService.selectSampleList(sample);
    System.out.println(list);

    AjaxResult result = AjaxResult.success();
    result.put("data", list);
    return result;
  }

  @PostMapping("/delete")
  public AjaxResult delete(@RequestBody MultiValueMap<String, String> values)
  {
    return AjaxResult.success();
  }
}
