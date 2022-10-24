package com.dotk.knowledge.api.admin;

import com.dotk.core.annotation.ApiRestController;
import com.dotk.core.domain.AjaxResult;
import com.dotk.knowledge.domain.tag.entity.TagDo;
import com.dotk.knowledge.domain.tag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@ApiRestController
public class TagCourseConroller {
    @Autowired
    TagService tagService;

    /**
     * @param  tagDo
     * @return
     */
    @PostMapping("/tag")
    public AjaxResult createDirectory(@RequestBody TagDo tagDo){
        int id =   tagService.create(tagDo);
        Map<String,Integer> resp=new HashMap<>();
        resp.put("id",id);
        return AjaxResult.success(resp);
    }
}
