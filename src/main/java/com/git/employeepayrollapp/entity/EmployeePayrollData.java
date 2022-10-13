package com.git.employeepayrollapp.entity;

import com.git.employeepayrollapp.dto.EmployeePayrollDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id", nullable = false)
    private Long empId;

    private String name;
    private String image;
    private String gender;
    @ElementCollection
    @CollectionTable(name = "employee_departments", joinColumns = @JoinColumn(name = "emp_id"))
    private List<String> department;
    private Integer salary;

    private LocalDate startDate;
    private String notes;

    public EmployeePayrollData() {
    }

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.name;
        this.image = employeePayrollDTO.image;
        this.gender = employeePayrollDTO.gender;
        this.department = employeePayrollDTO.department;
        this.salary = employeePayrollDTO.salary;
        this.startDate = employeePayrollDTO.startDate;
        this.notes = employeePayrollDTO.notes;
    }

    public EmployeePayrollData(Long empId, String name, String image, String gender, List<String> department, Integer salary, LocalDate startDate, String notes) {
        this.empId = empId;
        this.name = name;
        this.image = image;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.startDate = startDate;
        this.notes = notes;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getDepartment() {
        return department;
    }

    public void setDepartment(List<String> department) {
        this.department = department;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
// old data backend

//    private String employeeName;
//
//    @ElementCollection
//    @CollectionTable(name = "employee_departments", joinColumns = @JoinColumn(name = "emp_id"))
//    @Column(name = "depart_name")
//    private List<String> departments;
//    private Long salary;
//
//    private String email;



//
//
//    public EmployeePayrollData() {
//    }
//
//    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
//        this.employeeName = employeePayrollDTO.employeeName;
//        this.departments = employeePayrollDTO.departments;
//        this.salary = employeePayrollDTO.salary;
//        this.email = employeePayrollDTO.email;
//    }
//
//    public EmployeePayrollData(Long empId, String employeeName, List<String> departments, Long salary, String email) {
//        this.empId = empId;
//        this.employeeName = employeeName;
//        this.departments = departments;
//        this.salary = salary;
//        this.email = email;
//    }
//
//    public Long getEmpId() {
//        return empId;
//    }
//
//    public void setEmpId(Long empId) {
//        this.empId = empId;
//    }
//
//    public String getEmployeeName() {
//        return employeeName;
//    }
//
//    public void setEmployeeName(String employeeName) {
//        this.employeeName = employeeName;
//    }
//
//    public List<String> getDepartments() {
//        return departments;
//    }
//
//    public void setDepartments(List<String> departments) {
//        this.departments = departments;
//    }
//
//    public Long getSalary() {
//        return salary;
//    }
//
//    public void setSalary(Long salary) {
//        this.salary = salary;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
