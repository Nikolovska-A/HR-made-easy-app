package com.Nikolovska.spring.HRManagement.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@OneToMany(mappedBy = "employee_id", cascade = CascadeType.ALL)
	private List<Vacations> vacations = new ArrayList<>();
	

	public List<Vacations> getVacations() {
		return vacations;
	}

	public void setVacations(List<Vacations> vacations) {
		this.vacations = vacations;
	}
	
	@OneToMany(mappedBy = "employee_id", cascade = CascadeType.ALL)
	private List<FileDB> files = new ArrayList<>();
	

	public List<FileDB> getFiles() {
		return files;
	}

	public void setFile(List<FileDB> files) {
		this.files = files;
	}

	private String name;
	private String surname;
	private String personal_number;
	private int birthyear;
	private String adress;
	private String phone;
	private String email;
	private String type_contract;
	private String begin_date;
	private String end_date;
	private int salary;
	private int bonus;
	private Long vacation_days;

	private String username;
	private String password;

	// for job position
	@ManyToOne
	@JoinColumn(name = "job_position", referencedColumnName = "id")
	private JobPosition job_position;

	public JobPosition getJob_position() {
		return job_position;
	}

	public void setJob_position(JobPosition job_position) {
		this.job_position = job_position;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "EMPLOYEE_ITEMS", joinColumns = @JoinColumn(name = "id_employee", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_zadolzenija", referencedColumnName = "id"))
	private List<Items> items = new ArrayList<Items>();
	

	public Employee() {

	}

	public Employee(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPersonal_number() {
		return personal_number;
	}

	public void setPersonal_number(String personal_number) {
		this.personal_number = personal_number;
	}

	public int getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType_contract() {
		return type_contract;
	}

	public void setType_contract(String type_contract) {
		this.type_contract = type_contract;
	}

	public String getBegin_date() {
		return begin_date;
	}

	public void setBegin_date(String begin_date) {
		this.begin_date = begin_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public Long getVacation_days() {
		return vacation_days;
	}

	public void setVacation_days(Long days) {
		this.vacation_days = days;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void main(String[] args) {
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
	
//	public Employee(String name, String surname, String username, String password, JobPosition job_position ) {
////		this.id = id;
//		this.name = name;
//		this.surname = surname;
//		this.username = username;
//		this.password = password;
//		this.job_position = job_position;
//		
//	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Employee other = (Employee) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

}
