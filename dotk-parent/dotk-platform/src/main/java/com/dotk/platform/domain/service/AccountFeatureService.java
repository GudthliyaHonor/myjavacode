package com.dotk.platform.domain.service;

import com.dotk.platform.domain.vo.AccountFeatureVO;
import java.util.List;

public interface AccountFeatureService {
  public List<AccountFeatureVO> selectAccountFeatureList(AccountFeatureVO accountFeatureVO);
}
