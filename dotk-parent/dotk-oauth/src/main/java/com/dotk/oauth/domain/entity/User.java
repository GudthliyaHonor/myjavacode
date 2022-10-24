package com.dotk.oauth.domain.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dotk.core.annotation.Excel;
import com.dotk.core.domain.BaseEntity;

public class User extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 用户ID，全局唯一 */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 密码，已加密 */
    @Excel(name = "密码，已加密")
    private String password;

    /** 用于密码加密的加盐值 */
    @Excel(name = "用于密码加密的加盐值")
    private String salt;

    /** 公司ID */
    @Excel(name = "公司ID")
    private Integer aid;

    /** 是否需要重置密码 */
    @Excel(name = "是否需要重置密码")
    private Integer resetPassword;

    /** 条目状态 */
    @Excel(name = "条目状态")
    private Integer status;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date created;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updated;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setSalt(String salt) 
    {
        this.salt = salt;
    }

    public String getSalt() 
    {
        return salt;
    }
    public void setAid(Integer aid) 
    {
        this.aid = aid;
    }

    public Integer getAid() 
    {
        return aid;
    }
    public void setResetPassword(Integer resetPassword) 
    {
        this.resetPassword = resetPassword;
    }

    public Integer getResetPassword() 
    {
        return resetPassword;
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
