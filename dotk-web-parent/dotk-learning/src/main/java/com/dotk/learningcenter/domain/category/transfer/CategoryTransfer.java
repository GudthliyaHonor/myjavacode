package com.dotk.learningcenter.domain.category.transfer;

import com.dotk.learningcenter.api.admin.dto.CreateCategoryDto;
import com.dotk.learningcenter.domain.category.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryTransfer {

    CategoryEntity toCategoryEntity(CreateCategoryDto source);
}
