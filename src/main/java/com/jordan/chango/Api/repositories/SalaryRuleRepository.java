package com.jordan.chango.Api.repositories;

import com.jordan.chango.Api.entities.SalaryRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalaryRuleRepository extends JpaRepository<SalaryRule,Integer> {
    public Optional<SalaryRule> findSalaryRuleByEmployee_Ci(String id);
}
