package com.dotk.platform.domain.service;

import com.dotk.core.domain.model.Tenant;
import com.dotk.platform.domain.vo.AccountVO;
import java.util.List;

public interface AccountService {
  public Tenant selectAccountById(Long id);

  public Tenant selectAccountByCode(String code);

  public List<Tenant> selectAccountList(AccountVO accountVO);
}
