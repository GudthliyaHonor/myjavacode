package com.dotk.oauth.infra.mapper;

import com.dotk.oauth.domain.entity.User;
import com.dotk.oauth.domain.vo.UserVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

  /**
   * Get user by ID.
   *
   * @param id User ID
   * @return User
   */
  public User selectUserById(Long id);

  /**
   * Get User list.
   *
   * @param user
   * @return
   */
  public List<User> selectUserList(User user);

  /**
   * Insert new user.
   *
   * @param user User entity
   * @return inserted ID
   */
  public int insertUser(User user);

  /**
   * Update the user.
   *
   * @param user User entity
   * @return
   */
  public int updateUser(User user);

  /**
   * Delete the user.
   *
   * @param id User ID
   * @return
   */
  public int deleteUserById(Long id);

  /**
   * Delete the users.
   *
   * @param ids The array of User ID
   * @return
   */
  public int deleteUserByIds(Long[] ids);

  /**
   * Get the user by username.
   *
   * @param username
   * @return User
   */
  public User selectUserByUsername(String username);

  /**
   * Get the user by username with account id.
   *
   * @param user
   * @return
   */
  public User selectUserByUsernameWithAid(UserVO user);
}
