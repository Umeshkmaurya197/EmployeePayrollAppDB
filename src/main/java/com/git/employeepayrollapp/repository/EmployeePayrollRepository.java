package com.git.employeepayrollapp.repository;

import com.git.employeepayrollapp.entity.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Long> {

//    @Query(value = "SELECT * FROM payroll_service.employee_payroll_data e where e.employee_name = :employeeName", nativeQuery = true)
//    Optional<EmployeePayrollData> findEmployeeByName(@Param("employeeName") String employeeName);

    @Query(value = "SELECT * FROM payroll_service.employee_payroll_data e where e.employee_name = :empName", nativeQuery = true)
    List<EmployeePayrollData> findEmployeeByName(@Param("empName") String employeeName);

}
