package com.emp.time.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.time.model.TimeInfo;
import com.emp.time.repository.TimeRepository;

@Service
public class TimeService 
{
	@Autowired
	private TimeRepository timeRepository;
	
	public void updateOutTimeService(TimeInfo timeinfo,int eid)
	{
		timeRepository.updateOutTimeRepo(timeinfo,eid);
	}
	
	public void updateInTimeService(TimeInfo timeinfo,int empid)
	{
		timeRepository.updateInTimeRepo(timeinfo,empid);
	}

	public List<TimeInfo> getDateListService(Date date) 
	{
		return timeRepository.getDateListRepo(date);
	}
	
}
