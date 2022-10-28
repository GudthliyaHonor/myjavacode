package com.dotk.core.domain;

public class BaseTenantEntity extends BaseEntity {
  /** 公司ID */
  private Long aid;

  public Long getAid() {
    return aid;
  }

  public void setAid(Long aid) {
    this.aid = aid;
  }
}
