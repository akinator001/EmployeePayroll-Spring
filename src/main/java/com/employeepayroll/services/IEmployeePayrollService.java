package com.employeepayroll.services;

import java.util.List;

import com.employeepayroll.dto.EmployeePayrollDTO;
import com.employeepayroll.model.EmployeePayrollData;

public interface IEmployeePayrollService {
	List<EmployeePayrollData> getEmployeeData();
	EmployeePayrollData getEmployeePayrollById(int empId);

	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

	EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO empPayrollDTO);

	void deleteEmployeePayrollData(int empId);
}