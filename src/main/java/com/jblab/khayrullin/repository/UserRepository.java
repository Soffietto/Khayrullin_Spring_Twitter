package com.jblab.khayrullin.repository;

import com.jblab.khayrullin.model.Dialog;
import com.jblab.khayrullin.model.Post;
import com.jblab.khayrullin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByEmail(String email);

    User findOneByPosts(Post post);
}
