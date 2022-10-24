package com.dotk.knowledge.domain.directory.service.impl;

import com.dotk.knowledge.domain.directory.entity.DirectoryDO;
import com.dotk.knowledge.domain.directory.service.DirectoryService;
import com.dotk.knowledge.infra.mapper.DirectoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DirectoryServiceImpl implements DirectoryService {
    public static final int DIRECTORY_ROOT_ID = 0;
    public static final int MAX_LEVEL = 5;
    public static final int REDIS_DDL = 360;
    public static final int DIRECTORY_ORG_TYPE = 1;//企业文库
    public static final int DIRECTORY_COURSE_TYPE = 2;//课程目录
    public static final int DIRECTORY_POOL_TYPE = 3;//知识库目录


    @Autowired
    DirectoryMapper directoryMapper;

    @Override
    public int create(DirectoryDO directory){
        LocalDateTime localDateTime = LocalDateTime.now();
        DirectoryDO parentDir = getById(directory.getParentId());
        directory.setType(DIRECTORY_COURSE_TYPE);
        directory.setAid(1018);
        directory.setCreatorId(0);
        directory.setStatus(1);
        directory.setCreated(localDateTime.getSecond());
        directory.setUpdated(localDateTime.getSecond());
        return directoryMapper.create(directory);
    }

    @Override
    public List<DirectoryDO> listDirectory(){
        return directoryMapper.listDirectory();
    }

    @Override
    public List<DirectoryDO> listH5Directory(){
        return directoryMapper.listDirectory();
    }

    @Override
    public int removeDirectory(Integer id){
        LocalDateTime localDateTime = LocalDateTime.now();
        DirectoryDO directory = getById(id);
        directory.setUpdatedEid(12);
        directory.setUpdated(localDateTime.getSecond());
        return directoryMapper.removeDirectory(directory);
    }

    @Override
    public DirectoryDO getById(Integer id){
        return directoryMapper.getById(id);
    }

    @Override
    public DirectoryDO getByName(String name){
        return directoryMapper.getByName(name);
    }
}
