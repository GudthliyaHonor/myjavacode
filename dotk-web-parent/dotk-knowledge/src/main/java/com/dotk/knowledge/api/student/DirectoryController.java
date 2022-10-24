package com.dotk.knowledge.api.student;

import com.dotk.core.controller.BaseController;
import com.dotk.knowledge.domain.directory.entity.DirectoryDO;
import com.dotk.knowledge.domain.directory.service.impl.DirectoryServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class DirectoryController extends BaseController {
    @Autowired
    DirectoryServiceImpl directoryServiceImpl;

    /**
     * oldApi:/directories/h5
     * @return
     */
    @GetMapping("/directories/h5")
    public List<DirectoryDO> ListH5Directory() {
        return directoryServiceImpl.listH5Directory();
    }
}
