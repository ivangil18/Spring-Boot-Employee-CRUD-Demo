package com.igildev.springboot.thymeleafdemo.controller;


import com.igildev.springboot.thymeleafdemo.entity.Employee;
import com.igildev.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // wire employee Service
    private EmployeeService employeeService;


    // there is only one constructor - therefore @Autowired is optional
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // get employees from the database
        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }
}








