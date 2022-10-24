package com.dotk.learning.domain.learning.transfer;

import com.dotk.learning.api.admin.dto.learning.LearningPlanDto;
import com.dotk.learning.domain.learning.bo.LearningPlanBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface LearningPlanDtoToBoService {

    LearningPlanDtoToBoService INSTANCE = Mappers.getMapper(LearningPlanDtoToBoService.class);
    LearningPlanBo coverQueryCheckDto2Bo(LearningPlanDto learningPlanDto);
}
