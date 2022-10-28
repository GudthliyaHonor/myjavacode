package com.dotk.platform.api.controller;


import com.alibaba.fastjson2.JSONObject;
import com.dotk.core.annotation.ApiRestController;
import com.dotk.core.controller.BaseController;
import com.dotk.core.domain.AjaxResult;
import com.dotk.core.domain.AppContextHolder;
import com.dotk.core.domain.model.AppContext;
import com.dotk.core.domain.model.Tenant;
import com.dotk.platform.api.dto.AccountListQueryDTO;
import com.dotk.platform.domain.service.AccountFeatureService;
import com.dotk.platform.domain.service.AccountService;
import com.dotk.platform.domain.vo.AccountFeatureVO;
import com.dotk.platform.domain.vo.AccountVO;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@ApiRestController("/account")
public class AccountController extends BaseController {

  @Autowired
  private AccountService accountService;

  @Autowired
  private AccountFeatureService accountFeatureService;

  /**
   * 获取当前登录公司信息。
   *
   * @return
   */
  @GetMapping("/current")
  public AjaxResult current() {
    AppContext appContext = AppContextHolder.getContext();
    return success(appContext.getTenant());
  }

  /**
   * Get account list.
   *
   * @param dto
   * @return
   */
  @GetMapping("/list")
  public AjaxResult list(AccountListQueryDTO dto) {
    if (dto == null) {
      dto = new AccountListQueryDTO();
    }

    AccountVO vo = JSONObject.parseObject(JSONObject.toJSONString(dto.getFilter()), AccountVO.class);
    if (vo == null) {
      vo = new AccountVO();
    }

    List<Tenant> list = accountService.selectAccountList(vo);
    AjaxResult result = AjaxResult.success();
    result.putData("list", list);
    return result;
  }

  @GetMapping("/features")
  public AjaxResult features(@RequestParam AccountFeatureVO accountFeatureVO) {
    accountFeatureService.selectAccountFeatureList(accountFeatureVO);
    AjaxResult result = AjaxResult.success();
    return result;
  }

  @GetMapping("/test")
  public AjaxResult test(@RequestParam(required = false) String filter) {
    AccountListQueryDTO dto = null;
    if (null == filter) {
      dto = new AccountListQueryDTO();
    }
    else {
      dto = JSONObject.parseObject(filter, AccountListQueryDTO.class);
    }
    log.info(String.valueOf(dto));
    AccountListQueryDTO newDto = parseParam(filter, AccountListQueryDTO.class);
    log.info(String.valueOf(newDto));
    return AjaxResult.success();
  }
}
