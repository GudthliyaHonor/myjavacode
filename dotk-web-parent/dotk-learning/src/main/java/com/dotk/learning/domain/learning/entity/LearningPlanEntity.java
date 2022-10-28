package com.dotk.learning.domain.learning.entity;

import com.dotk.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class LearningPlanEntity extends BaseEntity {

  /** 项目类型 */
  public int type;

  /** 多班次ID 对标 project_id*/
  public Integer projectId = 0;

  /** 班级编号 */
  public String no;

  /** 班级名称 */
  public String name;

  /** inside_training text */
  public String insideTraining;

}
