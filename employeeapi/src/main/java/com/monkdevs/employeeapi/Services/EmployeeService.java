package com.monkdevs.employeeapi.Services;

import java.util.List;

import com.monkdevs.employeeapi.Models.Employee;

public interface EmployeeService {

    public Employee postEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(Long id);

    public Employee updateEmployee(Long id, Employee employee);

    public Employee getEmployeeByEmployeeNumber(String empNumber);

    public void deleteEmployee(Long id);
    
}
