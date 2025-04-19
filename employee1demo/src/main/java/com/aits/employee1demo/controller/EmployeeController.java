package com.aits.employee1demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aits.employee1demo.entity.Employee;
import com.aits.employee1demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	//this class should communicate to service..service
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> insert(@RequestBody Employee emp){
		
		employeeService.insert(emp);
		
		return new ResponseEntity<>(emp,HttpStatus.CREATED);
		
	}
	
	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> updateSal(@RequestParam double hike,@PathVariable int id){
	
	
	
		Employee emp=employeeService.updateSalary(hike,id);
	
			return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	
	}
	
	

}