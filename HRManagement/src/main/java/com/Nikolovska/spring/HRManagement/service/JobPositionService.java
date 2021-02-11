package com.Nikolovska.spring.HRManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Nikolovska.spring.HRManagement.model.JobPosition;
import com.Nikolovska.spring.HRManagement.repository.JobPositionRepository;


@Service
public class JobPositionService {

	@Autowired
	private JobPositionRepository job_positionRepository;
	
	public List<JobPosition> getAllPositions() {
		return job_positionRepository.findAll();
	}
}
