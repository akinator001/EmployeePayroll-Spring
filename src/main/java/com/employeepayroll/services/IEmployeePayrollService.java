package com.employeepayroll.services;

import java.util.List;

import com.employeepayroll.dto.EmployeePayrollDTO;
import com.employeepayroll.model.EmployeePayrollData;

public interface IEmployeePayrollService {
	List<EmployeePayrollDTO> getAllUser();

	EmployeePayrollDTO createUser(EmployeePayrollDTO user);

	EmployeePayrollDTO updateUser(EmployeePayrollDTO user);

	EmployeePayrollDTO deleteUser(Long id);
}