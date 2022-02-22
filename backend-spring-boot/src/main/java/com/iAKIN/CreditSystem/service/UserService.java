package com.iAKIN.CreditSystem.service;

import com.iAKIN.CreditSystem.model.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    String signin(String username, String password);
    String signup(User user);
    void delete(String username);
    Object whoami(HttpServletRequest req);
}