package com.dotk.core.domain;

import com.dotk.core.domain.entity.SysUser;
import com.dotk.core.domain.model.AppContext;
import com.dotk.core.domain.model.Tenant;

public class AppContextHolder {

  private static final ThreadLocal<AppContext> contextHolder = new ThreadLocal<>();

  public static AppContext getContext() {
    return contextHolder.get();
  }

  public static void setContext(AppContext context) {
    contextHolder.set(context);
  }

  public static void clearContext() {
    contextHolder.remove();
  }

  public static SysUser getUser() {
    AppContext info = getContext();
    return info != null ? info.getUser() : null;
  }

  public static long getUserId() {
    SysUser user = getUser();
    return user != null ? user.getId() : 0;
  }

  public static Tenant getTenant() {
    AppContext info = getContext();
    return info != null ? info.getTenant() : null;
  }

  public static long getTenantId() {
    Tenant tenant = getTenant();
    return tenant != null ? tenant.getId() : 0;
  }

  /**
   * @see AppContextHolder#getTenantId
   *
   * @return Tenant ID(Account ID)
   */
  public static long getAid() {
    return getTenantId();
  }
}
