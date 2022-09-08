package com.git.employeepayrollapp.entity;

import com.git.employeepayrollapp.dto.EmployeePayrollDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id", nullable = false)
    private Long empId;
    private String employeeName;

    @ElementCollection
    @CollectionTable(name = "employee_departments", joinColumns = @JoinColumn(name = "emp_id"))
    @Column(name = "depart_name")
    private List<String> departments;
    private Long salary;

    public EmployeePayrollData() {
    }

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.employeeName = employeePayrollDTO.employeeName;
        this.departments = employeePayrollDTO.departments;
        this.salary = employeePayrollDTO.salary;
    }

    public EmployeePayrollData(Long empId, String employeeName, List<String> departments, Long salary) {
        this.empId = empId;
        this.employeeName = employeeName;
        this.departments = departments;
        this.salary = salary;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
