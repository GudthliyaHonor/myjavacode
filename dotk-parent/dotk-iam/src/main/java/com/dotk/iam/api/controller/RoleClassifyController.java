package com.dotk.iam.api.controller;

import com.dotk.core.annotation.ApiRestController;
import com.dotk.core.controller.BaseController;
import com.dotk.core.domain.AjaxResult;
import com.dotk.core.exception.ServiceException;
import com.dotk.core.utils.SecurityUtils;
import com.dotk.iam.api.controller.dto.DeleteRoleClassifyDTO;
import com.dotk.iam.api.controller.dto.QueryRoleClassifyDTO;
import com.dotk.iam.api.controller.dto.RoleClassifyCreateDTO;
import com.dotk.iam.api.controller.dto.UpdateRoleClassifyDTO;
import com.dotk.iam.common.enums.ErrorCodeConstants;
import com.dotk.iam.domain.bo.QueryRoleClassifyBO;
import com.dotk.iam.domain.service.RoleClassifyService;
import com.dotk.iam.domain.transfer.RoleClassifyTransfer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Validated
@ApiRestController
public class RoleClassifyController extends BaseController {

    @Autowired
    private RoleClassifyService roleClassifyService;

    @PutMapping("/permission/role/classify")
    public AjaxResult createRoleClassify(@Validated @RequestBody RoleClassifyCreateDTO roleClassifyCreateDTO){
        Long id=roleClassifyService.createRoleClassify(roleClassifyCreateDTO.getName());
        return success(id);
    }

    @PostMapping("/permission/role/classify/update")
    public AjaxResult updateRoleClassify(@Validated @RequestBody UpdateRoleClassifyDTO updateRoleClassifyDTO){
        roleClassifyService.updateRoleClassify(updateRoleClassifyDTO.getId(), updateRoleClassifyDTO.getName());
        return success();
    }

    @PostMapping("/permission/role/classify/delete")
    public AjaxResult deleteRoleClassify(@Validated @RequestBody DeleteRoleClassifyDTO deleteClassifyDTO){
        roleClassifyService.deleteRoleClassify(deleteClassifyDTO.getId());
        return success();
    }

    /**
     * 测试异常类
     * @return
     */
    @PostMapping("/service/error")
    public AjaxResult errorMsg(){
        throw new ServiceException(ErrorCodeConstants.ROLE_CLASSIFY_EXISTS);
    }

    @PostMapping("/permission/role/classify/list")
    public AjaxResult list(@Validated @RequestBody QueryRoleClassifyDTO queryRoleClassifyDTO){
        QueryRoleClassifyBO queryRoleClassifyBO= RoleClassifyTransfer.INSTANCE.convert(queryRoleClassifyDTO);
//        long aid=SecurityUtils.getLoginUser().getAid();
//        log.info("aid:{}",aid);
        log.info("queryRoleClassifyBO:{}",queryRoleClassifyBO);
        return success(roleClassifyService.list(queryRoleClassifyBO));
    }
}
