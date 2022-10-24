package com.dotk.learning.domain.learning.service;

import com.dotk.learning.domain.learning.bo.LearningPlanBo;
import com.dotk.learning.domain.learning.entity.LearningPlanEntity;

import java.util.List;

public interface LearningPlanService
{

  //增加
  int create(LearningPlanBo learningPlanBo);

  //修改
  int update(LearningPlanBo learningPlanBo);

  //全查
  List<LearningPlanEntity> listLearningPlan(LearningPlanEntity learningPlanEntity);

  //ID单查
  LearningPlanEntity getById(Integer id);

  //No单查
  LearningPlanEntity getByNo(String no);

  //name模糊查
  List<LearningPlanEntity> listVagueLearningPlan(LearningPlanEntity learningPlanEntity);

  //查总数
  int getCount();

//
//
//  List<LearningPlanEntity> listH5LearningPlan();
//  int removeLearningPlan(Integer id);
//  LearningPlanEntity getById(Integer id);
//  LearningPlanEntity getByName(String name);

}
