package com.dotk.iam.domain.transfer;

import com.dotk.core.domain.dto.PageDTO;
import com.dotk.iam.api.controller.dto.QueryRoleClassifyDTO;
import com.dotk.iam.domain.bo.QueryRoleClassifyBO;
import com.dotk.iam.domain.entity.RoleClassifyEntity;
import com.dotk.iam.domain.vo.RoleClassifyVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-24T14:14:09+0800",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 1.8.0_342 (Amazon.com Inc.)"
)
@Component
public class RoleClassifyTransferImpl implements RoleClassifyTransfer {

    @Override
    public QueryRoleClassifyBO convert(QueryRoleClassifyDTO source) {
        if ( source == null ) {
            return null;
        }

        QueryRoleClassifyBO queryRoleClassifyBO = new QueryRoleClassifyBO();

        queryRoleClassifyBO.setSize( sourcePageDTOItemsPerPage( source ) );
        queryRoleClassifyBO.setPage( sourcePageDTOPage( source ) );

        return queryRoleClassifyBO;
    }

    @Override
    public List<RoleClassifyVO> toRoleClassifyList(List<RoleClassifyEntity> roleClassifyList) {
        if ( roleClassifyList == null ) {
            return null;
        }

        List<RoleClassifyVO> list = new ArrayList<RoleClassifyVO>( roleClassifyList.size() );
        for ( RoleClassifyEntity roleClassifyEntity : roleClassifyList ) {
            list.add( roleClassifyEntityToRoleClassifyVO( roleClassifyEntity ) );
        }

        return list;
    }

    private Integer sourcePageDTOItemsPerPage(QueryRoleClassifyDTO queryRoleClassifyDTO) {
        if ( queryRoleClassifyDTO == null ) {
            return null;
        }
        PageDTO pageDTO = queryRoleClassifyDTO.getPageDTO();
        if ( pageDTO == null ) {
            return null;
        }
        Integer itemsPerPage = pageDTO.getItemsPerPage();
        if ( itemsPerPage == null ) {
            return null;
        }
        return itemsPerPage;
    }

    private Integer sourcePageDTOPage(QueryRoleClassifyDTO queryRoleClassifyDTO) {
        if ( queryRoleClassifyDTO == null ) {
            return null;
        }
        PageDTO pageDTO = queryRoleClassifyDTO.getPageDTO();
        if ( pageDTO == null ) {
            return null;
        }
        Integer page = pageDTO.getPage();
        if ( page == null ) {
            return null;
        }
        return page;
    }

    protected RoleClassifyVO roleClassifyEntityToRoleClassifyVO(RoleClassifyEntity roleClassifyEntity) {
        if ( roleClassifyEntity == null ) {
            return null;
        }

        RoleClassifyVO roleClassifyVO = new RoleClassifyVO();

        roleClassifyVO.setId( roleClassifyEntity.getId() );
        roleClassifyVO.setName( roleClassifyEntity.getName() );
        roleClassifyVO.setCreatorDisplay( roleClassifyEntity.getCreatorDisplay() );

        return roleClassifyVO;
    }
}
