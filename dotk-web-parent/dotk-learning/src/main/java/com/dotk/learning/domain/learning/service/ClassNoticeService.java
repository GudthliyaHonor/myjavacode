package com.dotk.learning.domain.learning.service;

import com.dotk.learning.domain.learning.bo.ClassNoticeBo;
import com.dotk.learning.domain.learning.entity.ClassNoticeEntity;

import java.util.Map;

public interface ClassNoticeService {
    /**
     * 公告列表
     *
     * @param classNoticeBo
     * @return
     */
    Map<String, Object> list(ClassNoticeBo classNoticeBo);

    /**
     * 公告详情
     *
     * @param noticeId
     * @return
     */
    Map<String, Object> detail(Long noticeId);

    /**
     * 新增公告
     *
     * @param classNoticeEntity
     * @return
     */
    Long create(ClassNoticeEntity classNoticeEntity);

    /**
     * 编辑公告
     *
     * @param classNoticeEntity
     * @return
     */
    Integer edit(ClassNoticeEntity classNoticeEntity);

    /**
     * 删除公告
     *
     * @param noticeId
     * @return
     */
    Integer delete(Long noticeId);

    /**
     * 置顶/取消置顶公告
     *
     * @param noticeId
     * @return
     */
    Integer setTop(Long noticeId, Integer type);
}
