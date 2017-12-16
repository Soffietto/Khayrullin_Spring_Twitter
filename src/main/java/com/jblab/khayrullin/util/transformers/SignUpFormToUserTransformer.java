package com.jblab.khayrullin.util.transformers;

import com.jblab.khayrullin.model.User;
import com.jblab.khayrullin.util.forms.SignUpForm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.function.Function;

public class SignUpFormToUserTransformer implements Function<SignUpForm, User> {

    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public User apply(SignUpForm signUpForm) {
        User user = new User();
        user.setFirstName(signUpForm.getFirstName());
        user.setLastName(signUpForm.getLastName());
        user.setEmail(signUpForm.getEmail());
        user.setPassword(encoder.encode(signUpForm.getPassword()));
        user.setSex(signUpForm.getSex());
        return user;
    }
}
