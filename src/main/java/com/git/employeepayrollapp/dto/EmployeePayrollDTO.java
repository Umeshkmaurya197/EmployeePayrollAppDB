package com.git.employeepayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name should start with capital letter and have minimum 3 characters. ")
    public String name;
    public String image;
    public  String gender;
    public List<String> department;
    public Integer salary;
    public LocalDate startDate;
    public String notes;

    @Override
    public String toString() {
        return "EmployeePayrollDTO{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", date=" + startDate +
                ", notes='" + notes + '\'' +
                '}';
    }
//
//    public String employeeName;
//
//    public List<String> departments;
//    public Long salary;
//    @Email
//    public String email;
//    @Override
//    public String toString() {
//        return "EmployeePayrollDTO{" + "employeeName='" + employeeName + '\'' + ", departments=" + departments + ", salary=" + salary + ", email='" + email + '\'' + '}';
//    }
}
