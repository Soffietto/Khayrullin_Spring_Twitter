package com.jblab.khayrullin.repository;

import com.jblab.khayrullin.model.Comment;
import com.jblab.khayrullin.model.Post;
import com.jblab.khayrullin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByReciever(User user);

    Post findOneByComments(Comment id);
}
