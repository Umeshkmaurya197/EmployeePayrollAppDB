package com.git.employeepayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name should start with capital letter and have minimum 3 characters. ")
    public String employeeName;

    public List<String> departments;
    public Long salary;
    @Email
    public String email;
    @Override
    public String toString() {
        return "EmployeePayrollDTO{" + "employeeName='" + employeeName + '\'' + ", departments=" + departments + ", salary=" + salary + ", email='" + email + '\'' + '}';
    }
}
