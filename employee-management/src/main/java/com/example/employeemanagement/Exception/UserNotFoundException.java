package com.example.employeemanagement.Exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String s) {
    super(s);
    }
}
