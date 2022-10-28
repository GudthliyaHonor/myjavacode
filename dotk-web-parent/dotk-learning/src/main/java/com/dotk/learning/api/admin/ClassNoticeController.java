package com.dotk.learning.api.admin;

import com.alibaba.fastjson2.JSONObject;
import com.dotk.core.annotation.ApiRestController;
import com.dotk.core.controller.BaseController;
import com.dotk.core.domain.AjaxResult;
import com.dotk.core.domain.dto.PageDTO;
import com.dotk.learning.api.admin.dto.learning.ClassNoticeDto;
import com.dotk.learning.api.admin.dto.learning.ClassNoticeSetTopDto;
import com.dotk.learning.domain.learning.bo.ClassNoticeBo;
import com.dotk.learning.domain.learning.entity.ClassNoticeEntity;
import com.dotk.learning.domain.learning.service.ClassNoticeService;
import com.dotk.learning.domain.learning.transfer.ClassNoticeTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * 班级公告
 */
@ApiRestController
@Validated
public class ClassNoticeController extends BaseController {

    @Autowired
    private ClassNoticeService classNoticeService;

    /**
     * 公告列表
     *
     * @param learningId
     * @param keyword
     * @param pg
     * @return
     */
    @GetMapping("class/notice/list")
    public AjaxResult list(
            @RequestParam(value = "learning_id") Long learningId,
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "pg", required = false) String pg
    ) {
        //注入dto
        PageDTO pageDto = JSONObject.parseObject(pg, PageDTO.class);

        ClassNoticeBo classNoticeBo = new ClassNoticeBo();
        classNoticeBo.setLearningId(learningId);
        classNoticeBo.setKeyword(keyword);
        classNoticeBo.setPage(pageDto.getPage());
        classNoticeBo.setSize(pageDto.getItemsPerPage());

        //查询列表
        Map<String, Object> map = classNoticeService.list(classNoticeBo);

        return success(map);
    }

    /**
     * 公告详情
     *
     * @param noticeId
     * @return
     */
    @GetMapping("class/notice/detail")
    public AjaxResult detail(@RequestParam("id") Long noticeId) {
        Map<String, Object> map = classNoticeService.detail(noticeId);
        return success(map);
    }

    /**
     * 新建公告
     */
    @PutMapping("/class/notice/create")
    public AjaxResult create(@Valid @RequestBody ClassNoticeDto classNoticeDto) {
        ClassNoticeEntity classNoticeEntity = ClassNoticeTransfer.INSTANCE.dtoToEntity(classNoticeDto.getRecord());

        Long id = classNoticeService.create(classNoticeEntity);
        return success(id);
    }

    /**
     * 编辑公告
     */
    @PostMapping("/class/notice/edit")
    public AjaxResult edit(@Valid @RequestBody ClassNoticeDto classNoticeDto) {
        ClassNoticeEntity classNoticeEntity = ClassNoticeTransfer.INSTANCE.dtoToEntity(classNoticeDto.getRecord());
        classNoticeEntity.setId(classNoticeDto.getId());

        Integer res = classNoticeService.edit(classNoticeEntity);
        if (res > 0) {
            return success("更新成功");
        } else {
            return error("更新失败");
        }
    }

    /**
     * 删除公告
     */
    @DeleteMapping("/class/notice/{notice_id}/delete")
    public AjaxResult delete(@PathVariable("notice_id") Long noticeId) {

        Integer result = classNoticeService.delete(noticeId);

        if (result > 0) {
            return success("删除成功");
        } else {
            return error("删除失败");
        }
    }

    @PostMapping("/class/notice/set/top")
    public AjaxResult setTop(@Valid @RequestBody ClassNoticeSetTopDto classNoticeSetTopDto) {
        Integer result = classNoticeService.setTop(classNoticeSetTopDto.getId(),classNoticeSetTopDto.getType());

        if (result > 0) {
            return success();
        } else {
            return error();
        }
    }
}
