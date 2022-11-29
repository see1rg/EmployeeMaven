package org.example.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class Employee {
    private String firstName;
    private String lastName;
    private int department;
    private double salary;
    private static int count;
    private final int id;

    public Employee(String firstName, String lastName, int department, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        this.department = department;
        this.salary = salary;
        id = count++;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (StringUtils.isAlpha(firstName)) {
            this.firstName = StringUtils.capitalize(firstName);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (StringUtils.isAlpha(lastName)) {
            this.lastName = StringUtils.capitalize(lastName);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }


    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public String getFio() {
        return  getFirstName() + " " + getLastName() + ". ";
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
}



