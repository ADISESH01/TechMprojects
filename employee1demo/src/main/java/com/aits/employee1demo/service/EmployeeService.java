package com.aits.employee1demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aits.employee1demo.entity.Employee;
import com.aits.employee1demo.exception.EmployeeNotFound;
import com.aits.employee1demo.exception.HikeisInvalidException;
import com.aits.employee1demo.repo.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository 	employeeRepository;
	
	
	public void insert(Employee emp) {
		
		employeeRepository.save(emp);
		
	}
	
	@Transactional

	public Employee updateSalary(double hike, int id) {
		// TODO Auto-generated method stub
		
		
		Employee emp=employeeRepository.findById(id).orElseThrow(
				()->new EmployeeNotFound("emp not found"));
				
				
				
						if(hike>1000) {
							throw new HikeisInvalidException(" hike is not found");
						}
						
						emp.setSalary(emp.getSalary()+hike);
						employeeRepository.save(emp);
				
				
				
						return emp;
	}

	
}