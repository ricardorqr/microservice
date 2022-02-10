package com.serviceRegisrtry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceFallBackController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBack() {
        return "User Service is talking longer. Please try again later.";
    }

}
