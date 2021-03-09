package com.Nikolovska.spring.HRManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Nikolovska.spring.HRManagement.model.Employee;
import com.Nikolovska.spring.HRManagement.service.EmployeeService;

@Controller
@SessionAttributes(names = "employee")

public class LoginController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping(path = "/login")
	public String getLogin() {
		return "login";
	}

	@PostMapping(path = "/login")
	public String postLogin(@RequestParam String username, @RequestParam String password, Model model) {
		if (username.equals("") || password.equals("")) {
			model.addAttribute("errorMessage", "Bad username or password!");
			return "login";
		}
		
		if (username.equals("hruser") && password.equals("hrpass123")) {
			return "redirect:/menu";
		}

		List<Employee> optEmployee = employeeService.getEmployee(username, password);
		if (!optEmployee.isEmpty()) {
			Employee employee = optEmployee.get(0);
			model.addAttribute("employee", employee);
			return "redirect:/menu";
		} else {
			model.addAttribute("errorMessage", "Bad username or password!");
			return "login";
		}
	}

}
