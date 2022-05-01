package com.monkdevs.employeeapi.Repositories;

import com.monkdevs.employeeapi.Models.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeReporitory extends JpaRepository<Employee, Long>{
    
    public Employee getEmployeeById(Long id);
}
