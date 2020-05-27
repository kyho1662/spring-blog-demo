package com.kyho.blog.controllers;

import com.kyho.blog.entities.Role;
import com.kyho.blog.entities.User;
import com.kyho.blog.pojos.UserRegistration;
import com.kyho.blog.service.RoleService;
import com.kyho.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/register")
    public String register(@RequestBody UserRegistration userRegistration) {
        if(!userRegistration.getPassword().equals(userRegistration.getPasswordConfirmation())) {
            return "Passwords do not match";
        }
        else if(userService.getUser(userRegistration.getName()) != null) {
            return "User already exists";
        }

        // input user

        userService.save(new User(userRegistration.getName(), userRegistration.getLastName(),
                userRegistration.getEmail(), userRegistration.getPassword(), new HashSet<Role>(Arrays.asList(roleService.getRole("USER")))));

        return "User created";
    }

}
