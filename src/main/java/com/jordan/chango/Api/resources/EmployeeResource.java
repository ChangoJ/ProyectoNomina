package com.jordan.chango.Api.resources;

import com.jordan.chango.Api.controllers.EmployeeController;
import com.jordan.chango.Api.entities.Employee;
import com.jordan.chango.Api.resources.exceptions.EditEmployeeException;
import com.jordan.chango.Api.resources.exceptions.EmployeeCreateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(EmployeeResource.EMPLOYEE)
public class EmployeeResource {
    public static final String EMPLOYEE = "/employee";
    public static final String CI = "/{ci}";
    public static final String ID = "/{id}";


    private EmployeeController employeeController;

    @Autowired
    public EmployeeResource(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    @GetMapping
    public List<Employee> getAllEmployee(@RequestParam(required = false) String ci) {
        if (ci == null) return this.employeeController.findAllEmployee();
        return this.employeeController.findAllEmployee();

    }


    @GetMapping(value = CI)
    public ResponseEntity getEmployeeById(@PathVariable String ci) {
        Optional<Employee> productOptional = this.employeeController.findEmployeeByCi(ci);
        if (productOptional.isPresent()) {
            return new ResponseEntity(productOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("\"El empleado no  existe\"", HttpStatus.NOT_FOUND);
        }

    }



    @PostMapping
    public ResponseEntity createEmployee(@RequestBody Employee employee) throws EmployeeCreateException {
        try {
            this.employeeController.createEmployee(employee);
            return new ResponseEntity("\"El empleado fue creado\"", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new EmployeeCreateException("los datos enviados no son los correctos");
        }

    }

    @PutMapping(value = CI)
    public ResponseEntity editEmployee(@RequestBody Employee employee, @PathVariable String ci) throws EditEmployeeException {
        try {
            if (this.employeeController.editEmployeeByCi(ci, employee))
                return new ResponseEntity("\"El empleado fue edito\"", HttpStatus.ACCEPTED);
            return new ResponseEntity("\"El empleado no  existe\"", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new EditEmployeeException("los datos enviados no son los correctos");
        }
    }

    @DeleteMapping(value = ID)
    public  ResponseEntity deleteEmployee(@PathVariable int id)
        {
                if (this.employeeController.deleteEmployeeById(id))
                    return new ResponseEntity("\"El empleado fue eliminado\"", HttpStatus.ACCEPTED);
                return new ResponseEntity("\"El empleado no  existe\"", HttpStatus.NOT_FOUND);
    }
}
