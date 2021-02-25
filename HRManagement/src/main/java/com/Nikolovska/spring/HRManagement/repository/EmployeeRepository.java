package com.Nikolovska.spring.HRManagement.repository;
	
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Nikolovska.spring.HRManagement.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByUsernameAndPassword(String username, String password);
	
	Optional<Employee> findById(Long id);	
	
}
