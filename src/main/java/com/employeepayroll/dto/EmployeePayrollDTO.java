package com.employeepayroll.dto;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmployeePayrollDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
	private String name;
	
	@NotEmpty(message = "Salary can't be empty")
	private long salary;
	
	private String profilePic;
	
	@NotEmpty(message = "Gender can't be empty")
	private String gender;
	private String notes;
	
	@NotEmpty(message = "Department can't be empty")
	private List<String> departments;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	@NotEmpty(message = "Start Date can't be empty")
	private Date startDate;
	
	public EmployeePayrollDTO() {

	}

	public EmployeePayrollDTO(String name, String profilePic, String gender, long salary, List<String> departments, 
			Date startDate, String notes) {
		super();
		this.name = name;
		this.profilePic = profilePic;
		this.gender = gender;
		this.salary = salary;
		this.departments = departments;
		this.startDate = startDate;
		this.notes = notes;
		
	}
}