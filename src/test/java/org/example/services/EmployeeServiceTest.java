package org.example.services;

import org.example.model.Employee;
import org.example.request.EmployeeRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeServiceTest {
    private EmployeeService employeeService;
    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeService();
         Stream.of(
                new EmployeeRequest("Сема", "Карпов", 1, 25400),
                new EmployeeRequest("Вера", "Ромова", 2, 65000),
                new EmployeeRequest("Зураб", "Ёлкин", 3, 35600)
        ).forEach(employeeRequest -> {
             try {
                 employeeService.addEmployee(employeeRequest);
             } catch (IllegalAccessException e) {
                 throw new RuntimeException(e);
             }
         });
    }
    @Test
    public void addEmployee() throws IllegalAccessException {
        EmployeeRequest request = new EmployeeRequest("Test", "Test", 1, 10000);
        Employee result = employeeService.addEmployee(request);
        assertEquals(request.getFirstName(), result.getFirstName());
        assertEquals(request.getLastName(), result.getLastName());
        assertEquals(request.getDepartment(), result.getDepartment());
        assertEquals(request.getSalary(), result.getSalary());
        assertTrue((employeeService.getAllEmployees()).contains(result));
    }

    @Test
    public void getSalarySum() {
     assertEquals(126000,employeeService.getSalarySum());
    }
    @Test
    public void getMinSalary() {
        assertEquals(25400,employeeService.getMinSalary());
    }
    @Test
    public void getMaxSalary() {
        assertEquals(65000,employeeService.getMaxSalary());
    }
    @Test
    public void getAllEmployeesWithAverageSalary() {
            double averageSalary = employeeService.getAllEmployees().stream().mapToDouble(Employee::getSalary).average().orElse(0);
            List<Employee> list = employeeService.getAllEmployees().stream().filter(e -> e.getSalary() > averageSalary).collect(Collectors.toList());
            assertEquals(employeeService.getAllEmployeesWithAverageSalary(), list);
        }

    }
