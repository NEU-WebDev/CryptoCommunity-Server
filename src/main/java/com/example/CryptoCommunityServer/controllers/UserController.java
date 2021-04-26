package com.example.CryptoCommunityServer.controllers;

import com.example.CryptoCommunityServer.models.BaseUserJoined;
import com.example.CryptoCommunityServer.models.NormalUserJoined;
import com.example.CryptoCommunityServer.services.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/**", method={RequestMethod.OPTIONS})
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {

  @Autowired
  UserService service;
  List<BaseUserJoined> users = new ArrayList<BaseUserJoined>();

  @PostMapping("/api/users/register")
  public NormalUserJoined register(
      @RequestBody NormalUserJoined user,
      HttpSession session
  ) {
    session.setAttribute("currentUser", user);
    users.add(user);
    return service.createNormalUser(user);
  }

  @PostMapping("/api/users/login")
  public BaseUserJoined login(
      @RequestBody BaseUserJoined credentials,
      HttpSession session
  ) {
    BaseUserJoined user = service.findUser(credentials.getUsername(), credentials.getPassword());
    BaseUserJoined badUser = new BaseUserJoined();
    badUser.setUsername("BadLogin");
    if (user != null) {
      session.setAttribute("currentUser", user);
      return user;
    }
  return badUser;
  }

  @PostMapping("/api/users/profile")
  public BaseUserJoined profile(HttpSession session) {
    BaseUserJoined currentUser = (BaseUserJoined) session.getAttribute("currentUser");
    return currentUser;
  }

  @PostMapping("/api/users/{username}/updateUsername")
  public BaseUserJoined updateUserName(
    @PathVariable ("username") String uid,
    @RequestBody BaseUserJoined newUser
  ) {
    System.out.println("MADE IT HERE");
    service.updateUser(uid, newUser);
    return newUser;
  }

  @PostMapping("api/users/logout")
  public void logout(HttpSession session) {
    session.invalidate();
  }
}
