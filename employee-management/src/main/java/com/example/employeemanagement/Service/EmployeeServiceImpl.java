package com.example.employeemanagement.Service;

import com.example.employeemanagement.Exception.UserNotFoundException;
import com.example.employeemanagement.Model.Employee;
import com.example.employeemanagement.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository repository;
    @Override
    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.repository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeOptional=repository.findById(id);
        Employee employee;
        if(employeeOptional.isPresent()){
            employee=employeeOptional.get();
             employee.setName(employeeOptional.get().getName());
            employee.setAge(employeeOptional.get().getAge());
            employee.setEmail(employeeOptional.get().getName());
        }
        else throw new UserNotFoundException("Not with Id ->"+id);

        return employee;

    }
    @Override
    public void deleteEmployeeById(Long id) {
      repository.deleteById(id);
    }




}
