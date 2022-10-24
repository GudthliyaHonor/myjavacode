package com.dotk.iam.domain.vo;

import lombok.Data;

import java.util.List;

/**
 * @author hailanzhou
 * @create 2022-10-19 11:53
 * @desc
 **/
@Data
public class RoleClassifyListVO {

    private Long page;
    private Long limit;
    private Long total;

    private List<RoleClassifyVO> list;
}
