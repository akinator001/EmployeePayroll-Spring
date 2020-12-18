package com.employeepayroll.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int departmentId;
	private String departmentName;
	public Department() {
		
	}
	
	public Department(String departmentName) {
		setDepartmentName(departmentName);
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	@Override
	public String toString() {
		return "Department [departmentName = " + departmentName + "]";
	}
	
}