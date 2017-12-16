package com.jblab.khayrullin.service;


import com.jblab.khayrullin.model.Comment;

import java.util.List;

public interface CommentService {

    void add(Comment comment);

    List<Comment> getAllByPostId(Long id);

}
