package com.dotk.examcenter.infra.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dotk.examcenter.domain.questionbank.entity.QuestionBankEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionBankMapper extends BaseMapper<QuestionBankEntity> {
    public int createQuestionBank(QuestionBankEntity questionBankEntity);


    public QuestionBankEntity getInfoById(Long id);


}
