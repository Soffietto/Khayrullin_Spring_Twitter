package com.jblab.khayrullin.service;

import com.jblab.khayrullin.model.Post;
import com.jblab.khayrullin.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    User findOneById(Long id);

    List<User> getAll();
}
