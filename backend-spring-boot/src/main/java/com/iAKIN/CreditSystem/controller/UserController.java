package com.iAKIN.CreditSystem.controller;

import com.iAKIN.CreditSystem.model.User;
import com.iAKIN.CreditSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signin")
    public String login(@Valid @RequestBody User user) {
        return userService.signin(user.getUsername(), user.getPassword());
    }

    @PostMapping("/signup")
    public String signup(@RequestBody @Valid User user) { return userService.signup(user); }
}