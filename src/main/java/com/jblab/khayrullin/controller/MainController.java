package com.jblab.khayrullin.controller;

import com.jblab.khayrullin.model.Dialog;
import com.jblab.khayrullin.model.Post;
import com.jblab.khayrullin.model.User;
import com.jblab.khayrullin.service.DialogService;
import com.jblab.khayrullin.service.PostService;
import com.jblab.khayrullin.service.UserService;
import com.jblab.khayrullin.util.forms.PostForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    private final UserService userService;
    private final PostService postService;
    private final DialogService dialogService;

    @Autowired
    public MainController(UserService userService, PostService postService, DialogService dialogService) {
        this.userService = userService;
        this.postService = postService;
        this.dialogService = dialogService;
    }

    @RequestMapping("/home")
    public String getHome(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Post> posts = postService.findAllByReciever(user);
        model.addAttribute("id", user.getId());
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("sex", user.getSex());
        model.addAttribute("post", new PostForm());
        model.addAttribute("posts", posts);
        model.addAttribute("isLoggedIn", true);
        return "home";
    }

    @RequestMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("userList", users);
        return "all_users";
    }

    @RequestMapping(value = "users/{user_id}")
    public String getUserPage(@PathVariable(value = "user_id") Long id, Model model) {
        User user = userService.findOneById(id);
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Post> posts = postService.findAllByReciever(user);
        model.addAttribute("id", user.getId());
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("senderFirstName", currentUser.getFirstName());
        model.addAttribute("senderLastName", currentUser.getLastName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("sex", user.getSex());
        model.addAttribute("post", new PostForm());
        model.addAttribute("posts", posts);
        model.addAttribute("current_user_id", currentUser.getId());
        return "user_page";
    }
}