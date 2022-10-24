package com.dotk.knowledge.api.admin;

import com.dotk.core.annotation.ApiRestController;
import com.dotk.core.domain.AjaxResult;
import com.dotk.knowledge.domain.course.entity.OfflineTeachingDo;
import com.dotk.knowledge.domain.course.service.OfflineTeachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@ApiRestController
public class OfflineTeachingConroller {
    @Autowired
    OfflineTeachingService offlineTeachingService;

    /**
     * @param offlineTeachingDo
     * @return
     */
    @PostMapping("/offline_teaching")
    public AjaxResult createTag(@RequestBody OfflineTeachingDo offlineTeachingDo){
        int id =   offlineTeachingService.create(offlineTeachingDo);
        Map<String,Integer> resp=new HashMap<>();
        resp.put("id",id);
        return AjaxResult.success(resp);
    }
}
