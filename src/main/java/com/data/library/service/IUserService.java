package com.data.library.service;

import com.data.library.model.entity.User;

import java.util.List;

public interface IUserService {
    void register(User user);
    User login(String username, String password);
    List<User> getAllUsers();

    User findByUserName(String username);
    User findUserByEmail(String email);
}
