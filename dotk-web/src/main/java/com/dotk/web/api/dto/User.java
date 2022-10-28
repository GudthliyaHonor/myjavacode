package com.dotk.web.api.dto;

import com.dotk.web.enums.UserTypeEnum;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

