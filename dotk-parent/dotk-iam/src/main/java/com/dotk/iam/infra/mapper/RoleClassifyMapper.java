package com.dotk.iam.infra.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dotk.iam.domain.entity.RoleClassifyEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleClassifyMapper extends BaseMapper<RoleClassifyEntity> {

    default RoleClassifyEntity selectByName(String name){
        return selectOne(new QueryWrapper<RoleClassifyEntity>().eq("name",name));
    }

    default Long count(){
        return selectCount(null);
    }

    void incrRoleClassifyCount(Long categoryId);

    void descRoleClassifyCount(Long categoryId);

}
