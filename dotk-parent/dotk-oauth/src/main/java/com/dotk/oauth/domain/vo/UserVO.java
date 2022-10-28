package com.dotk.oauth.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserVO {

  private Long id;

  private String username;

  private String salt;

  private Long aid;

  @JsonProperty("reset_password")
  private Integer resetPassword;

}
