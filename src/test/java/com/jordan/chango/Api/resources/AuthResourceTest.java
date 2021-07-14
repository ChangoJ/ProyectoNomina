package com.jordan.chango.Api.resources;

import com.jordan.chango.Api.dtos.UserDto;
import com.jordan.chango.Api.entities.UserPayroll;
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
public class AuthResourceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private RestService restService;

    private UserDto userDto;
    private UserPayroll user;

    @Before
    public void Before(){
        userDto=new UserDto();
        user=new UserPayroll();
        userDto.setEmail("recursoshumanos@gmail.com");
        userDto.setPassword("12345");
        user.setEmail("recursoshumanos@gmail.com");
        user.setPassword("12345");
    }

    @Test
    public void createUser() {
        String json=
                restService.restBuilder(new RestBuilder<String>().clazz(String.class))
                        .path(AuthResource.AUTH)
                        .body(this.user).post().build();
        System.out.println(json);
    }

    @Test
    public void login() {
        String json=
                restService.restBuilder(new RestBuilder<String>().clazz(String.class))
                        .path(AuthResource.AUTH).path(AuthResource.LOGIN)
                        .body(this.userDto).post().build();
        System.out.println(json);
    }
}