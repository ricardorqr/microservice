package com.serviceUser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.serviceDepartment.entity.Department;
import com.serviceUser.dtos.UserResponse;
import com.serviceUser.entity.User;
import com.serviceUser.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User save(User user) {
        log.info("Save: {}", user);
        return userRepository.save(user);
    }

    public UserResponse get(Integer id) {
        log.info("Get: {}", id);

        User user = userRepository.findById(id).orElse(null);

        Department department = restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(), Department.class);

        UserResponse userResponse = new UserResponse();
        userResponse.setUser(user);
        userResponse.setDepartment(department);
        return userResponse;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
