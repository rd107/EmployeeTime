package com.emp.time.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emp.time.model.Employee;
import com.emp.time.model.TimeInfo;

@Repository
public class TimeRepository 
{
	private Session session;
	private Transaction transaction;
	
	@Autowired
	public TimeRepository(SessionFactory sessionFactory)
	{
		session = sessionFactory.openSession();
		transaction = session.getTransaction();
	}
	
	public void updateOutTimeRepo(TimeInfo timeinfo,int eid)
	{
		Employee employee = session.get(Employee.class, eid);
			timeinfo.setDate(Date.valueOf(LocalDate.now()));
			timeinfo.setEmployee(employee);
			timeinfo.setOuttime(System.currentTimeMillis());
			transaction.begin();
			session.persist(timeinfo);
			transaction.commit();
	}
	
	public void updateInTimeRepo(TimeInfo timeinfo,int empid)
	{
		Employee employee = session.get(Employee.class, empid);
		timeinfo = session.get(TimeInfo.class, empid);
			timeinfo.setDate(Date.valueOf(LocalDate.now()));
			timeinfo.setEmployee(employee);
			timeinfo.setIntime(System.currentTimeMillis());
			long l1 = timeinfo.getOuttime();
			long l2 = timeinfo.getIntime();
			long result = 0l;
			long sec = 0l;
			long min = 0l;
			long hr = 0l;
			String mstr = "";
			if(l1>l2)
			{
				result = l1-l2;
			}
			else
			{
				result = l2-l1;
			}
			sec = (result/1000)%60;
			min = (result/(1000*60))%60;
			hr = (result/(1000*60*60))%24;
			mstr = hr+"hr"+min+"min"+sec+"secs";
			timeinfo.setTotaltime(mstr);
			transaction.begin();
			session.persist(timeinfo);
			transaction.commit();
	}

}
