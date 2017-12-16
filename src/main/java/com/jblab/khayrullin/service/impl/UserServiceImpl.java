package com.jblab.khayrullin.service.impl;

import com.jblab.khayrullin.model.Post;
import com.jblab.khayrullin.model.User;
import com.jblab.khayrullin.repository.UserRepository;
import com.jblab.khayrullin.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public User findOneById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
