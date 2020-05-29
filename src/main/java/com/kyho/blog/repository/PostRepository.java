package com.kyho.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kyho.blog.entities.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

    // findBy(Field) Post.creator.userId
    List<Post> findByCreatorUserId(int userId);
}
