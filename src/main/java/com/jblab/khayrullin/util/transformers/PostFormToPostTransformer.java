package com.jblab.khayrullin.util.transformers;

import com.jblab.khayrullin.model.Post;
import com.jblab.khayrullin.model.User;
import com.jblab.khayrullin.util.forms.PostForm;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.function.Function;

public class PostFormToPostTransformer implements Function<PostForm, Post> {

    @Override
    public Post apply(PostForm postForm) {
        Post post = new Post();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setText(postForm.getText());
        post.setAuthor(user);
        return post;
    }
}
