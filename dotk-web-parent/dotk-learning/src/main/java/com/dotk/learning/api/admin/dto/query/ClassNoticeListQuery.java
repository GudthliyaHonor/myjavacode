package com.dotk.learning.api.admin.dto.query;

import lombok.Data;

@Data
public class ClassNoticeListQuery {
    private Integer aid;
    private Integer status;
    private Integer learningId;
    private String keyword;
    private Integer offset;
    private Integer itemsPerPage;

    public ClassNoticeListQuery(Integer learningId, String keyword, Integer offset, Integer itemsPerPage) {
        this.learningId = learningId;
        this.keyword = "%" + keyword + "%";
        this.offset = offset;
        this.itemsPerPage = itemsPerPage;
    }
}
