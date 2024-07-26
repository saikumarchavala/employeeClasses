package com.imaginnovate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaginnovate.entity.Employee;
import com.imaginnovate.request.EmployeeRequest;

@Repository
public interface ImagInnovateEmployeeRepository extends JpaRepository<Employee,Long> {



}
