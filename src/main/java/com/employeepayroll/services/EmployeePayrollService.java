package com.employeepayroll.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeepayroll.dto.EmployeePayrollDTO;
import com.employeepayroll.exceptions.DetailsNotProvidedExceptions;
import com.employeepayroll.exceptions.UserNotFound;
import com.employeepayroll.model.EmployeePayrollData;
import com.employeepayroll.repository.EmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	
	@Autowired
	private EmployeePayrollRepository employeePayrollRepository;
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return (List<EmployeePayrollData>) employeePayrollRepository.findAll();
	}
	
	@Override
	public EmployeePayrollData getEmployeePayrollDataById(Long employeeId) {
		return employeePayrollRepository.findById(employeeId).get();
	}
	
	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
		employeePayrollRepository.save(employeePayrollData);
		return employeePayrollData;
	}
	
	@Override
	public EmployeePayrollData updateEmployeePayrollData(Long employeeId, EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(employeeId);
		employeePayrollData.setName(employeePayrollDTO.getName());
		employeePayrollData.setGender(employeePayrollDTO.getGender());
		employeePayrollData.setProfilePic(employeePayrollDTO.getProfilePic());
		employeePayrollData.setSalary(employeePayrollDTO.getSalary());
		employeePayrollData.setNotes(employeePayrollDTO.getNotes());
		employeePayrollData.setDepartments(employeePayrollDTO.getDepartments());
		employeePayrollData.setStartDate(employeePayrollDTO.getStartDate());
		employeePayrollRepository.save(employeePayrollData);
		
		return employeePayrollData;
	}

	@Override
	public void deleteEmployeePayrollData(Long employeeId) {	
		
		employeePayrollRepository.deleteById(employeeId);

	}

}