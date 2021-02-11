package com.Nikolovska.spring.HRManagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "JOB_POSITION")
public class JobPosition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String description;
	
    @OneToOne(mappedBy = "job_position")
    private Employee employee;
	
	
	public JobPosition() {
		super();
	}
	
    public JobPosition(int id, String description){
    	this.id = id;
        this.description = description;
      }
    
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString()
	{
		return description;
	}

}
