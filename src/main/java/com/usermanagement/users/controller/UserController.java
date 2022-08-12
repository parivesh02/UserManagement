package com.usermanagement.users.controller;

import com.usermanagement.users.entity.User;
import com.usermanagement.users.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long userId){
        log.info("Inside findUserById method of UserController");
        return userService.findUserById(userId);
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable("id") Long userId) {
        log.info("Inside deleteUserById method of UserController");
        userService.deleteUserById(userId);
    }

    @GetMapping("/")
    public List<User> getAllUser() {
        log.info("Inside findLicenseById method of LicenseController");
        return userService.getAll();
    }

    @PatchMapping("{id}")
    public User updateUserById(@PathVariable long id,@Validated @RequestBody User obj) {
        log.info("Inside updateUserById method of UserController");
        return userService.updateUserById(obj,id);
    }
}