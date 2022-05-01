package com.monkdevs.employeeapi.Controller;

import java.util.List;

import com.monkdevs.employeeapi.Models.Employee;
import com.monkdevs.employeeapi.Response.ResponseMessage;
import com.monkdevs.employeeapi.Services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllEmployee(){
        try{
            List<Employee> employees = employeeService.getAllEmployees();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new ResponseMessage("No employees found."), HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<?> postEmployee(@RequestBody Employee employee){
        try{
            Employee newEmployee = employeeService.postEmployee(employee);
            return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        try{
            Employee currentEmployee = employeeService.getEmployeeById(id);

            if(currentEmployee != null){
                employeeService.updateEmployee(id, employee);
                return new ResponseEntity<>(new ResponseMessage("Employee has been updated"), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(new ResponseMessage("Employee not found with " + id), HttpStatus.BAD_REQUEST);
            }
        }catch(Exception e){
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    
}
