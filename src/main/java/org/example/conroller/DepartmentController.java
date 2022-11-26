package org.example.conroller;

import org.example.model.Employee;
import org.example.services.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/employees/{id}") //список сотрудников по деп
    public Collection<Employee> getAllEmployees(@PathVariable int id) {
        return departmentService.getAllEmployees(id);
    }

    @GetMapping(path = "/employees/{id}/salary/sum")
    public Double getSalarySum(@PathVariable int id) {
        return DepartmentService.getSalarySum(id);
    }

    @GetMapping(path = "/employees/{id}/salary/max")
    public Double getMaxSalary(@PathVariable int id) {
        return departmentService.getMaxSalary(id);
    }

    @GetMapping(path = "/employees/{id}/salary/min")
    public Double getMinSalary(@PathVariable int id) {
        return departmentService.getMinSalary(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployeesByDepartment() {
        return departmentService.getEmployeesByDepartment();
    }
}
