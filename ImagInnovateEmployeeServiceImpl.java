package com.imaginnovate.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.entity.Employee;
import com.imaginnovate.entity.PhoneNumbers;
import com.imaginnovate.repository.ImagInnovateEmployeeRepository;
import com.imaginnovate.request.EmployeeRequest;
import com.imaginnovate.request.PhoneNumbersRequest;
import com.imaginnovate.response.EmployeeDetailsResponse;
import com.imaginnovate.response.EmployeeResponse;

import jakarta.transaction.Transactional;

@Service
public class ImagInnovateEmployeeServiceImpl implements ImagInnovateEmployeeService {

	@Autowired
	ImagInnovateEmployeeRepository imagInnovateEmployeeRepository;

	@Transactional
	@Override
	public EmployeeResponse saveEmployeeDetails(@Valid EmployeeRequest employeeReq) {

		EmployeeResponse res = new EmployeeResponse();
		Employee emp = new Employee();
		emp.setEmployeeId(employeeReq.getEmployeeId());
		emp.setFirstName(employeeReq.getFirstName());
		emp.setLastName(employeeReq.getLastName());
		emp.setDoj(employeeReq.getDoj());
		emp.setEmail(employeeReq.getEmail());
		emp.setSalaryPerMonth(employeeReq.getSalaryPerMonth());

		List<PhoneNumbers> phoneNos = new ArrayList<PhoneNumbers>();

		for (PhoneNumbersRequest mobileNo : employeeReq.getPhoneNumbers()) {
			PhoneNumbers phoneNo = new PhoneNumbers();
			phoneNo.setPhoneNumber(mobileNo.getPhoneNumber());
			phoneNos.add(phoneNo);
		}
		emp.setPhoneNumber(phoneNos);

		imagInnovateEmployeeRepository.save(emp);
		res.setMessage("Employee Details saved successfully");
		return res;
	}

	@Override
	public List<EmployeeDetailsResponse> getEmployeeDetails() {

		List<EmployeeDetailsResponse> result = new ArrayList<EmployeeDetailsResponse>();
		List<Employee> empDetails = imagInnovateEmployeeRepository.findAll();

		if (Optional.ofNullable(empDetails).isPresent()) {
			for (Employee empObject : empDetails) {
				EmployeeDetailsResponse res = new EmployeeDetailsResponse();

				res.setEmployeeId(empObject.getEmployeeId());
				res.setFirstName(empObject.getFirstName());
				res.setLastName(empObject.getLastName());
				EmployeeDetailsResponse resDetails = manipulateFetchedEmployeeDetails(empObject, res);
				res.setCessAmount(resDetails.getCessAmount());
				res.setTaxAmount(resDetails.getTaxAmount());
				res.setYearlySalary(resDetails.getYearlySalary());
				result.add(res);

			}
		}
		return result;
	}

	private EmployeeDetailsResponse manipulateFetchedEmployeeDetails(Employee empObject, EmployeeDetailsResponse res) {

		Long noOfMonths = (long) 12;
		Long yearlySal = Long.parseLong(empObject.getSalaryPerMonth()) * noOfMonths;

		LocalDate empDoj = LocalDate.parse(empObject.getDoj().toString());

		LocalDate fiscalYearStart = LocalDate.of(empDoj.getYear(), 4, 1);
		LocalDate fiscalYearEnd = LocalDate.of(empDoj.getYear() + 1, 3, 31);

		if (empDoj.isBefore(fiscalYearStart)) {
			fiscalYearStart = LocalDate.of(empDoj.getYear() - 1, 4, 1);
			fiscalYearEnd = LocalDate.of(empDoj.getYear(), 3, 31);

		}
		long workedDays = ChronoUnit.DAYS.between(empDoj, fiscalYearEnd) + 1;

		long totalDayInYear = fiscalYearStart.isLeapYear() || fiscalYearEnd.isLeapYear() ? 366 : 365;

		empObject.getDoj();
		double dailySalary = yearlySal / totalDayInYear;
		Double empFinalSalAnnually = dailySalary * workedDays;
		res.setYearlySalary(empFinalSalAnnually);

		Double tax = 0.00;
		Double cess = 0.00;
		if (empFinalSalAnnually > 1000000) {
			tax += (empFinalSalAnnually - 1000000) * 0.20;
			if (empFinalSalAnnually > 2500000) {
				Double cessApplicableAmount = empFinalSalAnnually - 2500000;

				cess = cessApplicableAmount / 300000 * 0.02 * empFinalSalAnnually;
			} else {
				cess = null;
			}

		}
		if (empFinalSalAnnually > 500000) {
			tax += (empFinalSalAnnually - 500000) * 0.10;
		}
		if (empFinalSalAnnually > 250000) {
			tax += (empFinalSalAnnually - 250000) * 0.05;
		}
		res.setTaxAmount(tax);
		res.setCessAmount(cess);

		return res;

	}

}
