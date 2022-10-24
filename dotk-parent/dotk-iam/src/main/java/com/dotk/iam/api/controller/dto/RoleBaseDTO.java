package com.dotk.iam.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author hailanzhou
 * @create 2022-10-19 13:51
 * @desc
 **/
public class RoleBaseDTO {

    /**
    * @Description:
    * @Author hailanzhou
    * @Date: 2022/10/19 13:53
    * @return
     *     /**
     *     * @Description:
     *     * @Author hailanzhou
     *     * @Date: 2022/10/19 13:47
     *     * @return
     *      * {"record":{"name":"测试角色","description":"rrr","attribute_dept_ids":[10429,10433],"classify_id":10007,"classify_name":"分类"}}
     *     */

    @NotBlank(message = "角色名称不能为空")
    private String name;

    private String description;

    @JsonProperty(value = "attribute_dept_ids")
    @NotBlank(message = "所属组织不能为空")
    private List<Long> attributeDepartment;

    @JsonProperty(value = "classify_id")
    private Long classifyId;

    @JsonProperty(value = "classify_id")
    private String classifyName;

}
