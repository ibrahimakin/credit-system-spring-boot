package com.iAKIN.CreditSystem.service;

import com.iAKIN.CreditSystem.model.User;

public interface UserService {
    String signin(String username, String password);
    String signup(User user);
}