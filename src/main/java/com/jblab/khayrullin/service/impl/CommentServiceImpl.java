package com.jblab.khayrullin.service.impl;

import com.jblab.khayrullin.model.Comment;
import com.jblab.khayrullin.repository.CommentsRepository;
import com.jblab.khayrullin.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentsRepository commentsRepository;

    public CommentServiceImpl(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    public void add(Comment comment) {
        commentsRepository.save(comment);
    }

    @Override
    public List<Comment> getAllByPostId(Long id) {
        return commentsRepository.getAllByPostId(id);
    }
}
