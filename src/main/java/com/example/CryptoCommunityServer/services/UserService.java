package com.example.CryptoCommunityServer.services;

import com.example.CryptoCommunityServer.models.BaseUserJoined;
import com.example.CryptoCommunityServer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserRepository repository;

  public BaseUserJoined createUser(BaseUserJoined user) {
    return repository.save(user);
  }

  public BaseUserJoined findUser(String username, String password) {
    return repository.findUserByCredentials(username, password);
  }

  public BaseUserJoined updateUser(String userId, BaseUserJoined newUser) {
    BaseUserJoined originalUser = repository.findUserByUserName(userId);
    System.out.println(userId);
    originalUser.setUsername(newUser.getUsername());
    System.out.println(originalUser.getUsername());
    repository.save(originalUser);
    return originalUser;
  }

}
