package com.dotk.knowledge.domain.directory.service;

import com.dotk.knowledge.domain.directory.entity.DirectoryDO;

import java.util.List;

public interface DirectoryService {
    int create(DirectoryDO directory);
    List<DirectoryDO> listDirectory();
    List<DirectoryDO> listH5Directory();
    int removeDirectory(Integer id);
    DirectoryDO getById(Integer id);
    DirectoryDO getByName(String name);
}
