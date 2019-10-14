package com.mitura.springboot.restapp.rest;


import com.mitura.springboot.restapp.dao.UserDAO;
import com.mitura.springboot.restapp.entity.User;
import com.mitura.springboot.restapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private @Value("${custom.password}")
    String pass;
    private UserService userService;

    @Autowired
    public UserRestController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{userLogin}")
    public User findByLogin(@PathVariable String userLogin){
        User user = userService.findByLogin(userLogin);
        if (user == null){
            throw new RuntimeException("User login wasn't found: "+ userLogin);
        }
        return user;
    }

    @PostMapping("/users/{password}")
    public User addUser(@RequestBody User user,@PathVariable String password){
        if (password.equals(pass)) {
            user.setId(0);
            userService.save(user);
            return user;
        }
        throw new RuntimeException("unauthorised access");
    }

    @PutMapping("/users/{password}")
    public User updateUser(@RequestBody User user,@PathVariable String password){
        if (password.equals(pass)) {
            userService.save(user);
            return user;
        }
        throw new RuntimeException("unauthorised access");
    }

    @DeleteMapping("/users/{userLogin}/{password}")
    public String deleteUser(@PathVariable String userLogin,@PathVariable String password){
        User user = userService.findByLogin(userLogin);

        if (user==null){
            throw new RuntimeException("User with login: "+userLogin+" not found");
        }
        if (password.equals(pass)) {
            userService.deleteByLogin(userLogin);
            return "Deleted user - " + userLogin;
        }
        throw new RuntimeException("unauthorised access");
    }



}
