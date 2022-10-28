package com.dotk.learning.domain.learning.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dotk.core.utils.StringUtils;
import com.dotk.learning.domain.learning.bo.ClassNoticeBo;
import com.dotk.learning.domain.learning.entity.ClassNoticeEntity;
import com.dotk.learning.domain.learning.service.ClassNoticeService;
import com.dotk.learning.domain.learning.transfer.ClassNoticeTransfer;
import com.dotk.learning.infra.mapper.ClassNoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClassNoticeServiceImpl implements ClassNoticeService {
    @Autowired
    private ClassNoticeMapper classNoticeMapper;

    @Autowired
    private ClassNoticeTransfer classNoticeTransfer;

    /**
     * 公告列表
     *
     * @param classNoticeBo
     * @return
     */
    @Override
    public Map<String, Object> list(ClassNoticeBo classNoticeBo) {
        Page<ClassNoticeEntity> page = new Page<>(classNoticeBo.getPage(), classNoticeBo.getSize());

        QueryWrapper<ClassNoticeEntity> condition = getCondition(classNoticeBo);

        Page<ClassNoticeEntity> result = classNoticeMapper.selectPage(page, condition);

        Map<String, Object> map = new HashMap<>();
        map.put("total", result.getTotal());
        map.put("list", classNoticeTransfer.listEntityToVo(result.getRecords()));

        return map;
    }

    /**
     * 公告详情
     *
     * @param noticeId
     * @return
     */
    public Map<String, Object> detail(Long noticeId) {
        QueryWrapper<ClassNoticeEntity> wrapper = getWrapper();
        wrapper.eq("id", noticeId);

        ClassNoticeEntity classNoticeEntity = classNoticeMapper.selectOne(wrapper);

        Map<String, Object> map = new HashMap<>();
        map.put("res", classNoticeTransfer.detailEntityToVo(classNoticeEntity));

        return map;
    }

    /**
     * 新增公告
     *
     * @param classNoticeEntity
     * @return
     */
    @Override
    public Long create(ClassNoticeEntity classNoticeEntity) {
        // 填充数据
        fillData(classNoticeEntity);
        classNoticeMapper.insert(classNoticeEntity);
        return classNoticeEntity.getId();
    }

    /**
     * 编辑公告
     *
     * @param classNoticeEntity
     * @return
     */
    @Override
    public Integer edit(ClassNoticeEntity classNoticeEntity) {
        // 数据填充
        fillData(classNoticeEntity);

        QueryWrapper<ClassNoticeEntity> wrapper = getWrapper();
        wrapper.eq("id", classNoticeEntity.getId());

        return classNoticeMapper.update(classNoticeEntity, wrapper);
    }

    /**
     * 删除公告
     *
     * @param noticeId
     * @return
     */
    @Override
    public Integer delete(Long noticeId) {
        QueryWrapper<ClassNoticeEntity> wrapper = getWrapper();
        wrapper.eq("id", noticeId).eq("status", 1);

        ClassNoticeEntity classNoticeEntity = new ClassNoticeEntity();
        classNoticeEntity.setStatus(0);
        classNoticeEntity.setDeletedTime(new Date());
//        classNoticeEntity.setUpdatedBy();
        return classNoticeMapper.update(classNoticeEntity, wrapper);
    }

    public Integer setTop(Long noticeId, Integer type) {
        QueryWrapper<ClassNoticeEntity> wrapper = getWrapper();
        wrapper.eq("id", noticeId).eq("status", 1);

        ClassNoticeEntity classNoticeEntity = new ClassNoticeEntity();
        classNoticeEntity.setIsTop(type);

        return classNoticeMapper.update(classNoticeEntity, wrapper);
    }

    /**
     * 新增或编辑时默认数据填充
     *
     * @param classNoticeEntity
     */
    protected void fillData(ClassNoticeEntity classNoticeEntity) {
        if (classNoticeEntity.getId() == null) {//新增
            //            classNoticeEntity.setOperator();
//            classNoticeEntity.setOperatorName();
//            classNoticeEntity.setCreator();
            classNoticeEntity.setStatus(1);
            classNoticeEntity.setPublishTime(new Date());
            classNoticeEntity.setType(1);

        } else {//编辑
//            classNoticeEntity.setUpdator();
//            classNoticeEntity.setUpdatorName();
        }
    }

    /**
     * 获取列表条件
     *
     * @param classNoticeBo
     * @return
     */
    QueryWrapper<ClassNoticeEntity> getCondition(ClassNoticeBo classNoticeBo) {
        QueryWrapper<ClassNoticeEntity> wrapper = getWrapper();

        wrapper.eq("learning_id", classNoticeBo.getLearningId()).eq("status", 1).like(StringUtils.isNotBlank(classNoticeBo.getKeyword()), "name", classNoticeBo.getKeyword());

        return wrapper;
    }

    /**
     * 获取通用 QueryWrapper
     *
     * @return
     */
    QueryWrapper<ClassNoticeEntity> getWrapper() {
        QueryWrapper<ClassNoticeEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("aid", 1);
        return wrapper;
    }
}
