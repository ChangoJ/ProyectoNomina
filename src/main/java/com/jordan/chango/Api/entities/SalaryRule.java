package com.jordan.chango.Api.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class SalaryRule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double salary;

    private boolean decimoTercero,decimoCuarto,fondosDeReserva;

    private Date paymentDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Employee employee;

    public SalaryRule() {
        this.id = id;
        this.salary = salary;
        this.decimoTercero = decimoTercero;
        this.decimoCuarto = decimoCuarto;
        this.fondosDeReserva = fondosDeReserva;
        this.paymentDate = paymentDate;
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalaryRule that = (SalaryRule) o;
        return id == that.id && Double.compare(that.salary, salary) == 0 && decimoTercero == that.decimoTercero && decimoCuarto == that.decimoCuarto && fondosDeReserva == that.fondosDeReserva && Objects.equals(paymentDate, that.paymentDate) && Objects.equals(employee, that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salary, decimoTercero, decimoCuarto, fondosDeReserva, paymentDate, employee);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isDecimoTercero() {
        return decimoTercero;
    }

    public void setDecimoTercero(boolean decimoTercero) {
        this.decimoTercero = decimoTercero;
    }

    public boolean isDecimoCuarto() {
        return decimoCuarto;
    }

    public void setDecimoCuarto(boolean decimoCuarto) {
        this.decimoCuarto = decimoCuarto;
    }

    public boolean isFondosDeReserva() {
        return fondosDeReserva;
    }

    public void setFondosDeReserva(boolean fondosDeReserva) {
        this.fondosDeReserva = fondosDeReserva;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
