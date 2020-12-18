package com.employeepayroll.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.employeepayroll.dto.ResponseDTO;

@ControllerAdvice
public class EmployeePayrollExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
											MethodArgumentNotValidException exception){
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errorMessage = errorList.stream()
											 .map(objErr -> objErr.getDefaultMessage())
											 .collect(Collectors.toList());
		ResponseDTO responseDto = new ResponseDTO("Exception while processing REST Request", errorMessage);
		return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException exception){
		ResponseDTO responseDto = new ResponseDTO("Exception while processing REST Request", exception.getMessage());
		return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);
	}

}