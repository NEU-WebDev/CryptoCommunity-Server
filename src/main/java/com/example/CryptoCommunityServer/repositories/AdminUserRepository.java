package com.example.CryptoCommunityServer.repositories;

import com.example.CryptoCommunityServer.models.AdminUserJoined;
import org.springframework.data.repository.CrudRepository;

public interface AdminUserRepository extends CrudRepository<AdminUserJoined, Long> {

}
