package com.git.employeepayrollapp.dto;

public class EmployeePayrollDTO {

    public String employeeName;
    public Long salary;

    public EmployeePayrollDTO(String employeeName, Long salary) {
        this.employeeName = employeeName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDTO{" +
                "employeeName='" + employeeName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
