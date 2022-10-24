package com.dotk.iam.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dotk.iam.domain.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity> {
    public int createQuestionBank(RoleEntity questionBankEntity);

    public RoleEntity getInfoById(Long id);

}
