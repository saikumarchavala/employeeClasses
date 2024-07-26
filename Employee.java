package com.imaginnovate.entity;

import java.sql.Date;
import java.util.List;

import com.imaginnovate.request.PhoneNumbersRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long uniqueId;
	private Long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "phoneNum_Id", referencedColumnName = "uniqueId")
	private List<PhoneNumbers> phoneNumber;
	private Date doj;
	private String salaryPerMonth;
	public Long getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(Long uniqueId) {
		this.uniqueId = uniqueId;
	}
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
	public List<PhoneNumbers> getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(List<PhoneNumbers> phoneNos) {
		this.phoneNumber = phoneNos;
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
	
	
	public Employee(Long uniqueId, Long employeeId, String firstName, String lastName, String email,
			List<PhoneNumbers> phoneNumber, Date doj, String salaryPerMonth) {
		super();
		this.uniqueId = uniqueId;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.doj = doj;
		this.salaryPerMonth = salaryPerMonth;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [uniqueId=" + uniqueId + ", employeeId=" + employeeId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", doj=" + doj
				+ ", salaryPerMonth=" + salaryPerMonth + "]";
	}

	
}
