package com.jblab.khayrullin.util.forms;

import com.jblab.khayrullin.model.enums.Sex;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class SignUpForm {

    private static final String BLANK_MESSAGE = "This field is mandatory!";

    @NotBlank(message = BLANK_MESSAGE)
    private String firstName;

    @NotBlank(message = BLANK_MESSAGE)
    private String lastName;

    @NotBlank(message = BLANK_MESSAGE)
    @Email
    private String email;

    private String password;

    private Sex sex;

    public static String getBlankMessage() {
        return BLANK_MESSAGE;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
