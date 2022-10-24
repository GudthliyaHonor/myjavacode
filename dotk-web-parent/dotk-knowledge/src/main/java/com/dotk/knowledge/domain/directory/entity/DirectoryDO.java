package com.dotk.knowledge.domain.directory.entity;

import lombok.Data;

@Data
public class DirectoryDO {
    private int id;
    private int poolId;
    private String name;
    private int parentId;
    private int aid;
    private int departmentName;
    private int departmentId;
    private int type;
    private int sort;
    private int creatorId;
    private int updatedEid;
    private int status;
    private int created;
    private int updated;
    private int level;
    private String removeReason;
}