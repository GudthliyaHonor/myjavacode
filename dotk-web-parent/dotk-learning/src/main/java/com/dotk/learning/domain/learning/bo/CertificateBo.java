package com.dotk.learning.domain.learning.bo;

import lombok.Data;

@Data
public class CertificateBo {

    /** 证书ID */
    public Integer id;

    /** 证书编号 */
    public String no;

    /** 证书名称*/
    public String name;
}
