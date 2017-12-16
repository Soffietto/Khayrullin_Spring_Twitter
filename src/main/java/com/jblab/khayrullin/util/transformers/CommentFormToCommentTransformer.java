package com.jblab.khayrullin.util.transformers;

import com.jblab.khayrullin.model.Comment;
import com.jblab.khayrullin.model.User;
import com.jblab.khayrullin.util.forms.CommentForm;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.function.Function;

public class CommentFormToCommentTransformer implements Function<CommentForm, Comment> {

    @Override
    public Comment apply(CommentForm commentForm) {
        Comment comment = new Comment();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        comment.setText(commentForm.getText());
        comment.setAuthor(user);
        return comment;
    }
}
