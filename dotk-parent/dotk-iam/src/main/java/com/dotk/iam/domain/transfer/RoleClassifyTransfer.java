package com.dotk.iam.domain.transfer;

import com.dotk.iam.api.controller.dto.QueryRoleClassifyDTO;
import com.dotk.iam.domain.bo.QueryRoleClassifyBO;
import com.dotk.iam.domain.entity.RoleClassifyEntity;
import com.dotk.iam.domain.vo.RoleClassifyVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author hailanzhou
 * @create 2022-10-19 09:44
 * @desc
 **/
@Mapper(componentModel = "spring")
public interface RoleClassifyTransfer {
    RoleClassifyTransfer INSTANCE = Mappers.getMapper(RoleClassifyTransfer.class);


    @Mapping(source = "pageDTO.itemsPerPage",target = "size")
    @Mapping(source = "pageDTO.page",target = "page")
    QueryRoleClassifyBO convert(QueryRoleClassifyDTO source);


    List<RoleClassifyVO> toRoleClassifyList(List<RoleClassifyEntity> roleClassifyList);

}
