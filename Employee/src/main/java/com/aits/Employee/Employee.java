package com.aits.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

	@Entity
	public class Employee {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		private String name;
		private String email;
		private Long salary;
		private String department;
		public Employee(Long id, String name, String email, Long salary, String department) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.salary = salary;
			this.department = department;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Long getSalary() {
			return salary;
		}
		public void setSalary(Long salary) {
			this.salary = salary;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		

	}
