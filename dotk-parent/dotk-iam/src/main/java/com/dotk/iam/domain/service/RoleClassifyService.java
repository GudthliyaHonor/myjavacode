package com.dotk.iam.domain.service;

import com.dotk.iam.domain.bo.QueryRoleClassifyBO;
import com.dotk.iam.domain.vo.RoleClassifyListVO;

public interface RoleClassifyService {

    Long createRoleClassify(String name);

    /**
    * @Description: 初始化分类使用
    * @Author hailanzhou
    * @Date: 2022/10/18 15:56
    * @return java.lang.Long 
    */
    Long initializeRoleClassify();


    void updateRoleClassify(Long id, String name);


    void deleteRoleClassify(Long id);

    void incrRoleClassifyCount(Long id);


    void descRoleClassifyCount(Long id);

    RoleClassifyListVO list(QueryRoleClassifyBO queryRoleClassifyBO);


}
