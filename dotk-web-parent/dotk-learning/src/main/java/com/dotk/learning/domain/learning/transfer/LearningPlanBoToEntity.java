package com.dotk.learning.domain.learning.transfer;

import com.alibaba.fastjson2.JSONObject;
import com.dotk.learning.domain.learning.bo.LearningPlanBo;
import com.dotk.learning.domain.learning.entity.LearningPlanEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring", imports = {JSONObject.class, Date.class})
public interface LearningPlanBoToEntity {

//    LearningPlanEntity boToLearningPlanEntity(LearningPlanBo learningPlanBo);
    @Mapping(target = "no", expression = "java(JSONObject.toJSONString(learningPlanBo))")
//    @Mapping(target = "name", expression = "java(JSONObject.toJSONString(LearningPlanBo.record.name))")
//    @Mapping(target = "relation_id", expression = "java(JSONObject.toJSONString(LearningPlanInsideTrainingBo.relationId))")
//    @Mapping(target = "delay_reason", expression = "java(JSONObject.toJSONString(LearningPlanInsideTrainingBo.delayReason))")
    @Mapping(target = "created", expression = "java(new Date())")
    @Mapping(target = "updated", expression = "java(new Date())")

    LearningPlanEntity toLearningPlanEntity(LearningPlanBo learningPlanBo);
}
