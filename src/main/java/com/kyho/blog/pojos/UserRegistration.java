package com.kyho.blog.pojos;

import com.kyho.blog.entities.Role;

import javax.persistence.*;
import java.util.Set;

public class UserRegistration {

    private String name;
    private String lastName;
    private String email;

    private String password;
    private String passwordConfirmation;

    public UserRegistration(String name, String lastName, String email, String password, String passwordConfirmation) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
}
