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
        if (employee == null) {
            return null;
        }
        if (!validateEmployee(employee)) {
            return null;
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee currentEmployee = getEmployeeById(id);
        if (currentEmployee == null) {
            return null;
        }
        if (!validateEmployee(employee)) {
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

    public boolean validateEmployee(Employee employee) {
        if (employee == null) {
            return false;
        }
        if (employee.getName() == null || employee.getName().isEmpty()) {
            return false;
        }
        if (employee.getSurname() == null || employee.getSurname().isEmpty()) {
            return false;
        }
        if (employee.getGender() == null || employee.getGender().isEmpty()) {
            return false;
        }
        if (employee.getPhoneNumber() == null) {
            return false;
        }
        if (employee.getEmail() == null || employee.getEmail().isEmpty()) {
            return false;
        }
        if (employee.getDepartment() == null || employee.getDepartment().isEmpty()) {
            return false;
        }
        if (employee.getEmployeeType() == null || employee.getEmployeeType().isEmpty()) {
            return false;
        }
        if (employee.getStatus() == null || employee.getStatus().isEmpty()) {
            return false;
        }
        return true;
    }
}
