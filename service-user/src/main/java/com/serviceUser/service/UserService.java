package com.serviceUser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceUser.entity.User;
import com.serviceUser.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        log.info("Save: {}", user);
        return userRepository.save(user);
    }

    public User get(Integer id) {
        log.info("Get: {}", id);
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
