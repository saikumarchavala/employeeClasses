package com.imaginnovate.response;


import java.sql.Date;
import java.util.List;

import com.imaginnovate.request.PhoneNumbersRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailsResponse {

	private Long employeeId;
	private String firstName;
	private String lastName;
	private Double yearlySalary;
	private Double taxAmount;
	private Double cessAmount;
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getYearlySalary() {
		return yearlySalary;
	}
	public void setYearlySalary(Double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	public Double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public Double getCessAmount() {
		return cessAmount;
	}
	public void setCessAmount(Double cessAmount) {
		this.cessAmount = cessAmount;
	}
	public EmployeeDetailsResponse(Long employeeId, String firstName, String lastName, Double yearlySalary,
			Double taxAmount, Double cessAmount) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearlySalary = yearlySalary;
		this.taxAmount = taxAmount;
		this.cessAmount = cessAmount;
	}
	public EmployeeDetailsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeeDetailsResponse [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", yearlySalary=" + yearlySalary + ", taxAmount=" + taxAmount + ", cessAmount="
				+ cessAmount + "]";
	}
	


}
