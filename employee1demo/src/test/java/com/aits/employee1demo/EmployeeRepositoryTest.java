package com.aits.employee1demo;


import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import com.aits.employee1demo.entity.Employee;
import com.aits.employee1demo.repo.EmployeeRepository;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Test
	@Rollback(false)
	void testSaveAndFindById() {
		Employee emp=new Employee();
		emp.setId(2);
		emp.setName("John");
		emp.setSalary(1000);
		Employee emp1=employeeRepository.save(emp);
		
		Assertions.assertEquals("John",emp1.getName());
		Assertions.assertEquals(1000,emp1.getSalary());
		
		Optional<Employee> emp2=employeeRepository.findById(2);
		
		Assertions.assertEquals("John",emp2.get().getName());
	}

}