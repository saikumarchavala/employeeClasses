package com.imaginnovate.request;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

	@NotNull
	private Long employeeId;
	@Pattern(regexp="[A-Za-z]")
	@NotNull
	private String firstName;
	@NotNull
	@Pattern(regexp="[A-Za-z]")
	private String lastName;
	
	@NotNull
	@Pattern(regexp="[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\"\n"
			+ "        + \"[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})")
	private String email;
	private List<PhoneNumbersRequest> phoneNumbers;
	@NotNull
	private Date doj;
	@NotNull
	private String salaryPerMonth;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<PhoneNumbersRequest> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<PhoneNumbersRequest> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getSalaryPerMonth() {
		return salaryPerMonth;
	}
	public void setSalaryPerMonth(String salaryPerMonth) {
		this.salaryPerMonth = salaryPerMonth;
	}
	public EmployeeRequest(Long employeeId, String firstName, String lastName, String email,
			List<PhoneNumbersRequest> phoneNumbers, Date doj, String salaryPerMonth) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
		this.doj = doj;
		this.salaryPerMonth = salaryPerMonth;
	}
	public EmployeeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeeRequest [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumbers=" + phoneNumbers + ", doj=" + doj + ", salaryPerMonth="
				+ salaryPerMonth + "]";
	}
	

	
	
}
