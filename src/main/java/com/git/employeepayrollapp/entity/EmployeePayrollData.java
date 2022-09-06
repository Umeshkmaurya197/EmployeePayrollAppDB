package com.git.employeepayrollapp.entity;

import com.git.employeepayrollapp.dto.EmployeePayrollDTO;

import javax.persistence.*;

@Entity
public class EmployeePayrollData{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id", nullable = false)
    private Long empId;
    private String employeeName;
    private Long salary;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public EmployeePayrollData() {
    }

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.employeeName = employeePayrollDTO.employeeName;
        this.salary = employeePayrollDTO.salary;
    }

    public EmployeePayrollData(Long empId, String employeeName, Long salary) {
        this.empId = empId;
        this.employeeName = employeeName;
        this.salary = salary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
