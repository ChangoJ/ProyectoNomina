package com.jordan.chango.Api.repositories;

import com.jordan.chango.Api.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    public Optional<Employee> findEmployeeByCi(String ci);
    public Optional<Employee> deleteEmployeeByCi(String ci);
}
