package com.example.CryptoCommunityServer.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="joined_admin_user")
public class AdminUserJoined extends BaseUserJoined {
  @Column(name = "posts_deleted")
  private int postsDeleted;

  public int getPostsDeleted() {
    return postsDeleted;
  }

  public void setPostsDeleted(int postsDeleted) {
    this.postsDeleted = postsDeleted;
  }

}
