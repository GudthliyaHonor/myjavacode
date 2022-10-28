package com.dotk.platform.domain.service.impl;

import com.dotk.platform.domain.service.AccountFeatureService;
import com.dotk.platform.domain.vo.AccountFeatureVO;
import com.dotk.platform.infra.mapper.AccountFeatureMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountFeatureServiceImpl implements AccountFeatureService {

  @Autowired
  private AccountFeatureMapper accountFeatureMapper;

  @Override
  public List<AccountFeatureVO> selectAccountFeatureList(AccountFeatureVO accountFeatureVO) {
    return accountFeatureMapper.selectAccountFeatureList(accountFeatureVO);
  }
}
