package com.example.CryptoCommunityServer.repositories;

import com.example.CryptoCommunityServer.models.BaseUserJoined;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<BaseUserJoined, Long> {
  @Query(value="SELECT * FROM joined_base_user WHERE username=:uname AND password=:password", nativeQuery = true)
  public BaseUserJoined findUser(@Param("uname") String username, @Param("password") String password);

  @Query("SELECT user FROM BaseUserJoined user WHERE user.username=:uname AND user.password=:pass")
  public BaseUserJoined findUserByCredentials(
      @Param("uname") String username,
      @Param("pass") String password);

  @Query("SELECT user FROM BaseUserJoined user WHERE user.username=:uname")
  public BaseUserJoined findUserByUserName(
      @Param("uname") String username);
}
