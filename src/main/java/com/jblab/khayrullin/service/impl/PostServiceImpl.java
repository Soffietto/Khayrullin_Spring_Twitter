package com.jblab.khayrullin.service.impl;

import com.jblab.khayrullin.model.Comment;
import com.jblab.khayrullin.model.Post;
import com.jblab.khayrullin.model.User;
import com.jblab.khayrullin.repository.PostRepository;
import com.jblab.khayrullin.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void add(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> findAllByReciever(User user) {
        return postRepository.findAllByReciever(user);
    }

    @Override
    public Post findOne(Long id) {
        return postRepository.findOne(id);
    }
}
