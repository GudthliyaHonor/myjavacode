package com.dotk.platform.domain.vo;

import java.util.Date;
import lombok.Data;

@Data
public class AccountVO {
  private Integer id;
  private String code;
  private String name;
  private String desc;
  private String codeDisplay;
  private Integer status;
  private Integer isDemo;
  private Date created;
  private Date updated;
}
