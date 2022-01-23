package com.serviceUser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviceUser.entity.User;
import com.serviceUser.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Insert a new user")
    @PostMapping("/")
    public User post(@RequestBody User user) {
        log.info("Post: {}", user);
        return userService.save(user);
    }

    @Operation(summary = "Find a user by id")
    @GetMapping("/{id}")
    public User get(@Parameter(description = "User id") @PathVariable Integer id) {
        log.info("Get: {}", id);
        return userService.get(id);
    }

    @Operation(summary = "Find all users")
    @GetMapping("")
    public List<User> get() {
        log.info("Get");
        return userService.findAll();
    }

}
