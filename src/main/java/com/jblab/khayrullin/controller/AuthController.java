package com.jblab.khayrullin.controller;

import com.jblab.khayrullin.model.User;
import com.jblab.khayrullin.model.enums.Sex;
import com.jblab.khayrullin.service.UserService;
import com.jblab.khayrullin.util.forms.SignInForm;
import com.jblab.khayrullin.util.forms.SignUpForm;
import com.jblab.khayrullin.util.transformers.SignUpFormToUserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.function.Function;

@Controller
public class AuthController {

    private final UserService userService;
    private final Function<SignUpForm, User> transformer;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
        transformer = new SignUpFormToUserTransformer();
    }

    @RequestMapping("/sign_in")
    public String getSignIn(@RequestParam(value = "error", required = false) Boolean error,
                            Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        model.addAttribute("signInForm", new SignInForm());
        return "sign_in";
    }

    @RequestMapping("/sign_up")
    public String getSignUp(Model model) {
        model.addAttribute("user", new SignUpForm());
        model.addAttribute("sex", Sex.values());
        return "sign_up";
    }

    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public String signUp(@ModelAttribute("user") @Valid SignUpForm signUpForm,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("sex", Sex.values());
            return "sign_up";
        }
        User user = transformer.apply(signUpForm);
        if (!userService.getAll().contains(user))
            userService.add(user);
        return "redirect:/home";
    }

}
