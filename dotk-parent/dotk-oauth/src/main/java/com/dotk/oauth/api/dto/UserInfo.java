package com.dotk.oauth.api.dto;


import java.util.HashMap;
import java.util.Map;

public class UserInfo {

  private String display;
  private String uid;
  private String eid;

  public String getDisplay() {
    return display;
  }

  public void setDisplay(String display) {
    this.display = display;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public String getEid() {
    return eid;
  }

  public void setEid(String eid) {
    this.eid = eid;
  }

  public Map<String, Object> toMap() {
    Map<String, Object> map = new HashMap<>();
    map.put("uid", uid);
    map.put("eid", eid);
    map.put("display", display);
    return map;
  }
}
