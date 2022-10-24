package com.dotk.knowledge.domain.course.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OfflineTeachingDo {
    private int id;
    private int aid;
    private String name;
    private String number;
    private int form;
    private int classificationId;
    private String classificationName;
    private float period;
    private String vendor;
    private String target;
    private String outline;
    private String cover;
    private int departmentId;
    private String departmentName;
    private int show;
    private int from;
    private int from_id;
    private int relevance;
    private int creditSetting;
    private Date startTime;
    private Date EndTime;
    private String address;
    private int isShared;
    private int usePermission;
    private int classification;
    private Date authenticatedTime;
    private int eid;
    private int status;
    private int enabled;
    private String periodUnit;
    private Date created;
    private Date updated;
    private Date deleted;
    private int updatedEid;
    private Date deletedEid;
}
