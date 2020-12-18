package com.employeepayroll.services;

import java.util.List;

import com.employeepayroll.dto.EmployeePayrollDTO;
import com.employeepayroll.model.EmployeePayrollData;

public interface IEmployeePayrollService {
	List<EmployeePayrollData> getEmployeePayrollData();
	
	EmployeePayrollData getEmployeePayrollDataById(Long employeeId);
	
	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

	EmployeePayrollData updateEmployeePayrollData(Long employeeId, EmployeePayrollDTO employeePayrollDTO);

	void deleteEmployeePayrollData(Long employeeId);

}