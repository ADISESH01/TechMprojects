package com.aits.employee1demo.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;



@Entity

public class Employee {

	@Id

	//@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id ;

	private String name;

	private double salary;

	

	public Employee() {

		

	}

	

	public Employee(String name,double salary) {

		this.name=name;

		this.salary=salary;

	}



	public Integer getId() {

		return id;

	}



	public void setId(Integer id) {

		this.id = id;

	}



	public String getName() {

		return name;

	}



	public void setName(String name) {

		this.name = name;

	}



	public double getSalary() {

		return salary;

	}



	public void setSalary(double salary) {

		this.salary = salary;

	}

	

}

