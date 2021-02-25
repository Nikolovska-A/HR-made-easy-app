package com.Nikolovska.spring.HRManagement.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Nikolovska.spring.HRManagement.model.Employee;
import com.Nikolovska.spring.HRManagement.model.Vacations;
import com.Nikolovska.spring.HRManagement.repository.EmployeeRepository;
import com.Nikolovska.spring.HRManagement.repository.VacationsRepository;

@Service
public class VacationsService {
	private static List<Vacations> vacation = new ArrayList<Vacations>();

	@Autowired
	private VacationsRepository vacationsRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public void addVacation(Date begin_date, Date end_date, boolean isDone) {
		vacation.add(new Vacations());
	}

	public Vacations saveVacations(Vacations vacations) {
		vacationsRepository.save(vacations);
		return vacations;
	}

	public void updateVacationsDays(Long id, Long days) {
		Employee employee = employeeRepository.getOne(id);
		employee.setVacation_days(days);
		employeeRepository.save(employee);
	}

	public List<Vacations> findByEmployee_id(Long id) {
		return vacationsRepository.findByEmployee_id(id);
	}

	public void delete(Long id) {
		vacationsRepository.deleteById(id);
	}

	public Vacations retrieveVacation(Long id) {
		for (Vacations vacations : vacation) {
			if (vacations.getId() == id) {
				return vacations;
			}
		}
		return null;
	}

	public Optional<Vacations> findById(Long id) {
		return vacationsRepository.findById(id);
	}

	public Long deleteVacation(Long id) {
		vacationsRepository.deleteById(id);
		return id;

	}

	public List<Vacations> getAllVacations() {
		return vacationsRepository.findAll();
	}

	public void updateVacations(Vacations vacations) {
		vacationsRepository.save(vacations);

	}

}
