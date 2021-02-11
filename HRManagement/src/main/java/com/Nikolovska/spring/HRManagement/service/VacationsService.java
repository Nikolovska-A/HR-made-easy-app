package com.Nikolovska.spring.HRManagement.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Nikolovska.spring.HRManagement.model.Vacations;

@Service
public class VacationsService {
	private static List<Vacations> vacation = new ArrayList<Vacations>();


public void addVacation( Date begin_date, Date end_date,
        boolean isDone) {
    vacation.add(new Vacations());
}

}
