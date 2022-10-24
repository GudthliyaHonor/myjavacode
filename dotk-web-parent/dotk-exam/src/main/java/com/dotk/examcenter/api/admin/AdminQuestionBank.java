package com.dotk.examcenter.api.admin;

import com.dotk.core.annotation.ApiRestController;
import com.dotk.core.controller.BaseController;
import com.dotk.core.domain.AjaxResult;
import com.dotk.examcenter.api.admin.dto.CreateQuestionBankDto;
import com.dotk.examcenter.api.admin.dto.QueryQuestionBankDto;
import com.dotk.examcenter.api.admin.dto.UpdateQuestionBankDto;
import com.dotk.examcenter.domain.questionbank.service.QuestionBankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 题库管理
 */
@Slf4j
@Validated
@ApiRestController
public class AdminQuestionBank extends BaseController {

    @Autowired
    private QuestionBankService questionBankService;

    /**
     * 创建题库
     * php 版本
     */
    @PostMapping("/question/bank")
    public AjaxResult Create(@Validated @RequestBody CreateQuestionBankDto createQuestionBankDto){
        log.info("CreateQuestionBankDto is {}", createQuestionBankDto);
        int id= questionBankService.Create(createQuestionBankDto);
        Map<String,Integer> resp=new HashMap<>();
        resp.put("id",id);
        return success(resp);
    }

    /**
     * 获取详情
     * @param id
     * @return
     */
    @RequestMapping(value={"/question/bank/{id}","/question_bank/{id}/detail"},method = RequestMethod.GET)
    public AjaxResult getInfo(@PathVariable Long id){
        log.info("id:{}",id);

        return success(questionBankService.getInfo(id));
    }

    /**
     * 删除题库
     * @param id
     * @return
     */
    @RequestMapping(path ={"/question/bank/{id}","/question_bank/{id}"},method = RequestMethod.DELETE)
    public AjaxResult deleteBank(@PathVariable Long id){
        int result= questionBankService.deleteById(id);
        if (result==1){
            return success();
        }else{
            return error();
        }

    }


    /**
     * 更新题库
     * @param id
     * @return
     */
    @RequestMapping(path ={"/question/bank/{id}","/question_bank/{id}"},method = {RequestMethod.PUT,RequestMethod.POST})
    public AjaxResult updateBank(@PathVariable Long id,@Validated @RequestBody UpdateQuestionBankDto updateQuestionBankDto){
        int result=questionBankService.updateQuestionBank(id,updateQuestionBankDto);
        return success(result);
    }


    /**
     * 题库列表
     */
    @RequestMapping(path ={"/question/bank/list","/question_banks/V2"},method = {RequestMethod.GET,RequestMethod.POST})
    public AjaxResult list(@Validated @RequestBody QueryQuestionBankDto queryQuestionBankDto){
        log.info("queryQuestionBankDto is {}", queryQuestionBankDto);
        return success(questionBankService.list(queryQuestionBankDto));
    }


}
