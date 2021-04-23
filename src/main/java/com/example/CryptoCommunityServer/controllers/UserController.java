package com.example.CryptoCommunityServer.controllers;

import com.example.CryptoCommunityServer.models.BaseUserJoined;
import com.example.CryptoCommunityServer.repositories.UserRepository;
import com.example.CryptoCommunityServer.services.UserService;
import com.fasterxml.jackson.databind.ser.Serializers.Base;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {

  @Autowired
  UserRepository repository;

  List<BaseUserJoined> users = new ArrayList<BaseUserJoined>();

  @PostMapping("/api/users/register")
  public BaseUserJoined register(
      @RequestBody BaseUserJoined user,
      HttpSession session
  ) {
    session.setAttribute("currentUser", user);
    users.add(user);
    return repository.save(user);
  }

  @PostMapping("/api/users/login")
  public BaseUserJoined login(
      @RequestBody BaseUserJoined credentials,
      HttpSession session
  ) {
    BaseUserJoined user = repository.findUserByCredentials(credentials.getUsername(), credentials.getPassword());
    if (user != null) {
      session.setAttribute("currentUser", user);
      return user;
    }
    return null;
  }

  @PostMapping("/api/users/profile")
  public BaseUserJoined profile(HttpSession session) {
    BaseUserJoined currentUser = (BaseUserJoined) session.getAttribute("currentUser");
    return currentUser;
  }

  @PostMapping("api/users/logout")
  public void logout(HttpSession session) {
    session.invalidate();
  }

}
