package com.dotk.examcenter.domain.questionbank.transfer;

import com.dotk.examcenter.api.admin.dto.CreateQuestionBankDto;
import com.dotk.examcenter.api.admin.dto.UpdateQuestionBankDto;
import com.dotk.examcenter.domain.questionbank.entity.QuestionBankEntity;
import com.dotk.examcenter.domain.questionbank.vo.QuestionBankInfoVo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-24T14:14:12+0800",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 1.8.0_342 (Amazon.com Inc.)"
)
@Component
public class QuestionBankTransferImpl implements QuestionBankTransfer {

    @Override
    public QuestionBankEntity toQuestionBankEntity(CreateQuestionBankDto source) {
        if ( source == null ) {
            return null;
        }

        QuestionBankEntity questionBankEntity = new QuestionBankEntity();

        questionBankEntity.setType( source.getType() );
        questionBankEntity.setDirId( source.getDirId() );
        questionBankEntity.setTitle( source.getTitle() );
        questionBankEntity.setIsPractice( source.getIsPractice() );
        questionBankEntity.setIsShared( source.getIsShared() );
        questionBankEntity.setIsPrivate( source.getIsPrivate() );
        List<Integer> list = source.getDepartmentId();
        if ( list != null ) {
            questionBankEntity.setDepartmentId( new ArrayList<Integer>( list ) );
        }

        return questionBankEntity;
    }

    @Override
    public QuestionBankEntity toUpdateQuestionBankEntity(UpdateQuestionBankDto source) {
        if ( source == null ) {
            return null;
        }

        QuestionBankEntity questionBankEntity = new QuestionBankEntity();

        questionBankEntity.setType( source.getType() );
        questionBankEntity.setDirId( source.getDirId() );
        questionBankEntity.setTitle( source.getTitle() );
        questionBankEntity.setIsPractice( source.getIsPractice() );
        questionBankEntity.setIsShared( source.getIsShared() );
        questionBankEntity.setIsPrivate( source.getIsPrivate() );
        List<Integer> list = source.getDepartmentId();
        if ( list != null ) {
            questionBankEntity.setDepartmentId( new ArrayList<Integer>( list ) );
        }

        return questionBankEntity;
    }

    @Override
    public QuestionBankInfoVo toQuestionBankInfoVo(QuestionBankEntity source) {
        if ( source == null ) {
            return null;
        }

        QuestionBankInfoVo questionBankInfoVo = new QuestionBankInfoVo();

        questionBankInfoVo.setId( source.getId() );
        questionBankInfoVo.setTitle( source.getTitle() );
        questionBankInfoVo.setIsPractice( source.getIsPractice() );
        questionBankInfoVo.setDirId( source.getDirId() );
        questionBankInfoVo.setType( source.getType() );
        questionBankInfoVo.setIsShared( source.getIsShared() );
        List<Integer> list = source.getDepartmentId();
        if ( list != null ) {
            questionBankInfoVo.setDepartmentId( new ArrayList<Integer>( list ) );
        }
        questionBankInfoVo.setIsPrivate( source.getIsPrivate() );

        return questionBankInfoVo;
    }

    @Override
    public List<QuestionBankInfoVo> toQuestionBankList(List<QuestionBankEntity> userDTOList) {
        if ( userDTOList == null ) {
            return null;
        }

        List<QuestionBankInfoVo> list = new ArrayList<QuestionBankInfoVo>( userDTOList.size() );
        for ( QuestionBankEntity questionBankEntity : userDTOList ) {
            list.add( toQuestionBankInfoVo( questionBankEntity ) );
        }

        return list;
    }
}
