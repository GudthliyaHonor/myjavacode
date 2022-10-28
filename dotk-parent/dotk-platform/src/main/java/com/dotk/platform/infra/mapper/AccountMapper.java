package com.dotk.platform.infra.mapper;


import com.dotk.core.domain.model.Tenant;
import java.util.List;

/**
 * 公司Mapper接口
 *
 * @author lgh <liguanghui@yidianzhishi.com>
 * @date 2022-09-08
 */
public interface AccountMapper
{
  /**
   * 通过ID获取公司信息。
   *
   * @param id 公司ID
   * @return
   */
  public Tenant selectAccountById(Long id);

  /**
   * 通过公司code获取公司信息。
   *
   * @param code
   * @return
   */
  public Tenant selectAccountByCode(String code);

  /**
   * 查询公司列表
   *
   * @param tenant 租户信息
   * @return 公司集合
   */
  public List<Tenant> selectAccountList(Tenant tenant);

  /**
   * 新增公司
   *
   * @param tenant 租户信息
   * @return 结果
   */
  public int insertAccount(Tenant tenant);

  /**
   * 修改公司
   *
   * @param tenant 公司
   * @return 结果
   */
  public int updateAccount(Tenant tenant);

  /**
   * 删除公司
   *
   * @param id 公司主键
   * @return 结果
   */
  public int deleteAccountById(Long id);

  /**
   * 批量删除公司
   *
   * @param ids 需要删除的数据主键集合
   * @return 结果
   */
  public int deleteAccountByIds(Long[] ids);
}

