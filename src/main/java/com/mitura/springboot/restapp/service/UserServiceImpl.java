package com.mitura.springboot.restapp.service;

import com.mitura.springboot.restapp.dao.UserDAO;
import com.mitura.springboot.restapp.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }


    @Override
    @Transactional
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    @Transactional
    public User findByLogin(String login) {
        return userDAO.findByLogin(login);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void deleteByLogin(String login) {
        userDAO.deleteByLogin(login);
    }
}
