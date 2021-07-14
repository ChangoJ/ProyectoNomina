package com.jordan.chango.Api.resources;

import com.jordan.chango.Api.controllers.EmployeeController;
import com.jordan.chango.Api.controllers.SalaryRuleController;
import com.jordan.chango.Api.entities.Employee;
import com.jordan.chango.Api.entities.SalaryRule;
import com.jordan.chango.Api.resources.exceptions.EditEmployeeException;
import com.jordan.chango.Api.resources.exceptions.EmployeeCreateException;
import com.jordan.chango.Api.resources.exceptions.SalaryRuleCreateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(SalaryRuleResource.SALARYRULE)
public class SalaryRuleResource {
    public static final String SALARYRULE = "/salaryRule";
    public static final String ID = "/{id}";


    private SalaryRuleController salaryRuleController;

    @Autowired
    public SalaryRuleResource(SalaryRuleController salaryRuleController) {
        this.salaryRuleController = salaryRuleController;
    }


    @GetMapping
    public List<SalaryRule> getAllSalaryRule() {
        return this.salaryRuleController.findAllSalaryRule();
    }


    @GetMapping(value = ID)
    public ResponseEntity getSalaryRuleById(@PathVariable String id) {
        Optional<SalaryRule> salaryRuleOptional = this.salaryRuleController.findSalaryRuleById(id);
        if (salaryRuleOptional.isPresent()) {
            return new ResponseEntity(salaryRuleOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("\"lA REGLA SALARIAL no  existe\"", HttpStatus.NOT_FOUND);
        }

    }



    @PostMapping
    public ResponseEntity createSalaryRule(@RequestBody SalaryRule salaryRule) throws SalaryRuleCreateException {
        try {
            this.salaryRuleController.createSalaryRule(salaryRule);
            return new ResponseEntity("\"La regla salarial fue creado\"", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new SalaryRuleCreateException("los datos enviados no son los correctos");
        }

    }

    @PutMapping(value = ID)
    public ResponseEntity editSalaryRule(@RequestBody SalaryRule salaryRule, @PathVariable int id) throws EditEmployeeException {
        try {
            if (this.salaryRuleController.editSalaryRuleById(id, salaryRule))
                return new ResponseEntity("\"La regla salarial fue edito\"", HttpStatus.ACCEPTED);
            return new ResponseEntity("\"La regla salarial no  existe\"", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new EditEmployeeException("los datos enviados no son los correctos");
        }
    }

    @DeleteMapping(value = ID)
    public  ResponseEntity deleteSalaryRule(@PathVariable int id)
    {
        if (this.salaryRuleController.deleteSalaryRuleById(id))
            return new ResponseEntity("\"La regla salarial fue eliminado\"", HttpStatus.ACCEPTED);
        return new ResponseEntity("\"La regla salarial no  existe\"", HttpStatus.NOT_FOUND);


    }

}
