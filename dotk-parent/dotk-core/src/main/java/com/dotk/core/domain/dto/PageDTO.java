package com.dotk.core.domain.dto;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @author hailanzhou
 * @create 2022-10-19 09:28
 * @desc
 **/
@Data
public class PageDTO {


    @Min(value = 1,message = "页码必须大于1")
    private Integer page=1;


    @Min(value = 1,message = "每页的数量必须大于1")
    private Integer itemsPerPage;
}
