package com.Nikolovska.spring.HRManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Nikolovska.spring.HRManagement.model.JobPosition;
import com.Nikolovska.spring.HRManagement.model.Items;
import com.Nikolovska.spring.HRManagement.service.JobPositionService;
import com.Nikolovska.spring.HRManagement.service.ItemsService;

@Controller
@SessionAttributes(names = "employee")
public class MenuController {
	
	@Autowired
	private ItemsService itemsService;
	
	@Autowired
	private JobPositionService jobpositionService;
	
	
	@GetMapping(path = "/menu")
	public String getMenu() {
		return "menu";
	}		
	
	@GetMapping(path = "/new_employee")
	public String getNew_employee(Model model) {
		List<Items> items = itemsService.getAllItems();
		List<JobPosition> job_position = jobpositionService.getAllPositions();
		model.addAttribute("items", items);		
	    model.addAttribute("job_position", job_position);	
	    return "new_employee";
	}
}
