package com.dotk.platform.api.dto;

import lombok.Data;

@Data
public class AccountListQueryDTO {

  private String name;

  private AccountListFilterDTO filter;

  @Data
  private static class AccountListFilterDTO {
    private String name;
  }
}
