package com.EmployeeManagment.EmployeeManagment.service;

import com.EmployeeManagment.EmployeeManagment.model.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee, Long id);
    boolean deleteEmployee(Long id);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
}
