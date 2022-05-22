package com.sreenath.employeepayrollapp.service;

import com.sreenath.employeepayrollapp.dto.EmployeePayrollDTO;
import com.sreenath.employeepayrollapp.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {

    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int employeeId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(int employeeId);
}
