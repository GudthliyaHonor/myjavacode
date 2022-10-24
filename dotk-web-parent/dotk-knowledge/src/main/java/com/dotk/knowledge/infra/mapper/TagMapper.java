package com.dotk.knowledge.infra.mapper;

import com.dotk.knowledge.domain.tag.entity.TagDo;
import org.springframework.stereotype.Repository;

@Repository
public interface TagMapper {
    int create(TagDo tagDo);
}
