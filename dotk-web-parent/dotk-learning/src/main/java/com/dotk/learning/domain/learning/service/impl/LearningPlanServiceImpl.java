package com.dotk.learning.domain.learning.service.impl;

import com.dotk.learning.domain.learning.bo.LearningPlanBo;
import com.dotk.learning.domain.learning.entity.LearningPlanEntity;
import com.dotk.learning.domain.learning.service.LearningPlanService;
import com.dotk.learning.domain.learning.transfer.LearningPlanBoToEntity;
import com.dotk.learning.infra.mapper.LearningPlanMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LearningPlanServiceImpl implements LearningPlanService {

  public static final int LEARNING_TYPE = 0;//智能班级


  @Autowired
  private LearningPlanMapper learningPlanMapper;

  @Autowired
  private LearningPlanBoToEntity learningPlanBoToEntity;

  @Override
  public int create(LearningPlanBo learningPlanBo){
//    return 0;
//    LocalDateTime localDateTime = LocalDateTime.now();
//    LearningPlanDto.setCreated(localDateTime.getSecond());
//    LearningPlanDto.setUpdated(localDateTime.getSecond());

    LearningPlanEntity learningPlanEntity = learningPlanBoToEntity.toLearningPlanEntity(learningPlanBo);

//    learningPlanEntity.set.getRecord();
//    learningPlanEntity.setProjectId(learningPlanBo.getProjectId());
    //毫秒时间戳改日期格式
//    Date date = new Date();
//    date.setTime(learningPlanBo.getStartTime());
//    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    learningPlanEntity.setStartTime(simpleDateFormat.format(date));

    log.info("leaningClassEntityCreat:{}",learningPlanEntity);
    return learningPlanMapper.create(learningPlanEntity);
  }

  @Override
  public int update(LearningPlanBo learningPlanBo){
    return 0;
//
//    int id = LearningPlanDto.getId();
//
//
//    LocalDateTime localDateTime = LocalDateTime.now();
//    LearningPlanDto.setUpdated(localDateTime.getSecond());

//    LearningPlanEntity learningPlanEntity = learningPlanTransfer.toLearningPlanEntity(learningPlanBo);
//    return learningPlanMapper.update(learningPlanEntity);
  }

  @Override
  public List<LearningPlanEntity> listLearningPlan(LearningPlanEntity learningPlanEntity){
    return learningPlanMapper.listLearningPlan();
  }


  @Override
  public LearningPlanEntity getById(Integer id){
    return learningPlanMapper.getById(id);
  }

  @Override
  public LearningPlanEntity getByNo(String name){
    return learningPlanMapper.getByName(name);
  }


  @Override
  public List<LearningPlanEntity> listVagueLearningPlan(LearningPlanEntity learningPlanEntity){
    return learningPlanMapper.listLearningPlan();
  }

  public int getCount(){
    return 1;
  }

}
