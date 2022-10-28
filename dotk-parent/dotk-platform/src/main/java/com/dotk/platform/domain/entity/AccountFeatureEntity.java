package com.dotk.platform.domain.entity;

import com.dotk.core.domain.BaseTenantEntity;
import lombok.Data;

@Data
public class AccountFeatureEntity extends BaseTenantEntity {

  /** Feature name */
  private String name;

  /** Feature value */
  private String value;

}
