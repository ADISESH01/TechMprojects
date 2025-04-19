package com.example.restapi1demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.restapi1demo.Employee;
import com.example.restapi1demo.EmployeeRepository;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeRepository employeerepository;
	@GetMapping("/employee/{id}")
	@ResponseBody
	public Optional<Employee> display(@PathVariable Long id){
		return employeerepository.findById(id);
	}
	@PostMapping("/employee")
	@ResponseBody
	public Employee insert(@RequestBody Employee employee) {
		employeerepository.save(employee);
		return employee;
	}
	@PutMapping("/employee/{id}")
	@ResponseBody
	public Employee update(@RequestBody Employee employee,@PathVariable Long id) {
		
		
		if(employeerepository.existsById(id)) {
			
		employee.setId(id);
			employeerepository.save(employee);
			
			return employee;
			
		}
		
		else {
			
			return null;
		}
		
		
	}
	
	
	
	@GetMapping("/employee")
	@ResponseBody
	public List <Employee> display(){
		
		return (List<Employee>) employeerepository.findAll();
	}
	
	
	
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable Long id) {
	    employeerepository.deleteById(id);
	    
	}
	
}
	


