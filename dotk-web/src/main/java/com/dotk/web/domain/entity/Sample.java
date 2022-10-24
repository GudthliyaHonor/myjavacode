package com.dotk.web.domain.entity;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dotk.core.annotation.Excel;
import com.dotk.core.domain.BaseEntity;

public class Sample extends BaseEntity {
  private static final long serialVersionUID = 1L;

  /** Sample ID */
  private Integer id;

  /** Sample name */
  @Excel(name = "Sample name")
  private String name;

  /** $column.columnComment */
  @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
  private Integer status;

  /** $column.columnComment */
  @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
  private Date created;

  /** $column.columnComment */
  @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
  private Date updated;

  public void setId(Integer id)
  {
    this.id = id;
  }

  public Integer getId()
  {
    return id;
  }
  public void setName(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }
  public void setStatus(Integer status)
  {
    this.status = status;
  }

  public Integer getStatus()
  {
    return status;
  }
  public void setCreated(Date created)
  {
    this.created = created;
  }

  public Date getCreated()
  {
    return created;
  }
  public void setUpdated(Date updated)
  {
    this.updated = updated;
  }

  public Date getUpdated()
  {
    return updated;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
        .append("id", getId())
        .append("name", getName())
        .append("status", getStatus())
        .append("created", getCreated())
        .append("updated", getUpdated())
        .toString();
  }
}
