package com.imaginnovate.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.request.EmployeeRequest;
import com.imaginnovate.response.EmployeeDetailsResponse;
import com.imaginnovate.response.EmployeeResponse;
import com.imaginnovate.service.ImagInnovateEmployeeService;

@RestController
public class ImagInnovateEmployeeController {
	
	@Autowired
	private ImagInnovateEmployeeService imanovateEmployeeService;

 public static final Logger LOGGER = LoggerFactory.getLogger(ImagInnovateEmployeeController.class);
	
    @PostMapping("/saveEmployee")
	public ResponseEntity<?> saveEmployeeDetails(@Valid @RequestBody EmployeeRequest employee) throws Exception{
		LOGGER.info("saveEmployeeDetails method called in ImagInnovateEmployeeController");
		
		EmployeeResponse response = new  EmployeeResponse();
		try {
			response=imanovateEmployeeService.saveEmployeeDetails(employee);
		}catch(Exception e) {
			throw new Exception("Error occured while saving employee details ");
		}
		ResponseEntity<EmployeeResponse> responseEntity= new ResponseEntity<EmployeeResponse>(response,HttpStatus.OK);
		return responseEntity;
	}
    
    @PostMapping("/getEmployeeDetails")
   	public ResponseEntity<?> getAllEmployeeDetails() throws Exception{
   		LOGGER.info("saveEmployeeDetails method called in ImagInnovateEmployeeController");
   		
   		List<EmployeeDetailsResponse> response = new  ArrayList<EmployeeDetailsResponse>();
   		try {
   			response= imanovateEmployeeService.getEmployeeDetails();
   		}catch(Exception e) {
   			throw new Exception("Error occured while saving employee details ");
   		}
   		ResponseEntity<List<EmployeeDetailsResponse>> responseEntity= new ResponseEntity<List<EmployeeDetailsResponse>>(response,HttpStatus.OK);
   		return responseEntity;
   	}
}
