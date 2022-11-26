package org.example.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class Employee {
    private String name;
    private String middleName;
    private int department;
    private double salary;
    private static int count;
    private final int id;

    public Employee(String name, String middleName, int department, double salary) {
        setName(name);
        setMiddleName(middleName);
        this.department = department;
        this.salary = salary;
        id = count++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (StringUtils.isAlpha(name)) {
            this.name = StringUtils.capitalize(name);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        if (StringUtils.isAlpha(middleName)) {
            this.middleName = StringUtils.capitalize(middleName);
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
        return  getName() + " " + getMiddleName() + ". ";
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
}



