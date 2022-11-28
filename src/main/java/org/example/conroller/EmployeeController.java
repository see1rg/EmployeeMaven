package org.example.conroller;

import org.example.model.Employee;
import org.example.request.EmployeeRequest;
import org.example.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/")
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) throws IllegalAccessException {
        return employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("/salary/sum")
    public int getSalarySum() {
        return employeeService.getSalarySum();
    }

    @GetMapping("/salary/min")
    public Double getMinSalary() {
        return employeeService.getMinSalary();
    }

    @GetMapping("/salary/max")
    public Double getMaxSalary() {
        return employeeService.getMaxSalary();
    }


    @GetMapping("/high-salary")
    public List<Employee> getAllEmployeesWithAverageSalary() {
        return employeeService.getAllEmployeesWithAverageSalary();
    }

}

