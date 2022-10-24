package com.dotk.learning.infra.mapper;

import com.dotk.learning.domain.learning.entity.LearningPlanEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearningPlanMapper
{
  int create(LearningPlanEntity LearningPlanEntity);

  int update(LearningPlanEntity LearningPlanEntity);

  List<LearningPlanEntity> listLearningPlan();

  LearningPlanEntity getById(Integer id);
  LearningPlanEntity getByName(String name);
}
