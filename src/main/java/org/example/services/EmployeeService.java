package org.example.services;

import org.example.model.Employee;
import org.example.request.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();

    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) throws IllegalAccessException {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalAccessException("Введите имя и фамилию");
        }
        Employee employee = new Employee(employeeRequest.getLastName(),
                employeeRequest.getFirstName(),
                employeeRequest.getSureName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());

        this.employees.put(employee.getId(), employee);
        return employee;

    }

    public int getSalarySum() {
        return (int) employees.values().stream().
                mapToDouble(Employee::getSalary).sum();
    }

    public Double getMinSalary() {
        return employees.values().stream().mapToDouble(Employee::getSalary).min().orElse(0);
    }

    public Double getMaxSalary() {
        return employees.values().stream().mapToDouble(Employee::getSalary).max().orElse(0);
    }

    public List<Employee> getAllEmployeesWithAverageSalary() {
        var averageSalary = employees.values().stream()
                .mapToDouble(Employee::getSalary).average().orElseThrow();
        return employees.values().stream()
                .filter(employee -> averageSalary < employee.getSalary())
                .collect(Collectors.toList());
    }
}
