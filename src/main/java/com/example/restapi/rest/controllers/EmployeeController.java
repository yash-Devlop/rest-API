package com.example.restapi.rest.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.rest.dto.EmployeesDTO;
import com.example.restapi.rest.services.EmployeeService;


@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    
    private final EmployeeService EmployeeService;

    public EmployeeController(EmployeeService EmployeeService) {
        this.EmployeeService = EmployeeService;
    }

    @GetMapping
    public List<EmployeesDTO> getAllEmployees() {
        return EmployeeService.getAllEmployees();
    }

    @GetMapping(path = "/{id}")
    public EmployeesDTO getEmployeeById(@PathVariable("id") Long employeeId) {
        return EmployeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeesDTO getData(@RequestBody EmployeesDTO employeesDTO){
        return EmployeeService.createNewEmployee(employeesDTO);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployeeById(@PathVariable Long id) {
        return EmployeeService.deleteEmployeeById(id);
    }
}
