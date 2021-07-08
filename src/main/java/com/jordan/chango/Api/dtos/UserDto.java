package com.jordan.chango.Api.dtos;

import com.jordan.chango.Api.entities.UserPayroll;

public class UserDto {
    private int id;
    private String password,email;

    public UserDto( String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserDto(UserPayroll userPayroll){
        this.id= userPayroll.getId();
        this.email= userPayroll.getEmail();
        this.password = userPayroll.getPassword();
    }


    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
