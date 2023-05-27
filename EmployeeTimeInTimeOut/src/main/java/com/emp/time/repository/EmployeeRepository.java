package com.emp.time.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emp.time.model.Employee;

@Repository
public class EmployeeRepository 
{
	private Session session;
	private Transaction transaction;
	
	@Autowired
	public EmployeeRepository(SessionFactory sessionFactory)
	{
		session = sessionFactory.openSession();
		transaction = session.getTransaction();
	}
	
	public void saveRecordRepo(Employee employee)
	{
		transaction.begin();
		session.persist(employee);
		transaction.commit();
	}

	public List<Employee> getListRepo() 
	{
		//Query<Employee> query = session.createQuery("from Employee where status = in");
		Query<Employee> query = session.createQuery("from Employee");
		List<Employee> employeeList = query.list();
		return employeeList;
	}
	
	public void updateOutStatusRepo(int eid)
	{
		Employee employee = session.load(Employee.class, eid);
		employee.setStatus("out");
		transaction.begin();
		session.update(employee);
		transaction.commit();
	}
	
	public void updateInStatusRepo(int empid)
	{
		Employee employee = session.load(Employee.class, empid);
		employee.setStatus("in");
		transaction.begin();
		session.update(employee);
		transaction.commit();
	}
}
