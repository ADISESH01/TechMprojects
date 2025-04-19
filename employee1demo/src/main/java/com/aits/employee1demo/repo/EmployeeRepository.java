package com.aits.employee1demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aits.employee1demo.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
