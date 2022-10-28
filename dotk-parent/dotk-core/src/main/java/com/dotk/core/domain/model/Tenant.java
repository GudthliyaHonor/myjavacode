package com.dotk.core.domain.model;

import com.dotk.core.domain.entity.SysAccount;
import java.io.Serializable;
import java.util.Map;

/**
 * 登录的租户（公司）信息，用于登录成功或者获取登录状态。
 */
public class Tenant extends SysAccount implements Serializable {

  private Map<String, Object> extra;

  public Map<String, Object> getExtra() {
    return extra;
  }

  public void setExtra(Map<String, Object> extra) {
    this.extra = extra;
  }
}
