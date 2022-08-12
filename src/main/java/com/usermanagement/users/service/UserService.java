package com.usermanagement.users.service;

import com.usermanagement.users.entity.User;
import com.example.UserLicense.entity.UserLicense;
import com.usermanagement.users.repository.UserLicenseRepository;
import com.usermanagement.users.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLicenseRepository userLicenseRepository;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public User findUserById(Long userId) {
        log.info("Inside findUser of UserService");
        return userRepository.findByUserId(userId);
    }

    public void deleteUserById(Long userId) {
        log.info("Inside deleteUserById of UserService");
        userRepository.deleteById(userId);
    }

    public User updateUserById(User obj,long id) {
        log.info("Inside updateUserById of UserService");
        User temp = userRepository.findById(id).get();
        temp.setFirstName(obj.getFirstName());
        return userRepository.save(temp);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void updateLicense(UserLicense message) {
        userLicenseRepository.save(message);
    }
}
