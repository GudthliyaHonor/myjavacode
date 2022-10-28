package com.dotk.platform.infra.mapper;


import com.dotk.platform.domain.vo.AccountFeatureVO;
import java.util.List;

public interface AccountFeatureMapper {
  /**
   * 通过ID获取公司Feature信息。
   *
   * @param id 公司ID
   * @return
   */
  public AccountFeatureVO selectAccountFeatureById(Integer id);

  /**
   * 查询公司Feature列表。
   *
   * @param accountFeatureVO
   * @return
   */
  public List<AccountFeatureVO> selectAccountFeatureList(AccountFeatureVO accountFeatureVO);

}
