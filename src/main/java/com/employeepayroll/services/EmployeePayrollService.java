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
public class EmployeePayrollService implements IEmployeePayrollService{
	@Autowired
    private EmployeePayrollRepository employeePayrollRepository;
	
	public List<EmployeePayrollDTO> getAllUser(){
		return employeePayrollRepository.findAll().stream()
				.map(employeePayroll -> new EmployeePayrollDTO(employeePayroll))
				.collect(Collectors.toList());
    }

	
	@Override
	public EmployeePayrollDTO createUser(EmployeePayrollDTO employeePayrollDTO) {
		if(Objects.nonNull(employeePayrollDTO.getName()) && Objects.nonNull(employeePayrollDTO.getBasicPay())){
			EmployeePayrollData employeePayroll = new EmployeePayrollData(employeePayrollDTO.getName(), employeePayrollDTO.getBasicPay(),employeePayrollDTO.getGender(),employeePayrollDTO.getStartDate());
			return new EmployeePayrollDTO(employeePayrollRepository.save(employeePayroll));
		}
		throw new DetailsNotProvidedExceptions("Invalid Data");
	}

	@Override
	public EmployeePayrollDTO updateUser(EmployeePayrollDTO employeePayrollDTO) {
		return employeePayrollRepository.findById(employeePayrollDTO.getId()).map(employeePayroll -> {
			if(Objects.nonNull(employeePayrollDTO.getName())) {
				employeePayroll.setName(employeePayrollDTO.getName());
			}
			if(Objects.nonNull(employeePayrollDTO.getBasicPay())) {
				employeePayroll.setBasicPay(employeePayrollDTO.getBasicPay());
			}
			return new EmployeePayrollDTO(employeePayrollRepository.save(employeePayroll));
		}).orElseThrow(() -> new UserNotFound("UserNotFound"));
	}

	@Override
	public EmployeePayrollDTO deleteUser(Long id) {
		return employeePayrollRepository.findById(id).map(employeePayroll -> {
			employeePayrollRepository.deleteById(employeePayroll.getId());
			return new EmployeePayrollDTO(employeePayroll);
		}).orElseThrow(() -> new UserNotFound("UserNOtFound"));
	}

}