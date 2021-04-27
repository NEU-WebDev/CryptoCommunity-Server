package com.example.CryptoCommunityServer.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

@Entity
@Table(name="joined_base_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseUserJoined {
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
@GenericGenerator(name = "UseExistingIdOtherwiseGenerateUsingIdentity", strategy = "com.example.CryptoCommunityServer.models.UseExistingIdOtherwiseGenerateUsingIdentity")
@GeneratedValue(generator = "UseExistingIdOtherwiseGenerateUsingIdentity")
  protected Long id;
  protected String username;
  protected String password;
//  @OneToMany
//  private List<Post> posts;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

//  public List<Post> getPosts() {
//    return posts;
//  }
//
//  public void setPosts(List<Post> posts) {
//    this.posts = posts;
//  }

}

