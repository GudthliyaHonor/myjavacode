package com.dotk.examcenter.domain.questionbank.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dotk.examcenter.api.admin.dto.CreateQuestionBankDto;
import com.dotk.examcenter.api.admin.dto.QueryQuestionBankDto;
import com.dotk.examcenter.api.admin.dto.UpdateQuestionBankDto;
import com.dotk.examcenter.domain.questionbank.vo.QuestionBankInfoVo;
import com.dotk.examcenter.domain.questionbank.vo.QuestionBankListVo;
import com.dotk.examcenter.domain.questionbank.entity.QuestionBankEntity;
import com.dotk.examcenter.domain.questionbank.service.QuestionBankService;
import com.dotk.examcenter.domain.questionbank.transfer.QuestionBankTransfer;
import com.dotk.examcenter.infra.mapper.QuestionBankMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class QuestionBankServiceImpl implements QuestionBankService {

    @Autowired
    private QuestionBankMapper questionBankMapper;

    @Autowired
    private QuestionBankTransfer questionBankTransfer;

    @Override
    public int Create(CreateQuestionBankDto createQuestionBankDto)
    {
        QuestionBankEntity questionBankEntity=questionBankTransfer.toQuestionBankEntity(createQuestionBankDto);
        int restult=questionBankMapper.insert(questionBankEntity);
        log.info("questionBankEntity:{}",questionBankEntity);

        return questionBankEntity.getId().intValue();
    }


    public QuestionBankInfoVo getInfo(Long id){
        QuestionBankEntity questionBankEntity=questionBankMapper.selectById(id);
        log.info("questionBankEntity:{}",questionBankEntity);
        QuestionBankInfoVo vo=questionBankTransfer.toQuestionBankInfoVo(questionBankEntity);
        log.info("vo:{}",vo);
        return vo;
    }


    public int deleteById(Long id){
        return questionBankMapper.deleteById(id);
    }

    @Override
    public int updateQuestionBank(Long id, UpdateQuestionBankDto updateQuestionBankDto) {

        QuestionBankEntity questionBankEntity=questionBankTransfer.toUpdateQuestionBankEntity(updateQuestionBankDto);
        questionBankEntity.setId(id);
        return questionBankMapper.updateById(questionBankEntity);
    }

    public QuestionBankListVo list(QueryQuestionBankDto queryQuestionBankDto){
        Page<QuestionBankEntity> page = new Page<>(queryQuestionBankDto.getPage().getPage(), queryQuestionBankDto.getPage().getItemsPerPage());
        Page<QuestionBankEntity> result = questionBankMapper.selectPage(page, null);
        log.info("result:{}",result);
        QuestionBankListVo questionBankListVo=new QuestionBankListVo();
        questionBankListVo.setTotal(result.getTotal());
        questionBankListVo.setPage(result.getCurrent());
        questionBankListVo.setLimit(result.getSize());
        questionBankListVo.setList(questionBankTransfer.toQuestionBankList(result.getRecords()));
        return questionBankListVo;
    }
}
