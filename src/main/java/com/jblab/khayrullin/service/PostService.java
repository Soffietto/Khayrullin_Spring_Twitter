package com.jblab.khayrullin.service;

import com.jblab.khayrullin.model.Comment;
import com.jblab.khayrullin.model.Post;
import com.jblab.khayrullin.model.User;

import java.util.List;

public interface PostService {

    void add(Post post);

    List<Post> findAllByReciever(User user);

    Post findOne(Long id);
}
