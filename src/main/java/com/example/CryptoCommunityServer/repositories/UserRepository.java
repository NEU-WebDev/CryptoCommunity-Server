package com.example.CryptoCommunityServer.repositories;

import com.example.CryptoCommunityServer.models.BaseUserJoined;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<BaseUserJoined, Long> {
  @Query(value="SELECT * FROM joined_base_user WHERE username=:username AND password=:password", nativeQuery = true)
  public BaseUserJoined findUser(@Param("username") String username, @Param("password") String password);
}
