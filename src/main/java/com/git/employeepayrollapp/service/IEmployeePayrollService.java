package com.git.employeepayrollapp.service;

import com.git.employeepayrollapp.dto.EmployeePayrollDTO;
import com.git.employeepayrollapp.entity.EmployeePayrollData;

import java.util.List;
import java.util.Optional;

public interface IEmployeePayrollService {
    public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);
    public Optional<EmployeePayrollData> getEmployeePayrollDataById(Long empId);
    public List<EmployeePayrollData> getAllEmployeePayrollData() throws Exception;
    public String deleteEmployeePayrollDataById(Long empId);
    public String updateEmployeePayrollDataById(Long empId, EmployeePayrollDTO employeePayrollDTO);
}
