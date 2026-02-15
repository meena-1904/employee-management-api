package com.meena.ems.controller;

import com.meena.ems.model.Employee;
import com.meena.ems.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // ✅ CREATE employee
    @PostMapping
    public Employee create(@Valid @RequestBody Employee employee) {
        return service.save(employee);
    }

    // ✅ GET all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAll();
    }

    // ✅ UPDATE employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @Valid @RequestBody Employee employee) {
        return service.update(id, employee);
    }

    // ✅ DELETE employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.delete(id);
        return "Employee deleted successfully";
    }
}
