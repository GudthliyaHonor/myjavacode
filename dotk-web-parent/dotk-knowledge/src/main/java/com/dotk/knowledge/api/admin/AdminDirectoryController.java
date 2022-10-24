package com.dotk.knowledge.api.admin;

import com.dotk.core.annotation.ApiRestController;
import com.dotk.core.controller.BaseController;
import com.dotk.core.domain.AjaxResult;
import com.dotk.knowledge.domain.directory.entity.DirectoryDO;
import com.dotk.knowledge.domain.directory.service.DirectoryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@ApiRestController()
public class AdminDirectoryController extends BaseController {
    @Autowired
    DirectoryService directoryServiceImpl;

    /**
     * oldApi:/directory
     * @param  directory
     * @return
     */
    @PostMapping("/directory")
    public AjaxResult createDirectory(@RequestBody DirectoryDO directory){
        int id =   directoryServiceImpl.create(directory);
        Map<String,Integer> resp=new HashMap<>();
        resp.put("id",id);
        return AjaxResult.success(resp);
    }

    /**
     * oldApi:/directory/(:id)/org
     * @param id
     * @return
     */
    @DeleteMapping("/directory/{id}")
    public int removeDirectory(@PathVariable Integer id){
        return directoryServiceImpl.removeDirectory(id);
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/directory/detail")
    public AjaxResult getDirectoryDetail(@RequestParam Integer id ){
        return AjaxResult.success(directoryServiceImpl.getById(id));
    }
}
