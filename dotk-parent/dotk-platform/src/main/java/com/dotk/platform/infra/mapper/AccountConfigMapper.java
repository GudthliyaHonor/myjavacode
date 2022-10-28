package com.dotk.platform.infra.mapper;

import com.dotk.platform.domain.entity.AccountFeatureEntity;
import java.util.List;

public interface AccountConfigMapper {
  /**
   * 通过ID获取公司Config信息。
   *
   * @param id 公司ID
   * @return
   */
  public AccountFeatureEntity selectAccountFeatureById(Integer id);

  /**
   * 查询公司Config列表。
   *
   * @param entity
   * @return
   */
  public List<AccountFeatureEntity> selectAccountFeatureList(AccountFeatureEntity entity);

}
