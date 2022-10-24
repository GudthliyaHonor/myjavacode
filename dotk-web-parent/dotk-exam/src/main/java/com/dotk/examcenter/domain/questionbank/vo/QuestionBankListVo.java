package com.dotk.examcenter.domain.questionbank.vo;

import lombok.Data;

import java.util.List;

@Data
public class QuestionBankListVo {
    private Long page;
    private Long limit;
    private Long total;
    private List<QuestionBankInfoVo> list;

}
