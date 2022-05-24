package com.sreenath.employeepayrollapp.repository;

import com.sreenath.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {
}
