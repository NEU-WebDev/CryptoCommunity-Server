package com.example.CryptoCommunityServer.repositories;

import com.example.CryptoCommunityServer.models.Comment;
import com.example.CryptoCommunityServer.models.Post;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends CrudRepository<Comment, Long> {

  @Query(value="SELECT * FROM comments WHERE associated_post=:postId", nativeQuery = true)
  public List<Comment> findCommentsByPost(@Param("postId") String postId);

  @Query(value="SELECT * FROM wbdv_sp21_02_schema.comments WHERE author=:uid", nativeQuery = true)
  public List<Comment> findCommentsByUser(@Param("uid") String uid);

  @Query(value="DELETE FROM comments WHERE id=:commentId", nativeQuery = true)
  public Integer deleteCommentById(@Param("commentId") String postId);




}
