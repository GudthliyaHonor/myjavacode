package com.dotk.platform.infra.mapper;


import java.util.List;
import com.dotk.platform.domain.entity.Account;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2022-09-08
 */
public interface AccountMapper
{
  /**
   * 查询【请填写功能名称】
   *
   * @param id 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  public Account selectAccountById(Integer id);

  /**
   * 查询【请填写功能名称】列表
   *
   * @param account 【请填写功能名称】
   * @return 【请填写功能名称】集合
   */
  public List<Account> selectAccountList(Account account);

  /**
   * 新增【请填写功能名称】
   *
   * @param account 【请填写功能名称】
   * @return 结果
   */
  public int insertAccount(Account account);

  /**
   * 修改【请填写功能名称】
   *
   * @param account 【请填写功能名称】
   * @return 结果
   */
  public int updateAccount(Account account);

  /**
   * 删除【请填写功能名称】
   *
   * @param id 【请填写功能名称】主键
   * @return 结果
   */
  public int deleteAccountById(Integer id);

  /**
   * 批量删除【请填写功能名称】
   *
   * @param ids 需要删除的数据主键集合
   * @return 结果
   */
  public int deleteAccountByIds(Integer[] ids);
}

