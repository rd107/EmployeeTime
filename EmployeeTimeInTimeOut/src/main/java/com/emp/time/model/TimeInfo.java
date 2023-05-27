package com.emp.time.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class TimeInfo 
{
	@Id
	@GeneratedValue(generator = "time_seq")
	@SequenceGenerator(name = "time_seq",initialValue = 100,allocationSize = 1)
	int tid;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "eid")
	Employee employee;
	
	long outtime;
	long intime;
	String totaltime;
	Date date;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public long getOuttime() {
		return outtime;
	}
	public void setOuttime(long outtime) {
		this.outtime = outtime;
	}
	public long getIntime() {
		return intime;
	}
	public void setIntime(long intime) {
		this.intime = intime;
	}
	public String getTotaltime() {
		return totaltime;
	}
	public void setTotaltime(String totaltime) {
		this.totaltime = totaltime;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
