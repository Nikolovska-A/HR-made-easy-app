package com.Nikolovska.spring.HRManagement;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Nikolovska.spring.HRManagement.model.JobPosition;
import com.Nikolovska.spring.HRManagement.model.Employee;
import com.Nikolovska.spring.HRManagement.model.Items;
import com.Nikolovska.spring.HRManagement.repository.VacationsRepository;
import com.Nikolovska.spring.HRManagement.repository.JobPositionRepository;
import com.Nikolovska.spring.HRManagement.repository.EmployeeRepository;
import com.Nikolovska.spring.HRManagement.repository.ItemsRepository;


@SpringBootApplication
public class HrManagementApplication {

	
    @Autowired
    private EmployeeRepository employeeRepo;
    
    @Autowired
    private ItemsRepository itemsRepo;
    
    @Autowired
    private JobPositionRepository job_positionRepo;
    
    @Autowired
    private VacationsRepository vacationsRepo;
    
	public static void main(String[] args) {
		SpringApplication.run(HrManagementApplication.class, args);
	}
	
	@PostConstruct
	public void createItems() {
		List<Items> items = new ArrayList<Items>();
		items.add(new Items(1, "phone"));
		items.add(new Items(2, "laptop"));
		items.add(new Items(3, "car"));
		itemsRepo.saveAll(items);

	}
	
	@PostConstruct
	public void createPositions() {	
		List<JobPosition> job_position = new ArrayList<JobPosition>();
		job_position.add(new JobPosition(1, "Lawyer"));
		job_position.add(new JobPosition(2, "Programer"));
		job_position.add(new JobPosition(3, "Accountant"));
		job_position.add(new JobPosition(4, "Human resources specialist"));
		job_position.add(new JobPosition(5, "Administrator"));
		job_position.add(new JobPosition(6, "Marketing specialist"));
		job_position.add(new JobPosition(7, "Security"));
		job_positionRepo.saveAll(job_position);	
	}
	
}

