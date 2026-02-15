package com.meena.ems.service;

import com.meena.ems.model.Employee;
import com.meena.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    // Save Employee
    public Employee save(Employee e) {
        return repo.save(e);
    }

    // Get all employees
    public List<Employee> getAll() {
        return repo.findAll();
    }

    // Update employee
    public Employee update(Long id, Employee e) {
        Employee emp = repo.findById(id).orElseThrow();
        emp.setFirstName(e.getFirstName());
        emp.setLastName(e.getLastName());
        emp.setEmail(e.getEmail());
        emp.setDepartment(e.getDepartment());
        return repo.save(emp);
    }
    // Delete employee
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
