package org.example.services;

import org.example.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Double getSalarySum(int id) {
        return employeeService.getAllEmployees().stream().filter(x -> x.getDepartment() == id ).
                mapToDouble(Employee::getSalary).sum();
    }

    public Double getMinSalary(int id) {
        return employeeService.getAllEmployees().stream().filter(x -> x.getDepartment() == id ).
                mapToDouble(Employee::getSalary).min().orElse(0);
    }

    public Double getMaxSalary(int id) {
        return employeeService.getAllEmployees().stream().filter(x -> x.getDepartment() == id ).
                mapToDouble(Employee::getSalary).max().orElse(0);
    }

    public Map<Integer, List<Employee>> getEmployeesByDepartment() {
        return employeeService.findEmployeesById();
    }

    public List<Employee> getAllEmployeesByDepartment(int id) {
        return employeeService.getAllEmployees().stream().
                filter(x -> x.getDepartment() == id ).collect(Collectors.toList());
    }

}
