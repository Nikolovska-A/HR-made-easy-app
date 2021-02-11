package com.Nikolovska.spring.HRManagement.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VACATIONS")
public class Vacations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private Date start_date;
	private Date end_date;
	
	@ManyToOne()
	@JoinColumn(name="employee_id", referencedColumnName = "id", insertable = true, updatable = false)    
	private Employee employee;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

}
