package com.jordan.chango.Api.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name,surname,position;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String ci;



    public Employee(int id, String name, String surname, String ci, String position, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.ci = ci;
        this.position = position;
        this.email = email;
    }

    public Employee(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(position, employee.position) && Objects.equals(email, employee.email) && Objects.equals(ci, employee.ci);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, position, email, ci);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }
}
