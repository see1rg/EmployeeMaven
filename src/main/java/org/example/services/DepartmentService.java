package org.example.services;

import org.example.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@SessionScope
public class DepartmentService {

    public static Double getSalarySum(int id) {
        return EmployeeService.getAllEmployees().stream().filter(x -> x.getDepartment() == id ).
                mapToDouble(Employee::getSalary).sum();
    }

    public Double getMinSalary(int id) {
        return EmployeeService.getAllEmployees().stream().filter(x -> x.getDepartment() == id ).
                mapToDouble(Employee::getSalary).min().orElse(0);
    }

    public Double getMaxSalary(int id) {
        return EmployeeService.getAllEmployees().stream().filter(x -> x.getDepartment() == id ).
                mapToDouble(Employee::getSalary).max().orElse(0);
    }

    public Map<Integer, List<Employee>> getEmployeesByDepartment() {
        return EmployeeService.findEmployeesById();
    }

    public List<Employee> getAllEmployeesByDepartment(int id) {
        return EmployeeService.getAllEmployees().stream().
                filter(x -> x.getDepartment() == id ).collect(Collectors.toSet());
    }

}
