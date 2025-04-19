package com.aits.Employee.controller;

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

import com.aits.Employee.Employee;
import com.aits.Employee.EmployeeRepository;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeRepository employeerepository;
	@GetMapping("/employe/{id}")
	@ResponseBody
	public Optional<Employee> display(@PathVariable Long id){
		return employeerepository.findById(id);
	}
	@PostMapping("/employe")
	@ResponseBody
	public Employee insert(@RequestBody Employee employe) {
		employeerepository.save(employe);
		return employe;
	}
	@PutMapping("/employe/{id}")
	@ResponseBody
	public Employee update(@RequestBody Employee employe,@PathVariable Long id) {
		
		
		if(employeerepository.existsById(id)) {
			
		employe.setId(id);
			employeerepository.save(employe);
			
			return employe;
			
		}
		
		else {
			
			return null;
		}
		
		
	}
	
	
	
	@GetMapping("/employe")
	@ResponseBody
	public List <Employee> display(){
		
		return (List<Employee>) employeerepository.findAll();
	}
	
	
	
	
	@DeleteMapping("/employe/{id}")
	public void deleteEmployee(@PathVariable Long id) {
	    employeerepository.deleteById(id);
	    
	}
	
}
	
