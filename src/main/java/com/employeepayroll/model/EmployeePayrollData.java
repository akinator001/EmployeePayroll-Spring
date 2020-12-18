package com.employeepayroll.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.employeepayroll.dto.EmployeePayrollDTO;

import lombok.Data;

@Entity
@Table(name = "employee_payroll")
public class EmployeePayrollData implements Serializable{

	private static final long serialVersionUID = -8900492704842756948L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String profilePic;
	private String gender;
	private long salary;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "departmentId")
	private List<Department> departments;
	private Date startDate;
	private String notes;
	
	public EmployeePayrollData() {}
	
	public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		super();
		this.setName(employeePayrollDTO.getName());
		this.setProfilePic(employeePayrollDTO.getProfilePic());
		this.setGender(employeePayrollDTO.getGender());
		this.setSalary(employeePayrollDTO.getSalary());
		List<Department> departments = new ArrayList<Department>();
		for(String department : employeePayrollDTO.getDepartments()) {
			departments.add(new Department(department));
		}
		this.departments = departments;
		this.setNotes(employeePayrollDTO.getNotes());
		this.setStartDate(employeePayrollDTO.getStartDate());
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

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String[] getDepartments() {
		String array[] = new String[departments.size()];              
		for(int j =0;j<departments.size();j++){
		  array[j] = departments.get(j).getDepartmentName();
		}
		return array;
	}

	public void setDepartments(List<String> departments) {
		List<Department> departmentList = new ArrayList<Department>();
		for(String department : departments) {
			departmentList.add(new Department(department));
		}
		this.departments = departmentList;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
