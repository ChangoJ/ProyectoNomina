package com.jordan.chango.Api.resources;

import com.jordan.chango.Api.entities.Employee;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeResourceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private RestService restService;
    private Employee employee;

    @Before
    public void before() {
        employee = new Employee();
        this.employee.setName("Jordan");
        this.employee.setSurname("Chango");
        this.employee.setCi("1726850884");
        this.employee.setPosition("Director");
        this.employee.setEmail("jordanch@gmail.com");
    }

    @Test
    public void getAllEmployee() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(EmployeeResource.EMPLOYEE).get().build();
        System.out.println(json);
    }

    @Test
    public void getByCi() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(EmployeeResource.EMPLOYEE).path(EmployeeResource.CI).expand("1726850884").get().build();
        System.out.println(json);
    }



    @Test
    public void createEmployee() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(EmployeeResource.EMPLOYEE).body(this.employee).post().build();
        System.out.println(json);

    }

    @Test
    public void editEmployee() {
        this.employee.setName("Pablo");
        this.employee.setSurname("Cruz");
        this.employee.setCi("1726850811");
        this.employee.setPosition("Secretario");
        this.employee.setEmail("pablo@gmail.com");
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(EmployeeResource.EMPLOYEE).path(EmployeeResource.CI)
                .expand("1726850818").body(employee).put().build();
        System.out.println(json);
    }

    @Test
    public void deleteEmployee() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(EmployeeResource.EMPLOYEE).path(EmployeeResource.ID).expand(6).delete().build();
        System.out.println(json);
    }
}