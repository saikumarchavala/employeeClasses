package com.imaginnovate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PhoneNumbers {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long uniqueId;
	
	private Long phoneNumber;

	public Long getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(Long uniqueId) {
		this.uniqueId = uniqueId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PhoneNumbers(Long uniqueId, Long phoneNumber) {
		super();
		this.uniqueId = uniqueId;
		this.phoneNumber = phoneNumber;
	}

	public PhoneNumbers() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PhoneNumbers [uniqueId=" + uniqueId + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}
