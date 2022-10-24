package com.dotk.knowledge.domain.tag.service.impl;

import com.dotk.knowledge.domain.tag.entity.TagDo;
import com.dotk.knowledge.domain.tag.service.TagService;
import com.dotk.knowledge.infra.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public int create(TagDo tagDo){
        return tagMapper.create(tagDo);
    }
}
