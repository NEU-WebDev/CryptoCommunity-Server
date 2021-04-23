package com.example.CryptoCommunityServer.controllers;

import com.example.CryptoCommunityServer.models.Post;
import com.example.CryptoCommunityServer.services.PostService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class PostController {

  @Autowired
  PostService service;

  List<Post> posts = new ArrayList<Post>();

  @PostMapping("/api/posts")
  public Post createPost(
      @RequestBody Post post,
      HttpSession session
  ) {
    session.setAttribute("currentUser", post);
    posts.add(post);
    return service.createPost(post);
  }

  @GetMapping("/api/users/{userId}/posts")
  public List<Post> findPostByUserId(
      @PathVariable("userId") String uid
  ) {
    return service.findPostByUserId(uid);
  }

  @GetMapping("/api/getPost")
  public Post findPostById(
      @PathVariable("postId") String pid
  ) {
    return service.findPostById(pid);
  }

  @DeleteMapping("/api/post/delete")
  public Integer deletePost(
      @PathVariable("postId") String pid) {
    return service.deletePostById(pid);
  }
}
