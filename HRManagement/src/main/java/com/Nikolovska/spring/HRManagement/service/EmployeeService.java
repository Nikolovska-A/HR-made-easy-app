package com.Nikolovska.spring.HRManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Nikolovska.spring.HRManagement.model.Employee;
import com.Nikolovska.spring.HRManagement.repository.EmployeeRepository;


@Service
public class EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
    public Employee saveEmployee(Employee employee) {
		employeeRepository.save(employee); 
		return employee;
	 }
    
    public List<Employee> getEmployee (String username, String password) {
    	return employeeRepository.findByUsernameAndPassword(username, password);
    }

  
    public void deleteEmployeeById(long id) {
    this.employeeRepository.deleteById(id);
   }
    

	public Optional<Employee> findById(Long id) {
		return employeeRepository.findById(id);
	}
	public void updateEmplpoyee(Employee employee) {
		employeeRepository.save(employee);
		
	}
	

}



