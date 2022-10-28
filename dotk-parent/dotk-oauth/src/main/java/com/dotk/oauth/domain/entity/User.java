package com.dotk.oauth.domain.entity;

import com.dotk.core.annotation.Excel;
import com.dotk.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class User extends SysUser {

  private static final long serialVersionUID = 1L;

  /**
   * 用户名
   */
  @Excel(name = "用户名")
  private String username;

  /**
   * 密码，已加密
   */
  @Excel(name = "密码，已加密")
  private String password;

  /**
   * 用于密码加密的加盐值
   */
  @Excel(name = "用于密码加密的加盐值")
  private String salt;

  /**
   * 公司ID
   */
  @Excel(name = "公司ID")
  private Long aid;

  /**
   * 是否需要重置密码
   */
  @Excel(name = "是否需要重置密码")
  private Integer resetPassword;

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getSalt() {
    return salt;
  }

  public void setAid(Long aid) {
    this.aid = aid;
  }

  public Long getAid() {
    return aid;
  }

  public void setResetPassword(Integer resetPassword) {
    this.resetPassword = resetPassword;
  }

  public Integer getResetPassword() {
    return resetPassword;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("id", getId())
        .append("username", getUsername())
        .append("password", getPassword())
        .append("salt", getSalt())
        .append("aid", getAid())
        .append("resetPassword", getResetPassword())
        .append("status", getStatus())
        .append("created", getCreated())
        .append("updated", getUpdated())
        .toString();
  }
}
