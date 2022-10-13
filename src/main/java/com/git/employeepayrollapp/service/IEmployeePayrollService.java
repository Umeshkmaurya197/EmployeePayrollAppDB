package com.git.employeepayrollapp.service;

import com.git.employeepayrollapp.dto.EmployeePayrollDTO;
import com.git.employeepayrollapp.entity.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);
    public EmployeePayrollData getEmployeePayrollDataById(Long empId);
//    public List<EmployeePayrollData> getEmployeePayrollDataByName(String employeeName); // list not working
//
    public List<EmployeePayrollData> getEmployeePayrollDataByName(String employeeName);

    public List<EmployeePayrollData> getAllEmployeePayrollData();
    public String deleteEmployeePayrollDataById(Long empId);
    public String updateEmployeePayrollDataById(Long empId, EmployeePayrollDTO employeePayrollDTO);
}
