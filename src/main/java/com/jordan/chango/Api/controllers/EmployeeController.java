package com.jordan.chango.Api.controllers;

import com.jordan.chango.Api.entities.Employee;
import com.jordan.chango.Api.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAllEmployee() {
        return this.employeeRepository.findAll();
    }

    public Optional<Employee> findEmployeeByCi(String ci){
        return this.employeeRepository.findEmployeeByCi(ci);
    }

    public Optional<Employee> findEmployeeById(int id){
        return this.employeeRepository.findById(id);
    }

    public void createEmployee(Employee employee){
        this.employeeRepository.save(employee);
    }

    public boolean editEmployeeByCi(String ci, Employee employee){
        Optional<Employee> employeeOptional = this.findEmployeeByCi(ci);
        if( !employeeOptional.isPresent()) return false;
        Employee employeedb = employeeOptional.get();
        employeedb.setName(employee.getName());
        employeedb.setSurname(employee.getSurname());
        employeedb.setCi(employee.getCi());
        employeedb.setPosition(employee.getPosition());
        employeedb.setEmail(employee.getEmail());
        employeeRepository.save(employeedb);
        return true;
    }

    public boolean deleteEmployeeById(int id) {
        Optional<Employee> employeeOptional = this.findEmployeeById(id);
        if (!employeeOptional.isPresent()) return false;
        employeeRepository.deleteById(id);
        return true;
    }



}
