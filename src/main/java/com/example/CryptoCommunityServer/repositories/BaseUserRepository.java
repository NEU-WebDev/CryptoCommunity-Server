package com.example.CryptoCommunityServer.repositories;

import com.example.CryptoCommunityServer.models.BaseUserJoined;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BaseUserRepository extends CrudRepository<BaseUserJoined, Long> {
  @Query(value="SELECT * AS clazz_ FROM joined_base_user WHERE username=:username AND password=:password", nativeQuery = true)
  public BaseUserJoined findUser(@Param("username") String name, @Param("password") String pass);
}
