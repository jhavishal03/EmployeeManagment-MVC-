package com.example.employeemanagement.Service;

import com.example.employeemanagement.Model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    void saveEmployee(Employee employee);
    void deleteEmployeeById(Long id);
    Employee getEmployeeById(Long id);
}
