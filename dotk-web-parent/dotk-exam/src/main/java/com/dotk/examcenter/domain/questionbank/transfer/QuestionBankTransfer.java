package com.dotk.examcenter.domain.questionbank.transfer;


import com.dotk.examcenter.api.admin.dto.CreateQuestionBankDto;
import com.dotk.examcenter.api.admin.dto.UpdateQuestionBankDto;
import com.dotk.examcenter.domain.questionbank.vo.QuestionBankInfoVo;
import com.dotk.examcenter.domain.questionbank.entity.QuestionBankEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionBankTransfer {

    QuestionBankEntity toQuestionBankEntity(CreateQuestionBankDto source);

    QuestionBankEntity toUpdateQuestionBankEntity(UpdateQuestionBankDto source);


    QuestionBankInfoVo toQuestionBankInfoVo(QuestionBankEntity source);


    List<QuestionBankInfoVo> toQuestionBankList(List<QuestionBankEntity> userDTOList);
}
