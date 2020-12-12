package com.employeepayroll.model;

import com.employeepayroll.dto.EmployeePayrollDTO;

public class EmployeePayrollData {
	private int employeeId;
	private String name;
	private long salary;

	public EmployeePayrollData() {}
	public EmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		this.setEmployeeId(empId);
		this.setName(empPayrollDTO.name);
		this.setSalary(empPayrollDTO.salary);
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}

}