package com.sreenath.employeepayrollapp.service;

import com.sreenath.employeepayrollapp.dto.EmployeePayrollDTO;
import com.sreenath.employeepayrollapp.exceptions.EmployeePayrollCustomException;
import com.sreenath.employeepayrollapp.model.EmployeePayrollData;
import com.sreenath.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    private List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollDataList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int employeeId) {
        return employeePayrollDataList.stream()
                                      .filter(employeePayrollData -> employeePayrollData.getEmployeeId() == employeeId)
                                      .findFirst()
                                      .orElseThrow(() -> new EmployeePayrollCustomException("Employee not found"));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
        employeePayrollDataList.add(employeePayrollData);
        log.debug("Employee data : " + employeePayrollData.toString());
        return employeePayrollRepository.save(employeePayrollData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(employeeId);
        employeePayrollData.setName(employeePayrollDTO.name);
        employeePayrollData.setSalary(employeePayrollDTO.salary);
        employeePayrollDataList.set(employeeId - 1, employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int employeeId) {
        employeePayrollDataList.remove(employeeId - 1);
    }
}
