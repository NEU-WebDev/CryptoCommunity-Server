package com.example.CryptoCommunityServer.repositories;

import com.example.CryptoCommunityServer.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}
