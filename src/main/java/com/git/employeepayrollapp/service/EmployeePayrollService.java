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

    /*
    here addEmployeePayrollData method use to create new employee data
       first it will check that  all the values passed in dto are null or not
       if it's null then method throw
       Exception with msg: Please, provide all employee data values
       if DTO values not null then this method will persist data into the Data base.
    */
    @Override
    public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        try {
            if (employeePayrollDTO.getEmployeeName() == null || employeePayrollDTO.getSalary() == null) {
                throw new Exception("Please, provide all employee data values ");
            } else {
                EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
                employeePayrollRepository.save(employeePayrollData);
                return employeePayrollData;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
    here  getEmployeePayrollDataById method will get id from user,
          then it will search that id into the Data base ,
          if id is there then it will return the Data related to that id,
          But if id is not there then it will return
          Exception with msg :  ____   Employee id does not exist  ____
     */

    @Override
    public Optional<EmployeePayrollData> getEmployeePayrollDataById(Long empId) {
        try {
            Optional<EmployeePayrollData> employeePayrollData = employeePayrollRepository.findById(empId);
            if (employeePayrollData.isEmpty()) {
                throw new Exception("____   Employee id does not exist  ____ ");
            } else {
                return employeePayrollRepository.findById(empId);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*
    here getAllEmployeePayrollData method will check in to the Data base
       if all employee data is there then it will return all Employee Data as list
       but, if not find any data and list is empty then it will throw an
       Exception with msg : _____  Employee list is empty  _____
     */

    @Override
    public List<EmployeePayrollData> getAllEmployeePayrollData() {
        try {
            List<EmployeePayrollData> employeePayrollData = employeePayrollRepository.findAll();
            if (employeePayrollData.isEmpty()) {
                throw new Exception("_____  Employee list is empty  _____");
            } else {
                return employeePayrollRepository.findAll();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    /*
    here deleteEmployeePayrollDataById method take empId from user
        and then search for that id into the Data base
        if it found that id in to the Data base then it will delete that id's whole data and id also
        and return msg : "Data Successfully deleted on id " + empId + "."
        if not able to find that id then it will throw
        Exception with msg : _____  Employee id " + empId + " not found to delete  _____
     */

    @Override
    public String deleteEmployeePayrollDataById(Long empId) {
        try {
            Optional<EmployeePayrollData> employeePayrollData = employeePayrollRepository.findById(empId);
            if (employeePayrollData.isEmpty()) {
                throw new Exception("_____  Employee id " + empId + " not found to delete  _____");
            } else {
                employeePayrollRepository.deleteById(empId);
                return "Data Successfully deleted on id " + empId + ".";
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /*
    here updateEmployeePayrollDataById method will take empId and EmployeePayrollData from user then,
       it will search that id into the Data base
       if it found that id then it will update new data on that particular id
       then it will return msg : Successfully updated Employee id "+empId+" ."
       and not found that id then it will throw an
       Exception with msg :  _____  Employee id " + empId + " not found to update  _____
     */
    @Override
    public String updateEmployeePayrollDataById(Long empId, EmployeePayrollData employeePayrollData) {
        try {
            Optional<EmployeePayrollData> employeeData = employeePayrollRepository.findById(empId);
            if (employeeData.isEmpty()) {
                throw new Exception("_____  Employee id " + empId + " not found to update  _____");
            } else {
                employeePayrollData.setEmpId(empId);
                employeePayrollRepository.save(employeePayrollData);
                return " Successfully updated Employee id "+empId+" .";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
