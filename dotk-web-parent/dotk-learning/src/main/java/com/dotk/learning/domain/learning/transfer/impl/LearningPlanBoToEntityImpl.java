//package com.dotk.learning.domain.learning.transfer.impl;
//
//import com.dotk.learning.domain.learning.bo.LearningPlanBo;
//import com.dotk.learning.domain.learning.entity.LearningPlanEntity;
//import com.dotk.learning.domain.learning.transfer.LearningPlanBoToEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class LearningPlanBoToEntityImpl implements LearningPlanBoToEntity {
//
//    @Override
//    public LearningPlanEntity boToLearningPlanEntity(LearningPlanBo learningPlanBo) {
//        if ( learningPlanBo == null ) {
//            return null;
//        }
//
//        LearningPlanEntity learningPlanEntity = new LearningPlanEntity();
//
//        if ( learningPlanBo.getType() != null ) {
//            learningPlanEntity.setType( learningPlanBo.getType() );
//        }
//        learningPlanEntity.setProjectId( learningPlanBo.getProjectId() );
//
//        learningPlanEntity.setCreated( new Date() );
//        learningPlanEntity.setUpdated( new Date() );
//
//        return learningPlanEntity;
//    }
//}
