package com.example.CryptoCommunityServer.services;

import com.example.CryptoCommunityServer.models.BaseUserJoined;
import com.example.CryptoCommunityServer.models.NormalUserJoined;
import com.example.CryptoCommunityServer.repositories.AdminUserRepository;
import com.example.CryptoCommunityServer.repositories.BaseUserRepository;
import com.example.CryptoCommunityServer.repositories.NormalUserRepository;
import com.example.CryptoCommunityServer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  BaseUserRepository baseRepo;
  @Autowired
  NormalUserRepository normalRepo;
  @Autowired
  AdminUserRepository adminRepo;


  public BaseUserJoined createBaseUser(BaseUserJoined user) {
    return baseRepo.save(user);
  }

  public NormalUserJoined createNormalUser(NormalUserJoined user) {
    return normalRepo.save(user);
  }

  public BaseUserJoined findUser(String username, String password) {
    return baseRepo.findUser(username, password);
  }

}
