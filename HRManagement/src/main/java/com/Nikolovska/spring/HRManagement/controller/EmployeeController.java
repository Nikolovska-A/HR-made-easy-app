package com.Nikolovska.spring.HRManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Nikolovska.spring.HRManagement.model.Employee;
import com.Nikolovska.spring.HRManagement.service.EmployeeService;

@Controller
//@SessionAttributes(names = "employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
		@RequestMapping(path = "/listemployees", method = RequestMethod.GET)
		public String getEmployees(Model model) {
//			if (model.getAttribute("id") == null) {
//				model.addAttribute("errorMessage", "Employee does not exist!");
//				return "redirect:/";
//			} else {
//				Employee employee = (Employee)model.getAttribute("employee");
				List<Employee> employees = employeeService.getAllEmployees();
				model.addAttribute("employees", employees);
				return "listemployees";
//			}
		}
		
		@RequestMapping(path = "/new_employee", method = RequestMethod.POST)
		public String registerEmployee(@RequestBody String body, Employee employee, Model model) {
			employee = employeeService.saveEmployee(employee);
			return "redirect:/menu";
		}	
				
		@RequestMapping(path = "/vacations", method = RequestMethod.GET)
		public String getVacations(Model model) {
				List<Employee> employee = employeeService.getAllEmployees();
				model.addAttribute("employees", employee);
				return "vacations";
		}
		
		@RequestMapping(path = "/vacations", method = RequestMethod.POST)
		public String vacationsEmployee(@RequestBody String body, Employee employee, Model model) {
			employee = employeeService.saveEmployee(employee);
			return "redirect:/menu";
		}
		
		
		@RequestMapping(path = "/new_employee/{id}", method = RequestMethod.GET)
		public String getEmployeeById(@PathVariable Long id, Model model) {
//			if (model.getAttribute("id") == null) {
//				model.addAttribute("errorMessage", "Not such employee!");
//				return "redirect:/";
//			} else {
//				Employee employee = (Employee)model.getAttribute("employee");
			    Optional<Employee> optEmployee = employeeService.findById(id);
			    Employee employee = optEmployee.get();
				model.addAttribute("employee_id", id);
				model.addAttribute("name",employee.getName());
				model.addAttribute("surname",employee.getSurname());
				model.addAttribute("personal_number",employee.getPersonal_number());
				model.addAttribute("birthyear",employee.getBirthyear());
				model.addAttribute("adress",employee.getAdress());
				model.addAttribute("phone",employee.getPhone());
				model.addAttribute("email",employee.getEmail());
				model.addAttribute("type_contract",employee.getType_contract());
				model.addAttribute("begin_date",employee.getBegin_date());
				model.addAttribute("end_date",employee.getEnd_date());
				model.addAttribute("salary",employee.getSalary());
				model.addAttribute("bonus",employee.getBonus());
//				model.addAttribute("job_position",vraboten.getJob_position());
//				model.addAttribute("items",vraboten.getItems());
				
				return "new_employee";
//			}
		}

		@RequestMapping(path = "/new_employee/{id}", method = RequestMethod.POST)
		public String updateEmployeeById(@RequestBody long id, Employee employee, Model model) {
			employee = employeeService.saveEmployee(employee);
			return "redirect:/listemployees";
		}	
}
