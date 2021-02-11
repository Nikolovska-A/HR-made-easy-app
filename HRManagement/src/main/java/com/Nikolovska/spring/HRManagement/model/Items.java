package com.Nikolovska.spring.HRManagement.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ITEMS")

public class Items {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String type;

	@ManyToMany(mappedBy = "items")
	private List<Employee> employee = new ArrayList<Employee>();

	public Items() {
	}

	public Items(int id, String type)
	{
		this.id = id;
		this.type = type;
		
	}
    public Items(String type){
        this.type = type;
      }
      
//      public Items(String type, Set<Employee> employee){
//        this.type = type;
//        this.employee = employee;
//      }
//	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
//	public Set<Employee> getEmployee() {
//		return employee;
//		  }
//		  
//    public void setEmployee(Set<Employee> employee) {
//		 this.employee = employee;
//		  }

}
