package com.imaginnovate.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumbersRequest {

	@NotNull
	private Long phoneNumber;

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PhoneNumbersRequest(Long phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}

	public PhoneNumbersRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PhoneNumbersRequest [phoneNumber=" + phoneNumber + "]";
	}

	
}
