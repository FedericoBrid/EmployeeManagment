package com.EmployeeManagment.EmployeeManagment.service;

import com.EmployeeManagment.EmployeeManagment.model.Employee;
import com.EmployeeManagment.EmployeeManagment.repository.IEmployeeRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{

    private final IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @NotNull
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee currentEmployee = getEmployeeById(employee.getId());
        if (currentEmployee == null) {
            return null;
        }
        currentEmployee.setName(employee.getName());
        currentEmployee.setSurname(employee.getSurname());
        currentEmployee.setGender(employee.getGender());
        currentEmployee.setPhoneNumber(employee.getPhoneNumber());
        currentEmployee.setEmail(employee.getEmail());
        currentEmployee.setDepartment(employee.getDepartment());
        currentEmployee.setEmployeeType(employee.getEmployeeType());
        currentEmployee.setStatus(employee.getStatus());

        return employeeRepository.save(currentEmployee);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        Employee currentEmployee = getEmployeeById(id);
        if (currentEmployee == null) {
            return false;
        }
        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
