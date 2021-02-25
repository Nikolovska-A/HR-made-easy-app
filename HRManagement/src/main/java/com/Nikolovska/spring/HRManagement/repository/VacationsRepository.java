package com.Nikolovska.spring.HRManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Nikolovska.spring.HRManagement.model.Vacations;

@Repository
public interface VacationsRepository extends JpaRepository<Vacations, Long> {

	@Modifying
	@Query(value="SELECT * FROM hrmanagement_app_schema.vacations WHERE employee_id = ?1", nativeQuery = true)
	public List<Vacations> findByEmployee_id (Long id);

	
//	@Query(value="SELECT * FROM hrmanagement_app_schema.vacations WHERE id = ?1", nativeQuery = true)
	public Optional<Vacations> findById(Long id);
	
}


