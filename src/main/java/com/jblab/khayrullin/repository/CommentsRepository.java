package com.jblab.khayrullin.repository;

import com.jblab.khayrullin.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comment, Long> {

    List<Comment> getAllByPostId(Long id);
}
