package com.sreenath.employeepayrollapp.model;

import com.sreenath.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

public @Data class EmployeePayrollData {

    private int employeeId;
    private String name;
    private long salary;

    public EmployeePayrollData() {
    }

    public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = employeeId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
    }
}
