package com.mitura.springboot.restapp.service;

import com.mitura.springboot.restapp.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findByLogin(String login);

    public void save(User user);
    public void deleteByLogin(String login);
}
