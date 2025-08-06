package com.data.library.repository;

import com.data.library.model.entity.User;

import java.util.List;

public interface IUserRepository {
    void save(User user);
    User findByUsername(String username);
    List<User> findAll();
    User findByEmail(String email);
}
