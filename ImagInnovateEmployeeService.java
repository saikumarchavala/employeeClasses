package com.imaginnovate.service;

import java.util.List;

import javax.validation.Valid;

import com.imaginnovate.request.EmployeeRequest;
import com.imaginnovate.response.EmployeeDetailsResponse;
import com.imaginnovate.response.EmployeeResponse;

public interface ImagInnovateEmployeeService {

	EmployeeResponse saveEmployeeDetails(@Valid EmployeeRequest employee);

	List<EmployeeDetailsResponse> getEmployeeDetails();

}
