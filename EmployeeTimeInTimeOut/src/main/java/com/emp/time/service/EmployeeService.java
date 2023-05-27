package com.emp.time.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.time.model.Employee;
import com.emp.time.repository.EmployeeRepository;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void saveRecordService(Employee employee)
	{
		employeeRepository.saveRecordRepo(employee);
	}
	
	public List<Employee> getEmployeeListService()
	{
		return employeeRepository.getListRepo();			
	}
	
	public void updateOutStatusService(int eid)
	{
		employeeRepository.updateOutStatusRepo(eid);
	}
	
	public void updateInStatusService(int empid)
	{
		employeeRepository.updateInStatusRepo(empid);
	}
}
