package com.example.CryptoCommunityServer.repositories;

import com.example.CryptoCommunityServer.models.Post;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends CrudRepository<Post, Long> {

  @Query(value="SELECT * FROM posts WHERE postId=:postId", nativeQuery = true)
  public Post findPostById(@Param("postId") String postId);

  @Query(value="SELECT * FROM posts WHERE author=:uid", nativeQuery = true)
  public List<Post> findPostsByUserId(@Param("uid") String uid);

  @Query(value="DELETE FROM posts WHERE postId=:postId", nativeQuery = true)
  public Integer deletePostById(@Param("postId") String postId);

  @Query(value="SELECT * FROM wbdv_sp21_02_schema.posts ORDER BY id DESC LIMIT 10", nativeQuery = true)
  public List<Post> findRecentPost();

}
