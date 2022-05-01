package com.monkdevs.employeeapi.Services.ServiceImplementation;

import java.util.List;

import com.monkdevs.employeeapi.Models.Employee;
import com.monkdevs.employeeapi.Repositories.EmployeeReporitory;
import com.monkdevs.employeeapi.Services.EmployeeService;
import com.monkdevs.employeeapi.Utils.GenerateEmployeNumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeReporitory employeeReporitory;



    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeReporitory.getById(id);
        employeeReporitory.delete(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeReporitory.findAll();
    }

    @Override
    public Employee getEmployeeByEmployeeNumber(String empNumber) {
        List<Employee> employees = employeeReporitory.findAll();
        Employee employee = null;

        for(Employee emp : employees){
            if(empNumber == emp.getEmpNumber()){
                employee = emp;
                return employee;
            }
        }
        return employee;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeReporitory.getEmployeeById(id);
    }

    @Override
    public Employee postEmployee(Employee employee) {
        employee.setEmpNumber(GenerateEmployeNumber.getRandomNumberString());
        employee.setIsActive(true);
        employee.setIsDeleted(false);
        return employeeReporitory.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeReporitory.getById(id);

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setMiddleName(employee.getMiddleName());
        existingEmployee.setEmailId(employee.getEmailId());
        existingEmployee.setContactNumber(employee.getContactNumber());
        existingEmployee.setLinkedInUrl(employee.getLinkedInUrl());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setManager(employee.getManager());
        existingEmployee.setDateOfBirth(employee.getDateOfBirth());
        existingEmployee.setMaritalStatus(employee.getMaritalStatus());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setBloodGroup(employee.getBloodGroup());
        
        return employeeReporitory.save(existingEmployee);
    }
    
}
