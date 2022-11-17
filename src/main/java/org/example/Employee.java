package org.example;

import org.apache.commons.lang3.StringUtils;

public class Employee {
    private String name;
    private String middleName;
    private String sureName;
    private String department;
    private double salary;
    private static int count;
    private int id;

    public Employee(String sureName, String name, String middleName, String department, double salary) {
        setName(name);
        setMiddleName(middleName);
        setSureName(sureName);
        this.department = department;
        this.salary = salary;
        id = count++;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", sureName='" + sureName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (StringUtils.isAlpha(name)) {
            this.name = StringUtils.capitalize(name);
        } else {
            throw new IllegalArgumentException("incorrect name");
        }
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        if (StringUtils.isAlpha(middleName)) {
            this.middleName = StringUtils.capitalize(middleName);
        } else {
            throw new IllegalArgumentException("incorrect middle name");
        }
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        if (StringUtils.isAlpha(sureName)) {
            this.sureName = StringUtils.capitalize(sureName);
        } else {
            throw new IllegalArgumentException("incorrect sure name");
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public String getFio() {
        return getSureName() + " " + getName() + " " + getMiddleName() + ". ";
    }
}

