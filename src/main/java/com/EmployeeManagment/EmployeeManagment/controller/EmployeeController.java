package com.EmployeeManagment.EmployeeManagment.controller;

import com.EmployeeManagment.EmployeeManagment.model.Employee;
import com.EmployeeManagment.EmployeeManagment.service.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(employee);
        }
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        Employee employeeIsSaved = employeeService.addEmployee(employee);
        if (employeeIsSaved == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeIsSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@Valid @PathVariable Long id, @RequestBody Employee employee) {
        Employee employeeToUpdate = employeeService.updateEmployee(employee, id);
        if (employeeToUpdate == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id) {
        boolean employeeHasDeleted = employeeService.deleteEmployee(id);
        if (!employeeHasDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}


