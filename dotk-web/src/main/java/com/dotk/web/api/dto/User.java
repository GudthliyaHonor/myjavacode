package com.dotk.web.api.dto;

import com.dotk.web.enums.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Integer id;
    private String name;
    private String createTime;
    private LocalDateTime updateTime;
    private UserTypeEnum userTypeEnum;
}

