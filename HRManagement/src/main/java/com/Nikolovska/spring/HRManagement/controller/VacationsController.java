package com.Nikolovska.spring.HRManagement.controller;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Nikolovska.spring.HRManagement.model.Employee;
import com.Nikolovska.spring.HRManagement.model.Vacations;
import com.Nikolovska.spring.HRManagement.service.EmployeeService;
import com.Nikolovska.spring.HRManagement.service.VacationsService;

@Controller
@SessionAttributes(names = "employee")
public class VacationsController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private VacationsService vacationsService;

	@RequestMapping(path = "/vacations", method = RequestMethod.GET)
	public String getVacations(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employee", employees);
		return "vacations";
	}

	@RequestMapping(path = "/vacations", method = RequestMethod.POST)
	public String vacationsEmployee(@ModelAttribute Vacations vacations, Model model) {
		Long vacations_days = new Long(0);
		if (vacations.getEmployee_id().getVacation_days() != null) {
			vacations_days = vacations.getEmployee_id().getVacation_days();
		}
		Long remainingDays = 23 - vacations_days;

		Calendar date_start = Calendar.getInstance();
		date_start = (Calendar) vacations.getStart_date().clone();
		Calendar end_date = vacations.getEnd_date();

		if (end_date.before(date_start)) {
			model.addAttribute("errorMessage", "End date can not be before start date!");
			return "vacations";

		} else {

//			for (Date date = date_start.getTime(); date_start.before(end_date); date_start.add(Calendar.DATE, 1)) {
//				int targetDay = date_start.get(Calendar.DAY_OF_WEEK);
//				if (targetDay != 6 && targetDay != 7) {
//					vacations_days++;
//				}
//			}

			vacations_days = CalculateVacationDays(date_start, vacations.getEnd_date(), vacations_days, 1);

			if (vacations_days <= 23) {

				vacationsService.updateVacationsDays(vacations.getEmployee_id().getId(), vacations_days);
				vacations = vacationsService.saveVacations(vacations);
				return "redirect:/menu";
			} else {
				model.addAttribute("errorMessage", "Remaining days: " + remainingDays);
				return "vacations";

			}
		}
	}

	@RequestMapping(path = "/delete-vacation/{id}", method = RequestMethod.GET)
	public String redirectVacations(@PathVariable Long id, Model model) {
		deleteVacation(id);
		return "redirect:/listvacations";
	}

	@RequestMapping(value = "/delete-vacation/{id}", method = RequestMethod.POST)
	public String deleteVacation(@RequestBody Long vacationID) {
		Optional<Vacations> optVacations = vacationsService.findById(vacationID);
		Vacations vacations = optVacations.get();
		Long vacations_days = new Long(0);
		if (vacations.getEmployee_id().getVacation_days() != null) {
			vacations_days = vacations.getEmployee_id().getVacation_days();
		}

		Calendar date_start = Calendar.getInstance();
		date_start = (Calendar) vacations.getStart_date().clone();
		Calendar end_date = vacations.getEnd_date();
//
//		for (Date date = date_start.getTime(); date_start.before(end_date); date_start.add(Calendar.DATE, 1)) {
//			int targetDay = date_start.get(Calendar.DAY_OF_WEEK);
//			if (targetDay != 6 && targetDay != 7) {
//				vacations_days--;
//			}
//		}

		vacations_days = CalculateVacationDays(date_start, vacations.getEnd_date(), vacations_days, 2);

		vacationsService.updateVacationsDays(vacations.getEmployee_id().getId(), vacations_days);
		vacationsService.deleteVacation(vacationID);
		return "redirect:/listvacations";
	}

	@RequestMapping(value = "/vacations/{id}", method = RequestMethod.GET)
	public String updateVacation(@PathVariable Long id, Model model) {

		Optional<Vacations> optVacations = vacationsService.findById(id);
		Vacations vacations = optVacations.get();

		Calendar start_date = vacations.getStart_date();
		Calendar end_date = vacations.getEnd_date();

		List<Employee> employee = employeeService.getAllEmployees();
		Optional<Employee> employeeTmpOpt = employeeService.findById(vacations.getEmployee_id().getId());
		Employee employeeTmp = employeeTmpOpt.get();
		Long employee_id = employeeTmp.getId();
		model.addAttribute("employee_id", employee_id);
		model.addAttribute("employee", employee);
		model.addAttribute("employeeTmp", employeeTmp);
		model.addAttribute("readonly", "readonly");
		model.addAttribute("start_date", start_date);
		model.addAttribute("end_date", end_date);	
		return "vacations";
	}

	@RequestMapping(value = "/vacations/{id}", method = RequestMethod.POST)
	public String updateVacation(@ModelAttribute Vacations vacations, Model model) {

		Long vacations_days = new Long(0);
		if (vacations.getEmployee_id().getVacation_days() != null) {
			vacations_days = vacations.getEmployee_id().getVacation_days();
		}

		Calendar date_start = Calendar.getInstance();
		date_start = (Calendar) vacations.getStart_date().clone();
		Calendar end_date = vacations.getEnd_date();

		vacations_days = CalculateVacationDays(date_start, vacations.getEnd_date(), vacations_days, 2);
		vacationsService.updateVacationsDays(vacations.getEmployee_id().getId(), vacations_days);
		vacationsService.updateVacations(vacations);
		return "redirect:/listvacations";
	}



	@RequestMapping(path = "/listvacations", method = RequestMethod.GET)
	public String getAllVacations(Model model) {

		List<Vacations> vacations = vacationsService.getAllVacations();
		model.addAttribute("vacations", vacations);
		return "listvacations";
	}

	public Long CalculateVacationDays(Calendar date_start, Calendar end_date, Long vacations_days, int method) {
		for (Date date = date_start.getTime(); date_start.before(end_date); date_start.add(Calendar.DATE, 1)) {
			int targetDay = date_start.get(Calendar.DAY_OF_WEEK);
			if (targetDay != 6 && targetDay != 7) {
				if (method == 1) {
					vacations_days++;
				} else {
					vacations_days--;
				}
			}
		}

		return vacations_days;
	}

}
