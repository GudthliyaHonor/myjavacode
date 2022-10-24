package com.dotk.examcenter.domain.questionbank.service;


import com.dotk.examcenter.api.admin.dto.CreateQuestionBankDto;
import com.dotk.examcenter.api.admin.dto.QueryQuestionBankDto;
import com.dotk.examcenter.api.admin.dto.UpdateQuestionBankDto;
import com.dotk.examcenter.domain.questionbank.vo.QuestionBankInfoVo;
import com.dotk.examcenter.domain.questionbank.vo.QuestionBankListVo;

public interface QuestionBankService {

    public int Create(CreateQuestionBankDto createQuestionBankDto);

    public QuestionBankInfoVo getInfo(Long id);


    public int deleteById(Long id);

    public int updateQuestionBank(Long id, UpdateQuestionBankDto updateQuestionBankDto);


    public QuestionBankListVo list(QueryQuestionBankDto queryQuestionBankDto);

}
