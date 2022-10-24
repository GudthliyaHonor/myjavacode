package com.dotk.learning.api.admin.dto;

import com.dotk.core.utils.valid.EnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ClassNoticeDto {

    private Integer id;

    @Valid
    @NotNull(message = "参数错误")
    private RecordDto record;

    @Data
    public static class RecordDto {
        @Valid
        @NotNull(message = "公告内容不能为空")
        private List<ContentDto> content;//公告内容

        @JsonProperty("is_top")
        @EnumValue(intValues = {0, 1}, message = "参数错误")
        private Integer isTop;//是否置顶 0否 1是

        @JsonProperty("learning_id")
        @NotNull(message = "参数错误")
        private Integer learningId;//学习ID

        @NotBlank(message = "公告标题不能为空")
        private String name;//公告标题
    }

    @Data
    public static class ContentDto {

        @NotNull
        @EnumValue(intValues = {1, 2}, message = "参数错误")
        private Integer type;//内容类型 1文字 2图片

        @JsonProperty("sub_content")
        @NotBlank(message = "内容不能为空")
        private String subContent;//内容
    }
}
