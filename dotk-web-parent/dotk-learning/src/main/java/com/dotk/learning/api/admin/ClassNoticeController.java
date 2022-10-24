package com.dotk.learning.api.admin;

import com.alibaba.fastjson2.JSONObject;
import com.dotk.core.annotation.ApiRestController;
import com.dotk.core.controller.BaseController;
import com.dotk.core.domain.AjaxResult;
import com.dotk.learning.api.admin.dto.ClassNoticeDto;
import com.dotk.learning.api.admin.dto.PageDto;
import com.dotk.learning.api.admin.dto.query.ClassNoticeListQuery;
import com.dotk.learning.api.admin.vo.ClassNoticeListVo;
import com.dotk.learning.domain.notice.entity.ClassNoticeEntity;
import com.dotk.learning.domain.notice.service.ClassNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@ApiRestController
@Validated
public class ClassNoticeController extends BaseController {

    @Autowired
    private ClassNoticeService classNoticeService;

    @GetMapping("class/notice/list")
    public AjaxResult classNoticeList(
            @NotNull(message = "learning_id不能为空") Integer learning_id,
            String keyword,
            String pg
    ) {
        //注入dto
        PageDto pageDto = JSONObject.parseObject(pg, PageDto.class);
        //query对象
        ClassNoticeListQuery query = new ClassNoticeListQuery(learning_id, keyword, pageDto.calcOffset(), pageDto.getItemsPerPage());
        query.setAid(1018);
        query.setStatus(1);
        //查询列表
        List<ClassNoticeListVo> list = classNoticeService.classNoticeList(query);

        return AjaxResult.success(list);
    }

    /**
     * 新建班级公告
     */
    @PutMapping("/class/notice/create")
    public AjaxResult classNoticeCreate(@Valid @RequestBody ClassNoticeDto classNoticeCreateDto) {
        Integer id = classNoticeService.classNoticeCreate(classNoticeCreateDto);
        return AjaxResult.success(id);
    }

    /**
     * 编辑班级公告
     */
    @PostMapping("/class/notice/edit")
    public AjaxResult classNoticeEdit(@Valid @RequestBody ClassNoticeDto classNoticeCreateDto) {
        Boolean result = classNoticeService.classNoticeEdit(classNoticeCreateDto);

        if (result) {
            return AjaxResult.success("更新成功");
        } else {
            return AjaxResult.error("更新失败");
        }
    }

    /**
     * 删除公告
     */
    @DeleteMapping("/class/notice/{notice_id}/delete")
    public AjaxResult classNoticeDelete(@PathVariable("notice_id") Integer notice_id) {
        ClassNoticeEntity classNoticeEntity = new ClassNoticeEntity();
        classNoticeEntity.setId(notice_id);
        classNoticeEntity.setStatus(0);

        Boolean result = classNoticeService.classNoticeDelete(classNoticeEntity);

        if (result) {
            return AjaxResult.success("删除成功");
        } else {
            return AjaxResult.error("删除失败");
        }
    }

}
