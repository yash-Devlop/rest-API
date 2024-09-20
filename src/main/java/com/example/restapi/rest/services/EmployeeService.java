package com.example.restapi.rest.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.restapi.rest.dto.EmployeesDTO;
import com.example.restapi.rest.entities.EmployeeEntity;
import com.example.restapi.rest.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    
    public EmployeesDTO getEmployeeById(Long id){
        @SuppressWarnings("deprecation")
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
        return modelMapper.map(employeeEntity, EmployeesDTO.class);
    }

    public EmployeesDTO createNewEmployee(EmployeesDTO employeesDTO){
        EmployeeEntity employeeEntity = modelMapper.map(employeesDTO, EmployeeEntity.class);
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeesDTO.class);
    }

    public List<EmployeesDTO> getAllEmployees() {
        return (List<EmployeesDTO>) employeeRepository.
        findAll()
        .stream()
        .map(EmployeeEntity -> modelMapper.map(EmployeeEntity, EmployeesDTO.class))
        .collect(Collectors.toList());
    }

    public boolean deleteEmployeeById(Long id) {
        boolean isPresent = employeeRepository.existsById(id);
        if(!isPresent) return false;
        employeeRepository.deleteById(id);
        return true;
    }
}
