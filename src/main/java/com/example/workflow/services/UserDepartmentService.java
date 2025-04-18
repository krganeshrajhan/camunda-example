package com.example.workflow.services;

import org.springframework.stereotype.Component;

@Component
public class UserDepartmentService {

    public String getUserDepartment() {
        System.out.println("Coming from getUserDepartment method of UserDepartment Service");
        return "Accounts";
    }

}