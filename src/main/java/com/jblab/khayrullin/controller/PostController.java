package com.jblab.khayrullin.controller;

import com.jblab.khayrullin.model.Post;
import com.jblab.khayrullin.model.User;
import com.jblab.khayrullin.service.PostService;
import com.jblab.khayrullin.service.UserService;
import com.jblab.khayrullin.util.forms.PostForm;
import com.jblab.khayrullin.util.transformers.PostFormToPostTransformer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.function.Function;

@Controller
public class PostController {

    private final UserService userService;
    private final PostService postService;
    private final Function<PostForm, Post> postTransformer;

    public PostController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
        this.postTransformer = new PostFormToPostTransformer();
    }

    @RequestMapping(value = "/new_post/{id}", method = RequestMethod.POST)
    public String getNewPost(@PathVariable(value = "id") Long id, @ModelAttribute("post") @Valid PostForm postForm) {
        Post post = postTransformer.apply(postForm);
        post.setReciever(userService.findOneById(id));
        postService.add(post);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getId().equals(id)) {
            return "redirect:/home";
        }
        return "redirect:/users/{id}";
    }
}
