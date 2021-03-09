package com.Nikolovska.spring.HRManagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.multipart.MultipartFile;

import com.Nikolovska.spring.HRManagement.model.Employee;
import com.Nikolovska.spring.HRManagement.model.Items;
import com.Nikolovska.spring.HRManagement.model.JobPosition;
import com.Nikolovska.spring.HRManagement.model.Vacations;
import com.Nikolovska.spring.HRManagement.service.EmployeeService;
//import com.Nikolovska.spring.HRManagement.service.FilesService;
import com.Nikolovska.spring.HRManagement.service.ItemsService;
import com.Nikolovska.spring.HRManagement.service.JobPositionService;
import com.Nikolovska.spring.HRManagement.service.VacationsService;

@Controller
@SessionAttributes(names = "employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private VacationsService vacationsService;

	@Autowired
	private ItemsService itemsService;

	@Autowired
	private JobPositionService jobpositionService;

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

	@RequestMapping(path = "/new_employee/view/{id}", method = RequestMethod.GET)
	public String viewEmployeeByName(@PathVariable Long id, Model model) {
		List<Vacations> vacations = vacationsService.findByEmployee_id(id);

		model.addAttribute("vacations", vacations);
		model.addAttribute("disabled", "disabled");
//		model.addAttribute("checkedItem", "checked");
		model.addAttribute("selected", "selected");
		getEmployeeByName(id, model);
		Optional<Employee> optEmployee = employeeService.findById(id);
		Employee employee = optEmployee.get();
		List<Items> items = employee.getItems();
		if (items != null) {
			model.addAttribute("items", items);
			model.addAttribute("checkedItem", "checked");
		}
		return "new_employee";
	}

	@RequestMapping(path = "/new_employee/{id}", method = RequestMethod.GET)
	public String getEmployeeByName(@PathVariable Long id, Model model) {

		Optional<Employee> optEmployee = employeeService.findById(id);
		Employee employee = optEmployee.get();
		model.addAttribute("employee_id", id);
		model.addAttribute("name", employee.getName());
		model.addAttribute("surname", employee.getSurname());
		model.addAttribute("personal_number", employee.getPersonal_number());
		model.addAttribute("birthyear", employee.getBirthyear());
		model.addAttribute("adress", employee.getAdress());
		model.addAttribute("phone", employee.getPhone());
		model.addAttribute("email", employee.getEmail());
		model.addAttribute("type_contract", employee.getType_contract());
		model.addAttribute("begin_date", employee.getBegin_date());
		model.addAttribute("end_date", employee.getEnd_date());
		model.addAttribute("salary", employee.getSalary());
		model.addAttribute("bonus", employee.getBonus());
		model.addAttribute("username", employee.getUsername());
		model.addAttribute("password", employee.getPassword());
		JobPosition job_position_tmp = employee.getJob_position();
		List<JobPosition> job_position = jobpositionService.getAllPositions();

		job_position.add(job_position_tmp);
		if (job_position != null) {
			model.addAttribute("job_position", job_position);
		}

		List<Items> items = itemsService.getAllItems();
//		model.addAttribute("items", items);

//		List<Items> items = employee.getItems();
		if (items != null) {
			model.addAttribute("items", items);
		}

		model.addAttribute("job_position_tmp", job_position_tmp);
		return "new_employee";
	}

	@RequestMapping(path = "/new_employee/{id}", method = RequestMethod.POST)
	public String updateEmployeeById(@PathVariable Long id, Employee employee, Model model) {
		employeeService.updateEmplpoyee(employee);

		return "redirect:/listemployees";
	}
}
