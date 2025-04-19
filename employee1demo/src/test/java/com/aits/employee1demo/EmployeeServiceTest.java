package com.aits.employee1demo;
 
 
 
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import java.util.Optional;
 

 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.aits.employee1demo.entity.Employee;
import com.aits.employee1demo.exception.EmployeeNotFound;
import com.aits.employee1demo.exception.HikeisInvalidException;
import com.aits.employee1demo.repo.EmployeeRepository;
import com.aits.employee1demo.service.EmployeeService;
 @SpringBootTest
class EmployeeServiceTest {
 
    @InjectMocks
    private EmployeeService employeeService;
 
    @Mock
    private EmployeeRepository employeeRepository;
 
    @BeforeEach
    void setUp() {
       MockitoAnnotations.openMocks(this);
        
        //employeeService=new EmployeeService(employeeRepository);
    }
 
    @Test
    void testInsertEmployee() {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("John");
        emp.setSalary(3000);
 
     //before going for actual insertion call..you are giving a caution..if you find the code like save()..just return emp  
      Mockito.when(employeeRepository.save(emp)).thenReturn(emp);
 
     // Assertions.assertThrows(emp,() -> employeeService.insert(emp)) ;
      
    // Assertions.assertEquals(emp,emp);
     
       Assertions.assertDoesNotThrow(() -> employeeService.insert(emp));
    }
 
    @Test
    void testUpdateSalarySuccess() {
        Employee emp = new Employee();
        emp.setId(2);
        emp.setName("John");
        emp.setSalary(3000);
 
       Mockito.when(employeeRepository.findById(2)).thenReturn(Optional.of(emp));
        Mockito.when(employeeRepository.save(emp)).thenReturn(emp);
 
        Employee updatedEmp = employeeService.updateSalary(500, 2);
 
        
        
        Assertions.assertEquals(3500, updatedEmp.getSalary());
        assertEquals("John", updatedEmp.getName());
        assertEquals(1, updatedEmp.getId());
    }
 
    @Test
    void testUpdateSalary_EmployeeNotFound() {
        when(employeeRepository.findById(2)).thenReturn(Optional.empty());
 
        Exception ex = assertThrows(EmployeeNotFound.class, () -> employeeService.updateSalary(500, 2));
        assertEquals("emp not found", ex.getMessage());
    }
 
    @Test
    void testUpdateSalary_HikeMoreThanAllowed() {
        Employee emp = new Employee();
        emp.setId(2);
        emp.setName("John");
        emp.setSalary(3000);
 
        when(employeeRepository.findById(2)).thenReturn(Optional.of(emp));
 
        Exception ex = assertThrows(HikeisInvalidException.class, () -> employeeService.updateSalary(1500, 2));
        assertEquals(" hike is not found", ex.getMessage());
    }
    
    
    
}
 
 