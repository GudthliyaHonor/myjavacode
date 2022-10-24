package com.dotk.learning.api.admin.dto.learning;

import lombok.Data;

@Data
public class CertificateDto {

    /** 证书ID */
    public Integer id;

    /** 证书编号 */
    public String no;

    /** 证书名称*/
    public String name;
}
