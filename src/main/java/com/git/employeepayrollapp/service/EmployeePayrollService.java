package com.git.employeepayrollapp.service;

import com.git.employeepayrollapp.dto.EmployeePayrollDTO;
import com.git.employeepayrollapp.entity.EmployeePayrollData;
import com.git.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    EmployeePayrollRepository employeePayrollRepository;

    @Override
    public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
        employeePayrollRepository.save(employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public Optional<EmployeePayrollData> getEmployeePayrollDataById(Long empId) {
        return employeePayrollRepository.findById(empId);
    }

    @Override
    public List<EmployeePayrollData> getAllEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    @Override
    public String deleteEmployeePayrollDataById(Long empId) {
        employeePayrollRepository.deleteById(empId);
        return "Data Successfully deleted on id " + empId + ".";

    }

    @Override
    public String updateEmployeePayrollDataById(Long empId, EmployeePayrollData employeePayrollData) {
        Optional<EmployeePayrollData> employeeData = employeePayrollRepository.findById(empId);
        if (employeeData.isEmpty()) {
            return "Data Not Found ";
        }
        employeePayrollData.setEmpId(empId);
        employeePayrollRepository.save(employeePayrollData);
        return " Successfully updated ";
    }

}

