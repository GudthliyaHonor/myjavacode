package com.dotk.knowledge.domain.tag.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TagDo {
    private int id;
    private int aid;
    private String name;
    private int categoryId;
    private int uses;
    private int type;
    private int eid;
    private String username;
    private int form;
    private int status;
    private Date created;
    private Date updated;
    private int updatedEid;
    private int deletedEid;
    private Date deleted;
}
