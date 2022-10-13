package com.git.employeepayrollapp.service;

import com.git.employeepayrollapp.dto.EmployeePayrollDTO;
import com.git.employeepayrollapp.email.EmailService;
import com.git.employeepayrollapp.entity.EmployeePayrollData;
import com.git.employeepayrollapp.exception.CustomException;
import com.git.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    @Autowired
    EmployeePayrollRepository employeePayrollRepository;

    @Autowired
    EmailService emailService;

    /*
    here addEmployeePayrollData method use to create new employee data
       first it will check that  all the values passed in dto are null or not
       if it's null then method throw
       Exception with msg: Please, provide all employee data values
       if DTO values not null then this method will persist data into the Data base.
    */
    @Override
    public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
//        if (employeePayrollDTO.name == null || employeePayrollDTO.department == null || employeePayrollDTO.salary == null || employeePayrollDTO.email == null) {          //remove if condition when form added
//            throw new CustomException(" Please, enter correct column names ");
//        } else {
            EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
            employeePayrollRepository.save(employeePayrollData);
 //         emailService.sendMail(employeePayrollDTO.getEmail(), "Account SignedUp Successfully ", "your account has been created on Employee Payroll Your Details are :\n\n EmployeeId : " + employeePayrollData.getEmpId() + "\n Employee Name : " + employeePayrollData.getEmployeeName() + "\n Employee Departments : " + employeePayrollData.getDepartments() + "\n Employee Salary : " + employeePayrollData.getSalary() + "\n Employee Email : " + employeePayrollData.getEmail() + " .\n\n\n Thanks&regards \n Umesh Maurya \n 7355438834 ");
        System.out.println(employeePayrollData.toString());
            return employeePayrollData;
     //   }
    }

    /*
    here  getEmployeePayrollDataById method will get id from user,
          then it will search that id into the Data base ,
          if id is there then it will return the Data related to that id,
          But if id is not there then it will return
          Exception with msg :  Employee id does not exist
     */

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(Long empId) {
        return employeePayrollRepository.findById(empId).orElseThrow(() -> new CustomException("  Employee id " + empId + " does not exist "));
    }

    /*
        below method will return data based on employeeName
        if there are more than one employee with same name it will return
        all of them.
        Or not found anything with that name then it will return
        CustomException with msg :Employee name not found in the list
    */

    /*@Override
    public List<EmployeePayrollData> getEmployeePayrollDataByName(String employeeName) {
        List<EmployeePayrollData> employeePayrollData = employeePayrollRepository.findEmployeeByName(employeeName);
        if (employeePayrollData.isEmpty()) {
            return employeePayrollData;
        } else {
            throw new CustomException("Employee name not found in list");
        }
    }*/
    @Override
    public List<EmployeePayrollData> getEmployeePayrollDataByName(String employeeName) {
        System.out.println("324254 :"+employeeName);
        List<EmployeePayrollData> employeePayrollData = employeePayrollRepository.findEmployeeByName(employeeName);
        if (employeePayrollData.isEmpty()) {
            throw new CustomException("not ffound");
        } else {
            return employeePayrollData;
        }
    }

    /*
    here getAllEmployeePayrollData method will check in to the Data base
       if all employee data is there then it will return all Employee Data as list
       but, if not find any data and list is empty then it will throw an
       Exception with msg : Employee list is empty
    */

    @Override
    public List<EmployeePayrollData> getAllEmployeePayrollData() {
        List<EmployeePayrollData> employeePayrollData = employeePayrollRepository.findAll();
        if (employeePayrollData.isEmpty()) {
            throw new CustomException(" Employee list is empty ");
        } else {
            return employeePayrollRepository.findAll();
        }
    }
    /*
    here deleteEmployeePayrollDataById method take empId from user
        and then search for that id into the Data base
        if it found that id in to the Data base then it will delete that id's whole data and id also
        and return msg : "Data Successfully deleted on id " + empId + "."
        if not able to find that id then it will throw
        Exception with msg :  Employee id " + empId + " not found to delete
    */

    @Override
    public String deleteEmployeePayrollDataById(Long empId) {
        Optional<EmployeePayrollData> employeePayrollData = employeePayrollRepository.findById(empId);
        if (employeePayrollData.isPresent()) {
            employeePayrollRepository.deleteById(empId);
            return "Data Successfully deleted on id " + empId + ".";
        } else {
            throw new CustomException(" Employee id " + empId + " not found to delete ");
        }
    }

    /* here updateEmployeePayrollDataById method will take empId and EmployeePayrollData from user then,
       it will search that id into the Data base
       if it found that id then it will update new data on that particular id
       then it will return msg : Successfully updated Employee id "+empId+" ."
       and not found that id then it will throw an
       Exception with msg :  Employee id " + empId + " not found to update
     */
    @Override
    public String updateEmployeePayrollDataById(Long empId, EmployeePayrollDTO employeePayrollDTO) {
        Optional<EmployeePayrollData> employeeData = employeePayrollRepository.findById(empId);
        if (employeeData.isPresent()){
            EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
            employeePayrollData.setEmpId(empId);
            employeePayrollRepository.save(employeePayrollData);
            return " Successfully updated Employee id " + empId + " .";
        } else {
            throw new CustomException(" Employee id " + empId + " not found to update  ");
        }
    }
}
