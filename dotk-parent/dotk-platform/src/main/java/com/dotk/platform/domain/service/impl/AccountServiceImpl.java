package com.dotk.platform.domain.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.dotk.core.cache.CacheService;
import com.dotk.core.domain.model.Tenant;
import com.dotk.platform.constant.Cache;
import com.dotk.platform.domain.service.AccountService;
import com.dotk.platform.domain.vo.AccountVO;
import com.dotk.platform.infra.mapper.AccountMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  private AccountMapper accountMapper;

  @Autowired
  private CacheService cacheService;

  @Override
  public Tenant selectAccountById(Long id) {
    String cacheKey = getItemCacheKey(id);
    Tenant tenant = cacheService.getCacheObject(cacheKey);
    if (null == tenant) {
      tenant = accountMapper.selectAccountById(id);
      if (null != tenant) {
        cacheService.setCacheObject(cacheKey, tenant);
      }
    }
    return tenant;
  }

  private String getItemCacheKey(Long id) {
    return Cache.ACCOUNT_ITEM_ID_KEY + id;
  }

  private String getItemCacheKey(String code) {
    return Cache.ACCOUNT_ITEM_CODE_KEY + code;
  }

  @Override
  public Tenant selectAccountByCode(String code) {
    code = code.toLowerCase();

    String cacheKey = getItemCacheKey(code);
    Tenant tenant = cacheService.getCacheObject(cacheKey);
    if (null == tenant) {
      tenant = accountMapper.selectAccountByCode(code);
      if (null != tenant) {
        cacheService.setCacheObject(cacheKey, tenant);
      }
    }
    return tenant;
  }

  @Override
  public List<Tenant> selectAccountList(AccountVO accountVO) {
    Tenant tenant = JSONObject.parseObject(JSONObject.toJSONString(accountVO), Tenant.class);
    return accountMapper.selectAccountList(tenant);
  }


}
