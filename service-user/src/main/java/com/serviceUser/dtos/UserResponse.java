package com.serviceUser.dtos;

import com.serviceDepartment.entity.Department;
import com.serviceUser.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private User user;
    private Department department;

}
