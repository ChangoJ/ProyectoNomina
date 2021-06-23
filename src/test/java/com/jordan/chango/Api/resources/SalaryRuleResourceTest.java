package com.jordan.chango.Api.resources;

import com.jordan.chango.Api.entities.Employee;
import com.jordan.chango.Api.entities.SalaryRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SalaryRuleResourceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private RestService restService;
    private SalaryRule salaryRule;

    @Before
    public void before() {
        salaryRule = new SalaryRule();
        this.salaryRule.setSalary(3000);
        this.salaryRule.setDecimoTercero(true);
        this.salaryRule.setDecimoCuarto(false);
        this.salaryRule.setFondosDeReserva(true);
    }


    @Test
    public void getAllSalaryRule() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(SalaryRuleResource.SALARYRULE).get().build();
        System.out.println(json);
    }

    @Test
    public void getSalaryRuleById() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(SalaryRuleResource.SALARYRULE).path(SalaryRuleResource.ID).expand(9).get().build();
        System.out.println(json);
    }

    @Test
    public void createSalaryRule() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(SalaryRuleResource.SALARYRULE).body(this.salaryRule).post().build();
        System.out.println(json);
    }

    @Test
    public void editSalaryRule() {
        this.salaryRule.setSalary(8000);
        this.salaryRule.setDecimoTercero(false);
        this.salaryRule.setDecimoCuarto(true);
        this.salaryRule.setFondosDeReserva(false);
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(SalaryRuleResource.SALARYRULE).path(SalaryRuleResource.ID)
                .expand(10).body(salaryRule).put().build();
        System.out.println(json);
    }

    @Test
    public void deleteSalaryRule() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(SalaryRuleResource.SALARYRULE).path(SalaryRuleResource.ID).expand(10).delete().build();
        System.out.println(json);
    }
}