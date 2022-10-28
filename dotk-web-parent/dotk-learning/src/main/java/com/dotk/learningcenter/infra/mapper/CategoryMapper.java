package com.dotk.learningcenter.infra.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dotk.learningcenter.domain.category.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<CategoryEntity> {
    public int createCategory(CategoryEntity categoryEntity);


}
