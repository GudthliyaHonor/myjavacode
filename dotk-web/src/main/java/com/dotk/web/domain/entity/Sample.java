package com.dotk.web.domain.entity;

import com.dotk.core.annotation.Excel;
import com.dotk.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Sample extends BaseEntity {
  private static final long serialVersionUID = 1L;

  /** Sample name */
  @Excel(name = "Sample name")
  private String name;

  public void setName(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
        .append("id", getId())
        .append("name", getName())
        .append("created", getCreated())
        .append("updated", getUpdated())
        .toString();
  }
}
