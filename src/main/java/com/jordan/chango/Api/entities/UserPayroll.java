package com.jordan.chango.Api.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "userPayroll")
public class UserPayroll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String email, password;


    public UserPayroll(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public UserPayroll() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPayroll userPayroll = (UserPayroll) o;
        return id == userPayroll.id && Objects.equals(email, userPayroll.email) && Objects.equals(password, userPayroll.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
