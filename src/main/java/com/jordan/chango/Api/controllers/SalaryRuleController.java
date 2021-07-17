package com.jordan.chango.Api.controllers;

import com.jordan.chango.Api.entities.Employee;
import com.jordan.chango.Api.entities.SalaryRule;
import com.jordan.chango.Api.repositories.EmployeeRepository;
import com.jordan.chango.Api.repositories.SalaryRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class SalaryRuleController {

    private SalaryRuleRepository salaryRuleRepository;

    @Autowired
    public SalaryRuleController(SalaryRuleRepository salaryRuleRepository) {
        this.salaryRuleRepository = salaryRuleRepository;
    }

    public List<SalaryRule> findAllSalaryRule() {
        return this.salaryRuleRepository.findAll();
    }

    public Optional<SalaryRule> findSalaryRuleById(String ci){
        return this.salaryRuleRepository.findSalaryRuleByEmployee_Ci(ci);
    }


    public void createSalaryRule(SalaryRule salaryRule){
        this.salaryRuleRepository.save(salaryRule);
    }

    public boolean editSalaryRuleById(String id, SalaryRule salaryRule){
        Optional<SalaryRule> salaryRuleOptional = this.salaryRuleRepository.findSalaryRuleByEmployee_Ci(id);
        if( !salaryRuleOptional.isPresent()) return false;
        SalaryRule salaryRuledb = salaryRuleOptional.get();
        salaryRuledb.setSalary(salaryRule.getSalary());
        salaryRuledb.setDecimoTercero(salaryRule.isDecimoTercero());
        salaryRuledb.setDecimoCuarto(salaryRule.isDecimoCuarto());
        salaryRuledb.setFondosDeReserva(salaryRule.isFondosDeReserva());
        salaryRuledb.setPaymentDate(salaryRule.getPaymentDate());
        salaryRuleRepository.save(salaryRuledb);
        return true;
    }

    public boolean deleteSalaryRuleById(int id) {
        Optional<SalaryRule> employeeOptional = this.salaryRuleRepository.findById(id);
        if (!employeeOptional.isPresent()) return false;
        salaryRuleRepository.deleteById(id);
        return true;
    }
}
