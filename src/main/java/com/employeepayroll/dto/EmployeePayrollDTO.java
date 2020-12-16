package com.employeepayroll.dto;

import java.time.LocalDate;

import com.employeepayroll.model.EmployeePayrollData;

import lombok.Data;

@Data
public class EmployeePayrollDTO {
	private Long id;
	private String name;
	private String basicPay;
	private LocalDate startDate;
	private Character gender;	
	
	public EmployeePayrollDTO(EmployeePayrollData employeePayroll) {
		this.setId(employeePayroll.getId());
		this.setName(employeePayroll.getName());
		this.setBasicPay(employeePayroll.getBasicPay());
	}
	
	public EmployeePayrollDTO() {}
}