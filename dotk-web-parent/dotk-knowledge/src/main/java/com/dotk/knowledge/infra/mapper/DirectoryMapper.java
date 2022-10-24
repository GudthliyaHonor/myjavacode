package com.dotk.knowledge.infra.mapper;

import com.dotk.knowledge.domain.directory.entity.DirectoryDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectoryMapper {
    int create(DirectoryDO directory);
    List<DirectoryDO> listDirectory();
    int removeDirectory(DirectoryDO directory);
    DirectoryDO getById(Integer id);
    DirectoryDO getByName(String name);
}
