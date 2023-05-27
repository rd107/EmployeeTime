package com.emp.time.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emp.time.model.Employee;
import com.emp.time.model.TimeInfo;
import com.emp.time.service.EmployeeService;
import com.emp.time.service.TimeService;

@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private TimeService timeService;
	
	@RequestMapping("add-employee")
	public String addEmployeePage()
	{
		return "add-employee";
	}
	
	@RequestMapping("save-record-controller")
	public String saveRecordController(Employee employee,Model model)
	{
		employeeService.saveRecordService(employee);
		model.addAttribute("msg", "Record with "+employee.getEid()+" saved.");
		return "add-employee";
	}
	
	@RequestMapping("employee-timeout")
	public String getEmployeeList1(Model model)
	{
		List<Employee> employeeList = employeeService.getEmployeeListService();
		model.addAttribute("elist", employeeList);
		return "employee-inlist";
	}

	@RequestMapping("record-outtime-controller")
	public String saveOutTime(TimeInfo timeinfo,@RequestParam("eid") int eid,Model model)
	{
		timeService.updateOutTimeService(timeinfo,eid);
		employeeService.updateOutStatusService(eid);
		model.addAttribute("msg","Employee id "+eid+" out time saved.");
		return "record-outtime";
	}
	
	@RequestMapping("employee-timein")
	public String getEmployeeList2(Model model)
	{
		List<Employee> employeeList = employeeService.getEmployeeListService();
		model.addAttribute("plist", employeeList);
		return "employee-outlist";	
	}
	
	@RequestMapping("update-intime-controller")
	public String saveInTime(TimeInfo timeinfo,@RequestParam("empid") int empid,Model model)
	{
		timeService.updateInTimeService(timeinfo,empid);
		employeeService.updateInStatusService(empid);
		model.addAttribute("msg", "Employee id "+empid+" in time saved");
		return "update-intime";
	}
	
	@RequestMapping("choose-date")
	public String getChooseDate()
	{
		return "choose-date";
	}
}
