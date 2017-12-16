package com.jblab.khayrullin.controller;

import com.jblab.khayrullin.model.Comment;
import com.jblab.khayrullin.model.Post;
import com.jblab.khayrullin.model.User;
import com.jblab.khayrullin.service.CommentService;
import com.jblab.khayrullin.service.PostService;
import com.jblab.khayrullin.service.UserService;
import com.jblab.khayrullin.util.forms.CommentForm;
import com.jblab.khayrullin.util.transformers.CommentFormToCommentTransformer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Function;

@Controller
public class CommentController {

    private final UserService userService;
    private final PostService postService;
    private final CommentService commentService;
    private final Function<CommentForm, Comment> commentTransformer;

    public CommentController(UserService userService, PostService postService, CommentService commentService) {
        this.userService = userService;
        this.postService = postService;
        this.commentService = commentService;
        this.commentTransformer = new CommentFormToCommentTransformer();
    }

    @RequestMapping(value = "/comments/{post_id}")
    public String getComments(@PathVariable(value = "post_id") Long postId, Model model) {
        List<Comment> comments = commentService.getAllByPostId(postId);
        Post post = postService.findOne(postId);
        User user = post.getReciever();
        model.addAttribute("post_id", postId);
        model.addAttribute("comment", new CommentForm());
        model.addAttribute("comments", comments);
        model.addAttribute("user_id", user.getId());
        return "comments";
    }

    @RequestMapping(value = "/new_comment/{post_id}", method = RequestMethod.POST)
    public String getNewComments(@PathVariable(value = "post_id") Long postId, @ModelAttribute(value = "comment") @Valid CommentForm commentForm) {
        Comment comment = commentTransformer.apply(commentForm);
        Post post = postService.findOne(postId);
        comment.setPost(post);
        commentService.add(comment);
        return "redirect:/comments/{post_id}";
    }
}
