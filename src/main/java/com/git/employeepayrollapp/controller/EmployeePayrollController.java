package com.git.employeepayrollapp.controller;

import com.git.employeepayrollapp.dto.EmployeePayrollDTO;
import com.git.employeepayrollapp.dto.ResponseDTO;
import com.git.employeepayrollapp.entity.EmployeePayrollData;
import com.git.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("employeepayrollservice")
public class EmployeePayrollController {
    @Autowired
    IEmployeePayrollService employeePayrollService;

    //Curl - http://localhost:8080/employeepayrollservice/create
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Successfully added ", employeePayrollService.addEmployeePayrollData(employeePayrollDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    //Curl - http://localhost:8080/employeepayrollservice/get/1
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable Long empId) {
        ResponseDTO responseDTO = new ResponseDTO("Based on employee id " + empId + " found data  ", employeePayrollService.getEmployeePayrollDataById(empId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //Curl - http://localhost:8080/employeepayrollservice/getAll
    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAllEmployeePayrollData() throws Exception {
        ResponseDTO responseDTO = new ResponseDTO("All employee payroll data ", employeePayrollService.getAllEmployeePayrollData());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //Curl - http://localhost:8080/employeepayrollservice/delete/1
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollDataById(@PathVariable Long empId) {
        ResponseDTO responseDTO = new ResponseDTO("Based on Employee id " + empId + " delete status ", employeePayrollService.deleteEmployeePayrollDataById(empId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //Curl - http://localhost:8080/employeepayrollservice/update/1
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollDataById(@PathVariable Long empId, @RequestBody EmployeePayrollData employeePayrollData) {
        ResponseDTO responseDTO = new ResponseDTO("Based on Employee id " + empId + " Data ", employeePayrollService.updateEmployeePayrollDataById(empId, employeePayrollData));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
