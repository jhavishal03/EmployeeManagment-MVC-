package com.example.employeemanagement.Controllers;

import com.example.employeemanagement.Model.Employee;
import com.example.employeemanagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
  private EmployeeService employeeService;
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees",employeeService.getAllEmployee());
   return "index";
    }
    @GetMapping("showFormOrupdate/{id}")
    public String getEmployeeById(@PathVariable Long id,Model model){
        Employee employee=employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "update_employee";
    }
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";
    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
     employeeService.saveEmployee(employee);
     return "redirect:/";
    }
    @GetMapping("/deleteById/{id}")
    public  String deleteEmpById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
}
