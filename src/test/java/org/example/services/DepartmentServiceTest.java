package org.example.services;

import org.example.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentService departmentService;
    private List<Employee> actualEmployees;

    @BeforeEach
   public void setUp() {
        Employee employee1 = new Employee("Федор","Степанов", 2, 24500D);
        Employee employee2 = new Employee("Степан","Ершов",1, 33400D);
        Employee employee4 = new Employee("Иван","Лошкин",2 ,12900D);

        actualEmployees = new ArrayList<>(List.of(employee1,employee2,employee4));
        when(employeeService.getAllEmployees()).thenReturn(actualEmployees);
    }

    @Test
    void shouldReturnSalarySumOfDepartment() {
        int dept = 2;
       final Double actual = actualEmployees.stream().filter(x->x.getDepartment() == dept).
               mapToDouble(Employee::getSalary).sum();
       final Double expected = departmentService.getSalarySum(dept);
       assertEquals(actual,expected);
    }

    @Test
    void shouldReturnMinSalaryOfDepartment() {
        int dept = 1;
        final Double actual = actualEmployees.stream().filter(x->x.getDepartment() == dept).
                mapToDouble(Employee::getSalary).min().orElse(0);
        final Double expected = departmentService.getMinSalary(dept);
        assertEquals(actual,expected);
    }

    @Test
    void shouldReturnMaxSalaryOfDepartment() {
        int dept = 1;
        final Double actual = actualEmployees.stream().filter(x->x.getDepartment() == dept).
                mapToDouble(Employee::getSalary).max().orElse(0);
        final Double expected = departmentService.getMaxSalary(dept);
        assertEquals(actual,expected);
    }

    @Test
    void shouldReturnEmployeesByDepartment() {
        int dept = 1;
        final List<Employee> actual = actualEmployees.stream().
                filter(x -> x.getDepartment() == dept).collect(Collectors.toList());
        final List<Employee> expected = departmentService.getAllEmployeesByDepartment(dept);
        assertEquals(actual,expected);
    }

    @Test
    void shouldReturnAllEmployeesByDepartment() {
        final Map<Integer, List<Employee>> actual = actualEmployees.stream().
                map(Employee::getDepartment).toList().stream().
                collect(Collectors.toMap(dept -> dept,dept->actualEmployees.stream().
                        filter(x->x.getDepartment()==dept).collect(Collectors.toList())));

        final Map<Integer, List<Employee>> expected = departmentService.getEmployeesByDepartment();
        assertEquals(actual,expected);
    }
}