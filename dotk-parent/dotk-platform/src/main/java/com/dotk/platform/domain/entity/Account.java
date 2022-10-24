package com.dotk.platform.domain.entity;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dotk.core.annotation.Excel;
import com.dotk.core.domain.BaseEntity;

/**
 * 公司Entity
 *
 * @author lgh<liguanghui@yidianzhishi.com>
 * @date 2022-09-08
 */
public class Account extends BaseEntity
{
  private static final long serialVersionUID = 1L;

  /** 公司ID */
  private Integer id;

  /** 公司编号，只有小写 */
  @Excel(name = "公司编号，只有小写")
  private String code;

  /** 公司名称 */
  @Excel(name = "公司名称")
  private String name;

  /** 公司描述 */
  @Excel(name = "公司描述")
  private String desc;

  /** 公司编号展示名称，可以有大小写 */
  @Excel(name = "公司编号展示名称，可以有大小写")
  private String codeDisplay;

  /** 条目状态 */
  @Excel(name = "条目状态")
  private Integer status;

  /** 是否试用账号 */
  @Excel(name = "是否试用账号")
  private Integer isDemo;

  /** 创建时间 */
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
  private Date created;

  /** 更新时间 */
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
  private Date updated;

  public void setId(Integer id)
  {
    this.id = id;
  }

  public Integer getId()
  {
    return id;
  }
  public void setCode(String code)
  {
    this.code = code;
  }

  public String getCode()
  {
    return code;
  }
  public void setName(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }
  public void setDesc(String desc)
  {
    this.desc = desc;
  }

  public String getDesc()
  {
    return desc;
  }
  public void setCodeDisplay(String codeDisplay)
  {
    this.codeDisplay = codeDisplay;
  }

  public String getCodeDisplay()
  {
    return codeDisplay;
  }
  public void setStatus(Integer status)
  {
    this.status = status;
  }

  public Integer getStatus()
  {
    return status;
  }
  public void setIsDemo(Integer isDemo)
  {
    this.isDemo = isDemo;
  }

  public Integer getIsDemo()
  {
    return isDemo;
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
        .append("code", getCode())
        .append("name", getName())
        .append("desc", getDesc())
        .append("codeDisplay", getCodeDisplay())
        .append("status", getStatus())
        .append("isDemo", getIsDemo())
        .append("created", getCreated())
        .append("updated", getUpdated())
        .toString();
  }
}

