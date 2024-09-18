package com.econsole.ecommerce_project.controller;

import com.econsole.ecommerce_project.model.Users;
import com.econsole.ecommerce_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users users) {
         return userService.register(users);
    }

}
